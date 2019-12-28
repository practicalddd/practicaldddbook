package com.practicalddd.cargotracker.bookingms.interfaces.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Resource class for the Book Cargo Command API
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RouteCargoResource {

    private String bookingId;

}
