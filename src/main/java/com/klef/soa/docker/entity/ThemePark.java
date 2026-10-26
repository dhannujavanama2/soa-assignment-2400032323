package com.klef.soa.docker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "ThemePark")
public class ThemePark {

    @Id
    private Long id;

    private String parkName;
    private String location;
    private Integer rideCount;
    private Double ticketPrice;

    public ThemePark() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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