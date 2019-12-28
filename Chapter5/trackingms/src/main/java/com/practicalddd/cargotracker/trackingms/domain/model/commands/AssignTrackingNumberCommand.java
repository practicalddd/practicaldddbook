package com.practicalddd.cargotracker.trackingms.domain.model.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Assign Tracking Number Command class
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AssignTrackingNumberCommand {

    private String bookingId;
    private String trackingNumber;

}
