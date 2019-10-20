package com.practicalddd.cargotracker.booking.domain.model;

public enum TransportStatus {

    NOT_RECEIVED, IN_PORT, ONBOARD_CARRIER, CLAIMED, UNKNOWN;

    public boolean sameValueAs(TransportStatus other) {
        return this.equals(other);
    }
}
