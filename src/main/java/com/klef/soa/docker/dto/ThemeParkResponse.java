package com.klef.soa.docker.dto;

public class ThemeParkResponse
{
    private Long id;
    private String parkName;
    private String location;
    private Integer rideCount;
    private Double ticketPrice;

    public ThemeParkResponse()
    {
    }

    public ThemeParkResponse(Long id, String parkName, String location,
                             Integer rideCount, Double ticketPrice)
    {
        this.id = id;
        this.parkName = parkName;
        this.location = location;
        this.rideCount = rideCount;
        this.ticketPrice = ticketPrice;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getParkName()
    {
        return parkName;
    }

    public void setParkName(String parkName)
    {
        this.parkName = parkName;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public Integer getRideCount()
    {
        return rideCount;
    }

    public void setRideCount(Integer rideCount)
    {
        this.rideCount = rideCount;
    }

    public Double getTicketPrice()
    {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice)
    {
        this.ticketPrice = ticketPrice;
    }
}