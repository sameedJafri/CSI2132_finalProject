package com.ehotels.model;

public class AvailableRoom {
    private String area;
    private int availableRooms;

    public AvailableRoom(String area, int availableRooms) {
        this.area = area;
        this.availableRooms = availableRooms;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }
}
