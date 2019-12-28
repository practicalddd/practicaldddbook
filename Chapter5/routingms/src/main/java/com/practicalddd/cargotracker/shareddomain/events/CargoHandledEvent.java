package com.practicalddd.cargotracker.shareddomain.events;

public class CargoHandledEvent {

    private CargoHandledEventData cargoHandledEventData;

    // TODO rename?
    public void setContent(CargoHandledEventData cargoHandledEventData) {
        this.cargoHandledEventData = cargoHandledEventData;
    }

    // TODO rename?
    public CargoHandledEventData getContent() {
        return cargoHandledEventData;
    }
}
