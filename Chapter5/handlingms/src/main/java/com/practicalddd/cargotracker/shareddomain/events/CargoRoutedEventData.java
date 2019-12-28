package com.practicalddd.cargotracker.shareddomain.events;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Event Data for the Cargo Routed Event
 */

@AllArgsConstructor
@Getter
public class CargoRoutedEventData {

    private String bookingId;

}
