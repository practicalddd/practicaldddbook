package com.practicalddd.cargotracker.shareddomain.events;


/**
 * Event Class for the Cargo Routed Event. Wraps up the Cargo
 */

public class CargoRoutedEvent {

    private CargoRoutedEventData cargoRoutedEventData;

    // TODO rename?
    public void setContent(CargoRoutedEventData cargoRoutedEventData) {
        this.cargoRoutedEventData = cargoRoutedEventData;
    }

    // TODO rename?
    public CargoRoutedEventData getContent() {
        return cargoRoutedEventData;
    }
}