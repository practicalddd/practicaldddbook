package com.practicalddd.cargotracker.bookingms.domain.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Location class represented by a unique 5-diigit UN Location code.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class Location {

    @Column(name = "origin_id", insertable = false, updatable = false)
    private String unLocCode;

}
