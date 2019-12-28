package com.practicalddd.cargotracker.bookingms.domain.model.valueobjects;

import com.practicalddd.cargotracker.bookingms.domain.model.entities.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@Getter
@Embeddable
public class RouteSpecification {

    private static final long serialVersionUID = 1L;

    @Embedded
    @AttributeOverride(name = "unLocCode", column = @Column(name = "spec_origin_id"))
    private Location origin;

    @Embedded
    @AttributeOverride(name = "unLocCode", column = @Column(name = "spec_destination_id"))
    private Location destination;

    @Temporal(TemporalType.DATE)
    @Column(name = "spec_arrival_deadline")
    @NotNull
    private Date arrivalDeadline;

    /**
     * @param origin origin location - can't be the same as the destination
     * @param destination destination location - can't be the same as the origin
     * @param arrivalDeadline arrival deadline
     */
    public RouteSpecification(Location origin, Location destination,
                              Date arrivalDeadline) {
        this.origin = origin;
        this.destination = destination;
        this.arrivalDeadline = (Date) arrivalDeadline.clone();
    }

}
