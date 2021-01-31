package operations.tickets;

import model.Ticket;
import operations.statistics.StatisticsOperations;
import operations.time.TimeOperations;
import operations.time.TimeZoneProvider;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class TicketsStats {

    private final List<Ticket> tickets;
    private final TimeZoneProvider timeZoneProvider;
    private final TimeOperations timeOperations;
    private final StatisticsOperations statisticsOperations;

    public TicketsStats(
            List<Ticket> tickets,
            TimeZoneProvider timeZoneProvider,
            TimeOperations timeOperations,
            StatisticsOperations statisticsOperations)
            throws Exception {
        if (tickets == null || tickets.isEmpty()) {
            throw new Exception("Ticket list should have at least one ticket");
        }
        this.tickets = tickets;
        this.timeZoneProvider = timeZoneProvider;
        this.timeOperations = timeOperations;
        this.statisticsOperations = statisticsOperations;
    }

    public long getFlightTime(Ticket ticket) {
        return getFlightTimeInMinutes(ticket);
    }

    public long getAverageFlightTime() {
        return getAverageFlightTime(tickets);
    }

    public long getFlightTimePercentile() {
        return getFlightTimePercentile(tickets, 90);
    }

    public long getAverageFlightTime(List<Ticket> tickets) {
        double average = getAverageFlightTimeInMinutes(tickets);
        return (long) average;
    }

    public long getFlightTimePercentile(List<Ticket> tickets, double percentile) {
        List<Long> sortedFlightTimes = tickets
                .stream()
                .map(this::getFlightTimeInMinutes)
                .collect(Collectors.toList());
        return (long) statisticsOperations.getPercentileItemFromList(sortedFlightTimes, percentile);
    }

    private long getFlightTimeInMinutes(Ticket ticket) {
        LocalDate departureDate = ticket.getDepartureDate();
        LocalTime departureTime = ticket.getDepartureTime();
        TimeZone departureTimeZone = timeZoneProvider.getTimeZoneForCity(ticket.getOriginName());
        ZonedDateTime departure = timeOperations.getZonedDateTime(departureDate, departureTime, departureTimeZone);

        LocalDate arrivalDate = ticket.getArrivalDate();
        LocalTime arrivalTime = ticket.getArrivalTime();
        TimeZone arrivalTimeZone = timeZoneProvider.getTimeZoneForCity(ticket.getDestinationName());
        ZonedDateTime arrival = timeOperations.getZonedDateTime(arrivalDate, arrivalTime, arrivalTimeZone);

        return timeOperations.getIntervalBetweenTwoDatesInMinutes(departure, arrival);
    }

    private double getAverageFlightTimeInMinutes(List<Ticket> tickets) {
        return tickets.stream().mapToLong(this::getFlightTimeInMinutes).average().getAsDouble();
    }

}
