package com.practicalddd.cargotracker.shareddomain.events;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Event Class for the Cargo Routed Event. Wraps up the Cargo
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CargoRoutedEvent {

    private CargoRoutedEventData cargoRoutedEventData;

}