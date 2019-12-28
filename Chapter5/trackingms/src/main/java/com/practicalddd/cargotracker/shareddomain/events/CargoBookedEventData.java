package com.practicalddd.cargotracker.shareddomain.events;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Event Data for the Cargo Booked Event
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CargoBookedEventData {

    private String bookingId;

}
