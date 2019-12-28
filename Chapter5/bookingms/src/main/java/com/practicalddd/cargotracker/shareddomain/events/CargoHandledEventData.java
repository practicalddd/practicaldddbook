package com.practicalddd.cargotracker.shareddomain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Event Data for the Cargo Handled Event
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CargoHandledEventData {

    private String bookingId;
    private String handlingType;
    private Date handlingCompletionTime;
    private String handlingLocation;
    private String voyageNumber;

}
