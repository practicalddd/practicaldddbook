package com.practicalddd.cargotracker.trackingms.domain.model.aggregates;

import com.practicalddd.cargotracker.trackingms.domain.model.commands.AddTrackingEventCommand;
import com.practicalddd.cargotracker.trackingms.domain.model.commands.AssignTrackingNumberCommand;
import com.practicalddd.cargotracker.trackingms.domain.model.entities.BookingId;
import com.practicalddd.cargotracker.trackingms.domain.model.entities.TrackingActivityEvent;
import com.practicalddd.cargotracker.trackingms.domain.model.valueobjects.TrackingEvent;
import com.practicalddd.cargotracker.trackingms.domain.model.valueobjects.TrackingEventType;
import com.practicalddd.cargotracker.trackingms.domain.model.valueobjects.TrackingLocation;
import com.practicalddd.cargotracker.trackingms.domain.model.valueobjects.TrackingVoyageNumber;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity
@NamedQueries({
        @NamedQuery(name = "TrackingActivity.findAll",
                query = "Select t from TrackingActivity t"),
        @NamedQuery(name = "TrackingActivity.findByTrackingNumber",
                query = "Select t from TrackingActivity t where t.trackingNumber = :trackingNumber"),
        @NamedQuery(name = "TrackingActivity.findAllTrackingNos",
                query = "Select t.trackingNumber from TrackingActivity t"),
        @NamedQuery(name = "TrackingActivity.findByBookingNumber",
                query = "Select t from TrackingActivity t where t.bookingId = :bookingId")})
@Table(name = "tracking_activity")
public class TrackingActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private TrackingNumber trackingNumber; // Aggregate Identifier

    @Embedded
    private BookingId bookingId;

    @Embedded
    private TrackingActivityEvent trackingActivityEvent;

    /**
     * Creates a new Tracking Number
     *
     * @param assignTrackingNumberCommand
     */
    public TrackingActivity(AssignTrackingNumberCommand assignTrackingNumberCommand) {
        this.trackingNumber = new TrackingNumber(assignTrackingNumberCommand.getTrackingNumber());
        this.bookingId = new BookingId((assignTrackingNumberCommand.getBookingId()));
        this.trackingActivityEvent = TrackingActivityEvent.EMPTY_ACTIVITY;
    }

    /**
     * Add a tracking event to the Tracking Details
     *
     * @param addTrackingEventCommand
     */
    public void addTrackingEvent(AddTrackingEventCommand addTrackingEventCommand) {
        TrackingEvent trackingEvent = new TrackingEvent(
                new TrackingVoyageNumber(addTrackingEventCommand.getVoyageNumber()),
                new TrackingLocation(addTrackingEventCommand.getLocation()),
                new TrackingEventType(addTrackingEventCommand.getEventType(), addTrackingEventCommand.getEventTime()));
        this.trackingActivityEvent.getTrackingEvents().add(trackingEvent);
    }

    /**
     * Gets next Tracking Identifier
     *
     * @return
     */
    public String nextTrackingNumber() {
        String random = UUID.randomUUID().toString().toUpperCase();
        return random.substring(0, random.indexOf("-"));
    }

}
