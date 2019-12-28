package com.practicalddd.cargotracker.bookingms.domain.model.valueobjects;

import com.practicalddd.cargotracker.bookingms.domain.model.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

/**
 * A handling activity represents how and where a cargo can be handled, and can
 * be used to express predictions about what is expected to happen to a cargo in
 * the future.
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Embeddable
public class CargoHandlingActivity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "next_expected_handling_event_type")
    private String type;

    @Embedded
    @AttributeOverride(name = "unLocCode", column = @Column(name = "next_expected_location_id"))
    private Location location;

    @Column(name = "next_expected_voyage_id")
    private Voyage voyage;

    public CargoHandlingActivity(String type, Location location) {
        this.type = type;
        this.location = location;
    }

}
