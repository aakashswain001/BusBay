package com.example.aakas.busbay;

/**
 * Created by aakas on 3/11/2018.
 */

public class Bus {
    int id, maxSeat, seatFilled, maxLength, length;
    String route;

    public Bus() {
    }

    public Bus(int id, int maxSeat, int seatFilled, int maxLength, int length, String route) {
        this.id = id;
        this.maxSeat = maxSeat;
        this.seatFilled = seatFilled;
        this.maxLength = maxLength;
        this.length = length;
        this.route = route;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxSeat() {
        return maxSeat;
    }

    public void setMaxSeat(int maxSeat) {
        this.maxSeat = maxSeat;
    }

    public int getSeatFilled() {
        return seatFilled;
    }

    public void setSeatFilled(int seatFilled) {
        this.seatFilled = seatFilled;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
