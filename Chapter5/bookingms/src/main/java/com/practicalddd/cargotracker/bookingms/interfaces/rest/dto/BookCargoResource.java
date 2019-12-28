package com.practicalddd.cargotracker.bookingms.interfaces.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Resource class for the Book Cargo Command API
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookCargoResource {

    private int bookingAmount;
    private String originLocation;
    private String destLocation;
    private LocalDate destArrivalDeadline;

}
