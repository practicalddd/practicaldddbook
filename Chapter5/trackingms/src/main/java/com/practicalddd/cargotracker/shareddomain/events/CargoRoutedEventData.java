package com.practicalddd.cargotracker.shareddomain.events;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Event Data for the Cargo Routed Event
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CargoRoutedEventData {

    private String bookingId;

}
