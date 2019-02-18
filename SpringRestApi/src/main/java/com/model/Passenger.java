package com.model;

public class Passenger {
    String first_name;
    String lst_name;
    int booking_id;
    String seat;
    String ticketType;     //should be made as enum

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticket) {
        this.ticketType = ticket;
    }

    public Passenger()
    {}

    public Passenger(String fname, String lname, int bid, String seat_num, String ticketType)
    {
        this.first_name = fname;
        this.lst_name = lname;
        this.booking_id = bid;
        this.seat = seat_num;
        this.ticketType = ticketType;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLst_name() {
        return lst_name;
    }

    public void setLst_name(String lst_name) {
        this.lst_name = lst_name;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }




}
