package com.practicalddd.cargotracker.shareddomain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CargoHandledEvent {

    private CargoHandledEventData cargoHandledEventData;

}
