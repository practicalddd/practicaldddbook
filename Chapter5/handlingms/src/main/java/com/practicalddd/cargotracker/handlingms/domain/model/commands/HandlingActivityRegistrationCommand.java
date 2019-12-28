package com.practicalddd.cargotracker.handlingms.domain.model.commands;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Command to Register an Handling Activity
 */
@AllArgsConstructor
@Getter
@Setter
public class HandlingActivityRegistrationCommand {

    private String bookingId;
    private String voyageNumber;
    private String unLocode;
    private String handlingType;
    private Date completionTime;

}
