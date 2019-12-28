package com.practicalddd.cargotracker.bookingms.domain.model.aggregates;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Aggregate Identifier for the Cargo Aggregate
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BookingId implements Serializable {

    @Column(name="booking_id")
    private String bookingId;

}
