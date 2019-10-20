package com.practicalddd.cargotracker.booking.domain.model;

import java.util.Collections;
import java.util.List;

public class Itinerary {

    private List<Leg> legs = Collections.emptyList();

    public Itinerary() {
        // Nothing to initialize.
    }

    public Itinerary(List<Leg> legs) {
        this.legs = legs;
    }

    public List<Leg> getLegs() {
        return Collections.unmodifiableList(legs);
    }
}
