package operations.tickets;

import model.Ticket;

import operations.json.JsonParser;
import operations.statistics.StatisticsOperations;
import org.junit.jupiter.api.Test;
import operations.time.TimeOperations;
import operations.time.TimeZoneProvider;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class TicketsStatsTest {

    private List<Ticket> tickets = new JsonParser().getDefaultTicketsList();
    private TimeZoneProvider tzProvider = new TimeZoneProvider();
    private TimeOperations timeOperations = new TimeOperations();
    private StatisticsOperations statisticsOperations = new StatisticsOperations();
    private TicketsStats stats;

    {
        try {
            stats = new TicketsStats(tickets, tzProvider, timeOperations, statisticsOperations);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void flightTimeTest() {
        Ticket ticket = tickets.get(0);
        long result = stats.getFlightTime(ticket);
        assertEquals(770, result);
    }

    @Test
    public void avgFlightTimeOneTicketTest() {
        List<Ticket> testTickets = new ArrayList<>();
        testTickets.add(tickets.get(0));
        long avgTime = stats.getAverageFlightTime(testTickets);
        assertEquals(770, avgTime);
    }

    @Test
    public void avgFlightTimeTwoTicketsTest() {
        List<Ticket> testTickets = new ArrayList<>();
        testTickets.add(tickets.get(0));
        testTickets.add(tickets.get(1));
        long avgTime = stats.getAverageFlightTime(testTickets);
        assertEquals(790, avgTime);
    }

    @Test
    public void avgFlightTimeAllTicketsTest() {
        long avgTime = stats.getAverageFlightTime(tickets);
        assertEquals(872, avgTime);
    }

    @Test
    public void percentileOneTicketTest() {
        List<Ticket> testTickets = new ArrayList<>();
        testTickets.add(tickets.get(0));
        long percentile = stats.getFlightTimePercentile(testTickets, 60);
        assertEquals(770, percentile);
    }

    @Test
    public void percentileThreeTicketTest() {
        List<Ticket> testTickets = new ArrayList<>();
        testTickets.add(tickets.get(0));
        testTickets.add(tickets.get(1));
        testTickets.add(tickets.get(2));
        long percentile = stats.getFlightTimePercentile(testTickets, 90);
        assertEquals(810, percentile);
    }

    @Test
    public void percentileAllTicketTest() {
        long percentile = stats.getFlightTimePercentile(tickets, 90);
        assertEquals(1005, percentile);
    }

    @Test
    public void statsWithNoTicketsThrowsExceptionTest() {
        List<Ticket> noTickets = new ArrayList<>();
        assertThrows(Exception.class, () -> new TicketsStats(noTickets, tzProvider, timeOperations, statisticsOperations));
    }

}