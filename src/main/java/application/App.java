package application;

import model.Ticket;
import operations.json.JsonParser;
import presentation.AppPresenter;
import operations.statistics.StatisticsOperations;
import operations.tickets.TicketsStats;
import operations.time.TimeOperations;
import operations.time.TimeZoneProvider;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        JsonParser parser = new JsonParser();

        TimeOperations timeOperations = new TimeOperations();
        TimeZoneProvider timeZoneProvider = new TimeZoneProvider();
        StatisticsOperations statisticsOperations = new StatisticsOperations<>();
        AppPresenter presenter = new AppPresenter();

        presenter.welcomeMessage();
        String filePath = scanner.nextLine();
        scanner.close();

        List<Ticket> tickets;
        try {
            tickets = parser.getTicketsFromFileOrDefault(filePath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        TicketsStats stats = new TicketsStats(tickets, timeZoneProvider, timeOperations, statisticsOperations);
        long avgTime = stats.getAverageFlightTime();
        long percentileTime = stats.getFlightTimePercentile();
        presenter.printAverageFlightTime(avgTime);
        presenter.printPercentileFlightTime(percentileTime, 90);
    }

}
