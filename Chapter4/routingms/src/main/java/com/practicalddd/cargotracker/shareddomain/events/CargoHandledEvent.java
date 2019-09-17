package com.practicalddd.cargotracker.shareddomain.events;

import com.practicalddd.rabbitadaptor.cdi.ContainsContent;

public class CargoHandledEvent implements ContainsContent<CargoHandledEventData> {

    private CargoHandledEventData cargoHandledEventData;
    public void setContent(CargoHandledEventData cargoHandledEventData) { this.cargoHandledEventData = cargoHandledEventData; }
    public CargoHandledEventData getContent() {
        return cargoHandledEventData;
    }
}
