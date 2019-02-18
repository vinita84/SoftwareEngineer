package com.controllers;


import com.exception.PassengerNotFoundException;
import com.model.Passenger;
import com.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    private final PassengerRepository repository;

    @Autowired
    public PassengerController(PassengerRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/get")
    Collection getPassengers(){
        this.repository.save();
        return this.repository.findAll();
    }

    @PutMapping("/addseating/{bid}/{seat}")
    public ResponseEntity<Void> addSeating(@PathVariable int bid, @PathVariable String seat) {
        //Passenger result = this.repository.save();
        Passenger p = this.repository.hold_seat(bid, seat);
        if(p == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(p.getBooking_id()).toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping("/seatType/{id}")
    String getSeatingType(@PathVariable int id) {
        return this.repository.getSeating(id);
              //  .orElseThrow(PassengerNotFoundException::new);
    }


    @GetMapping("/availableseats/{id}")
    ArrayList availableSeating(@PathVariable int id) {
        return this.repository.available_seats(id);
        //  .orElseThrow(PassengerNotFoundException::new);
    }

    @PostMapping("/validateReservation/{seat}")
    public ResponseEntity<Void> validateReservation(@PathVariable int bid, @PathVariable String ticketType) {
        Passenger p = this.repository.validateReservationTicket(ticketType, bid);
        if(p == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(p.getBooking_id()).toUri();
        return ResponseEntity.created(location).build();
    }

}
