package com.practicalddd.cargotracker.booking.domain.model;

public enum RoutingStatus {

    NOT_ROUTED, ROUTED, MISROUTED;

    public boolean sameValueAs(RoutingStatus other) {
        return this.equals(other);
    }
}