package com.repository;

/*
This class is for the CRUD operations like a DAO
 */
import com.model.Passenger;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PassengerRepository {
    Map passengers_map = new HashMap();
    int counter_id = 1000;                 //counter for generating booking ids
    //static ArrayList eco_seats_available = {"1","2","3","4","5","6","7","8","9","10"};
    ArrayList<String> eco_seats_available = new ArrayList<String>(
            Arrays.asList("1", "2", "3","4","5","6","7","8","9","10"));
    //static String[] buss_seats_available = {"A","B","C","D","E","F","G","H","I","J"};
    ArrayList<String> buss_seats_available = new ArrayList<String>(
            Arrays.asList("A","B","C","D","E","F","G","H","I","J"));


    //This functions saves some trial data in the map by only incrementing booking id
    public void save()
    {
        Passenger p_eco = new Passenger("Jane", "Doe",123, "-1", "economy");
        Passenger p_busi = new Passenger("Jane", "Doe",123, "-1", "business");
        p_eco.setBooking_id(counter_id);
        counter_id += 1;
        p_busi.setBooking_id(counter_id);
        counter_id += 1;
        passengers_map.put(p_eco.getBooking_id(), p_eco);
        passengers_map.put(p_busi.getBooking_id(), p_busi);
        //return p;                         //return void could be better
    }


    //This function searches by booking id
    public Passenger findById(int id)
    {
        if(passengers_map.containsKey(id))
        {
            return (Passenger)passengers_map.get(id);
        }
        return null;
    }

    public Collection findAll(){
        return passengers_map.values();
    }


    //This function returns the seating type.
    // Assumption: economy class passengers get coach seating and business class passengers get 1st class seating area
    public String getSeating(int booking_id)
    {
        if(passengers_map.containsKey(booking_id)) {
            Passenger p = (Passenger) passengers_map.get(booking_id);
            String ticketType = p.getTicketType();
            if (ticketType == "economy")
                return "Coach";
            return "1st Class";
        }
        return "null";                           //return Error code here

    }


    //This function validates if the combination of booking id and ticket type exist for a passenger
    public Passenger validateReservationTicket(String ticket, int booking_id)
    {
        Passenger p = null;
        if(passengers_map.containsKey(booking_id))
        {
            p = (Passenger)passengers_map.get(booking_id);
            if(p.getTicketType() != ticket)
                return null;
        }
        return p;
    }


    //This function returns available seating based on ticket type
    public ArrayList available_seats(int booking_id)
    {
        if(passengers_map.containsKey(booking_id)) {

            Passenger p = (Passenger) passengers_map.get(booking_id);
            String ticketType = p.getTicketType();
            if (ticketType == "business")
                return buss_seats_available;
            else
                return eco_seats_available;
        }
        return null;                        //return Error code here
    }


    public Passenger hold_seat(int booking_id, String seat)
    {
        Passenger p = null;
        if(passengers_map.containsKey(booking_id)) {
            p = (Passenger) passengers_map.get(booking_id);
            String ticketType = p.getTicketType();
            if (ticketType == "business" && buss_seats_available.contains(seat))
            {
                p.setSeat(seat);
                buss_seats_available.remove(seat);
            }
            else if (ticketType == "economy" && eco_seats_available.contains(seat))
            {
                p.setSeat(seat);
                eco_seats_available.remove(seat);
            }
             else
                return null;                   //return Error code here
        }
        return p;
    }
}
