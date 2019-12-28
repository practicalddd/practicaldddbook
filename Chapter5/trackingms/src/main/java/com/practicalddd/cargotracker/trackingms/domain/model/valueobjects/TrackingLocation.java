package com.practicalddd.cargotracker.trackingms.domain.model.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TrackingLocation class represented by a unique 5-diigit UN TrackingLocation code.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class TrackingLocation {

    @Column(name = "location_id")
    private String unLocCode;

}
