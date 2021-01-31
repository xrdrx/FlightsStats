package operations.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import model.Ticket;
import model.Tickets;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class JsonParser {

    public List<Ticket> getTicketsFromFileOrDefault(String filePath) throws FileNotFoundException {
        if (filePath.isEmpty()) {
            return getDefaultTicketsList();
        }
        FileReader reader = new FileReader(filePath);
        Gson gson = setUpTicketGson();
        return gson.fromJson(reader, Tickets.class).getTickets();
    }

    public List<Ticket> getDefaultTicketsList() {
        InputStream resource = getClass().getClassLoader().getResourceAsStream("tickets.json");
        InputStreamReader in = new InputStreamReader(resource);
        Gson gson = setUpTicketGson();
        return gson.fromJson(in, Tickets.class).getTickets();
    }

    private Gson setUpTicketGson() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:m");
        return new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, typeOfT, context) ->
                        LocalDate.parse(json.getAsString(), formatter))
                .registerTypeAdapter(LocalTime.class, (JsonDeserializer<LocalTime>) (json, typeOfT, context) ->
                        LocalTime.parse(json.getAsString(), timeFormatter))
                .create();
    }

}
