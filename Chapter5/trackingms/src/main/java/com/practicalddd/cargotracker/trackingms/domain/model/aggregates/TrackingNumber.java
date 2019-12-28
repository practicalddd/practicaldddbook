package com.practicalddd.cargotracker.trackingms.domain.model.aggregates;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Embeddable
public class TrackingNumber {

    @Column(name = "tracking_number")
    private String trackingNumber;

}
