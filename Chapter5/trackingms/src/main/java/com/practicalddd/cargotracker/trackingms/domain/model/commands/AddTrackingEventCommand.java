package com.practicalddd.cargotracker.trackingms.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Add Tracking Event Command
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddTrackingEventCommand {

    private String bookingId;
    private Date eventTime;
    private String eventType;
    private String location;
    private String voyageNumber;

}
