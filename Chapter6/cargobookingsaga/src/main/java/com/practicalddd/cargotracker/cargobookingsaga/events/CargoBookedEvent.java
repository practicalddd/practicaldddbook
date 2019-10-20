package com.practicalddd.cargotracker.cargobookingsaga.events;


import com.practicalddd.cargotracker.cargobookingsaga.model.BookingAmount;
import com.practicalddd.cargotracker.cargobookingsaga.model.Location;
import com.practicalddd.cargotracker.cargobookingsaga.model.RouteSpecification;

/**
 * Event resulting from the Cargo Booking Command
 */
public class CargoBookedEvent
{
    private String bookingId;
    private BookingAmount bookingamount;
    private Location originLocation;
    private RouteSpecification routeSpecification;
    public CargoBookedEvent(String bookingId,
                            BookingAmount bookingAmount,Location originLocation, RouteSpecification routeSpecification){
        this.bookingId = bookingId;
        this.bookingamount = bookingAmount;
        this.originLocation = originLocation;
        this.routeSpecification = routeSpecification;
    }

    public String getBookingId(){ return this.bookingId; }
    public BookingAmount getBookingAmount(){ return this.bookingamount; }
    public Location getOriginLocation(){return this.originLocation;}
    public RouteSpecification getRouteSpecification(){return this.routeSpecification;}
}
