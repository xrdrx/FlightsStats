package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public final class Ticket {

    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("origin_name")
    @Expose
    private String originName;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("destination_name")
    @Expose
    private String destinationName;
    @SerializedName("departure_date")
    @Expose
    private LocalDate departureDate;
    @SerializedName("departure_time")
    @Expose
    private LocalTime departureTime;
    @SerializedName("arrival_date")
    @Expose
    private LocalDate arrivalDate;
    @SerializedName("arrival_time")
    @Expose
    private LocalTime arrivalTime;
    @SerializedName("carrier")
    @Expose
    private String carrier;
    @SerializedName("stops")
    @Expose
    private Integer stops;
    @SerializedName("price")
    @Expose
    private BigDecimal price;

    public String getOrigin() {
        return origin;
    }

    public String getOriginName() {
        return originName;
    }

    public String getDestination() {
        return destination;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public String getCarrier() {
        return carrier;
    }

    public Integer getStops() {
        return stops;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
