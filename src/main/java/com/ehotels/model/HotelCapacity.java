package com.ehotels.model;

public class HotelCapacity {
    private String hotelName;
    private int totalCapacity;

    public HotelCapacity(String hotelName, int totalCapacity) {
        this.hotelName = hotelName;
        this.totalCapacity = totalCapacity;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }
}
