package com.practicalddd.cargotracker.trackingms.domain.model.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class TrackingEventType {

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "event_time")
    @Temporal(TemporalType.DATE)
    private Date eventTime;

}
