package com.klef.soa.docker.dto;

public class ThemeParkRequest {

    private String parkName;
    private String location;
    private Integer rideCount;
    private Double ticketPrice;

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getRideCount() {
        return rideCount;
    }

    public void setRideCount(Integer rideCount) {
        this.rideCount = rideCount;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}