package com.cmpe275.project.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;


public class TicketMapper {

	private long id;
	private int numberofPassenger ;
    private String source;
    private String destination ;
    private int price ;
    private long bookedBy;
    private String bookingDate ;
    private String tripType;
    private String travelingDate ;
    private String bookingStatus;
    public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@JsonProperty("ticketDetail")
    private List<TicketDetailMapper> ticketDetailMapper;
    @JsonProperty("traveller")
    private List<TravellerMapper> travellerMapper;

    public TicketMapper(){

    };

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    public int getNumberofPassenger() {
        return numberofPassenger;
    }

    public void setNumberofPassenger(int numberofPassenger) {
        this.numberofPassenger = numberofPassenger;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(long bookedBy) {
        this.bookedBy = bookedBy;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getTravelingDate() {
        return travelingDate;
    }

    public void setTravelingDate(String travelingDate) {
        this.travelingDate = travelingDate;
    }

    public List<TicketDetailMapper> getTicketDetailMapper() {
        return ticketDetailMapper;
    }

    public void setTicketDetailMapper(List<TicketDetailMapper> ticketDetailMapper) {
        this.ticketDetailMapper = ticketDetailMapper;
    }

    public List<TravellerMapper> getTravellerMapper() {
        return travellerMapper;
    }

    public void setTravellerMapper(List<TravellerMapper> travellerMapper) {
        this.travellerMapper = travellerMapper;
    }
}


