package com.practicalddd.cargotracker.booking.domain.events;

import com.practicalddd.cargotracker.booking.domain.model.RouteSpecification;

public class CargoDestinationChangedEvent {
    private String bookingId;
    private RouteSpecification routeSpecification;

    public CargoDestinationChangedEvent(String bookingId, RouteSpecification routeSpecification){
        this.bookingId = bookingId;
        this.routeSpecification = routeSpecification;
    }

    public String getBookingId(){ return this.bookingId;}
    public RouteSpecification getNewRouteSpecification(){ return this.routeSpecification;}

}
