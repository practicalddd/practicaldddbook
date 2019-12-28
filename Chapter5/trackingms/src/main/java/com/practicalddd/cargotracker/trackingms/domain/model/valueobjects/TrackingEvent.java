package com.practicalddd.cargotracker.trackingms.domain.model.valueobjects;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Tracking Event Details
 */
@NoArgsConstructor
@Getter
@Entity
@Table(name = "tracking_handling_events")
public class TrackingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private TrackingVoyageNumber trackingVoyageNumber;

    @Embedded
    private TrackingLocation trackingLocation;

    @Embedded
    private TrackingEventType trackingEventType;

    public TrackingEvent(
            TrackingVoyageNumber trackingVoyageNumber,
            TrackingLocation trackingLocation,
            TrackingEventType trackingEventType) {
        this.trackingEventType = trackingEventType;
        this.trackingVoyageNumber = trackingVoyageNumber;
        this.trackingLocation = trackingLocation;
    }

}
