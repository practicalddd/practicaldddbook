package com.practicalddd.cargotracker.trackingms.domain.model.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Aggregate Identifier for the Cargo Aggregate
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Embeddable
public class BookingId implements Serializable {

    @Column(name = "booking_id")
    private String bookingId;

}
