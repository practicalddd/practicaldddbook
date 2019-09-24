package com.practicalddd.cargotracker.shareddomain.events;


/**
 * Event Data for the Cargo Routed Event
 */
public class CargoRoutedEventData {

    private String bookingId;
    public CargoRoutedEventData(){}
    public CargoRoutedEventData(String bookingId){ this.bookingId = bookingId; }
    public void setBookingId(String bookingId){this.bookingId = bookingId;}
    public String getBookingId(){return this.bookingId;}

}
