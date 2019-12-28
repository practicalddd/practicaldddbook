package com.practicalddd.cargotracker.bookingms.domain.model.valueobjects;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Transient;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class LastCargoHandledEvent {

    private Integer handlingEventId;
    @Transient
    private String handlingEventType;
    @Transient
    private String handlingEventVoyage;
    @Transient
    private String handlingEventLocation;

    // Null object pattern.
    public static final LastCargoHandledEvent EMPTY = new LastCargoHandledEvent();

}
