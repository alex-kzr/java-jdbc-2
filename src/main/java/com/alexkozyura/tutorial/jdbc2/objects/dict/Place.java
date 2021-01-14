package com.alexkozyura.tutorial.jdbc2.objects.dict;

public class Place {

    private long id;
    private String seatLetter;
    private int seatNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSeatLetter() {
        return seatLetter;
    }

    public void setSeatLetter(String seatLetter) {
        this.seatLetter = seatLetter;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
