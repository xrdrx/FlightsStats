package model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class Tickets {

    @SerializedName("tickets")
    @Expose
    private List<Ticket> tickets;

    public List<Ticket> getTickets() {
        return tickets;
    }

}
