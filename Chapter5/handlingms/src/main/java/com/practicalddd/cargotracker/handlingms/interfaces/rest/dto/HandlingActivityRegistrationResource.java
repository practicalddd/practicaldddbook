package com.practicalddd.cargotracker.handlingms.interfaces.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HandlingActivityRegistrationResource {

    private String bookingId;
    private String voyageNumber;
    private String unLocode;
    private String handlingType;
    private LocalDate completionTime;

}
