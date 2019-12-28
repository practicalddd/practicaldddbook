package com.practicalddd.cargotracker.bookingms.domain.model.commands;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Command Class to assign a route to a booked cargo
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RouteCargoCommand {

    private String cargoBookingId;

}

