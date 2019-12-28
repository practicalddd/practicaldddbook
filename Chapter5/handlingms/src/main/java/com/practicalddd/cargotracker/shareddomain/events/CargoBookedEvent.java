package com.practicalddd.cargotracker.shareddomain.events;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Event Class for the Cargo Booked Event. Wraps up the Cargo Booking identifier
 * for the event
 */

@NoArgsConstructor
@AllArgsConstructor
public class CargoBookedEvent {

    private CargoBookedEventData cargoBookedEventData;

}
