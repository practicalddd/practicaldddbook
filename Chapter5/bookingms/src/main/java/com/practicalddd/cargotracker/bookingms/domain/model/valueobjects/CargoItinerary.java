package com.practicalddd.cargotracker.bookingms.domain.model.valueobjects;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CargoItinerary {

    public static final CargoItinerary EMPTY_ITINERARY = new CargoItinerary();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cargo_id")
    private List<Leg> legs = Collections.emptyList();

    public List<Leg> getLegs() {
        return Collections.unmodifiableList(legs);
    }
}
