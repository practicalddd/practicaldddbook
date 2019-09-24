package com.practicalddd.cargotracker.trackingms.infrastructure.repositories.jpa;


import com.practicalddd.cargotracker.trackingms.domain.model.aggregates.TrackingActivity;
import com.practicalddd.cargotracker.trackingms.domain.model.aggregates.TrackingNumber;
import com.practicalddd.cargotracker.trackingms.domain.model.entities.BookingId;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

/**
 * Repository class for the Tracking Aggregate. Deals with all repository operations
 * related to the state of the Tracking of the Cargo
 */
public interface TrackingRepository extends JpaRepository<TrackingActivity,Long> {
    /**
     * Returns the Cargo Aggregate based on the Tracking Number of the Cargo
     * @param trackingNumber
     * @return TrackingActivity
     */
    public TrackingActivity findByTrackingNumber(TrackingNumber trackingNumber);
    /**
     * Returns the Tracking Aggregate based on the Booking Identifier
     * @param bookingId
     * @return
     */
    public TrackingActivity findByBookingNumber(BookingId bookingId);


    /**
     * Find all Tracking Activity Aggregates
     * @return
     */
    public List<TrackingActivity> findAll();


    /**
     * Find all Tracking Numbers
     * @return
     */
    public List<TrackingNumber> findAllTrackingNos();

}
