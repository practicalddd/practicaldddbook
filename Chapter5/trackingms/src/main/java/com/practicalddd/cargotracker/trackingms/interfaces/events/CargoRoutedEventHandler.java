package com.practicalddd.cargotracker.trackingms.interfaces.events;


import com.practicalddd.cargotracker.shareddomain.events.CargoRoutedEvent;
import com.practicalddd.cargotracker.trackingms.application.internal.commandservices.AssignTrackingIdCommandService;
import com.practicalddd.cargotracker.trackingms.infrastructure.brokers.rabbitmq.RoutingBinding;
import com.practicalddd.cargotracker.trackingms.interfaces.events.transform.TrackingDetailsCommandEventAssembler;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

/**
 * Event Handler for the Cargo Routed Event that the Tracking Bounded Context is interested in
 */
@Service
@EnableBinding(RoutingBinding.class)
public class CargoRoutedEventHandler {

    private AssignTrackingIdCommandService assignTrackingIdCommandService; // Application Service Dependency

    /**
     * Provide the dependencies
     * @param assignTrackingIdCommandService
     */
    public CargoRoutedEventHandler(AssignTrackingIdCommandService assignTrackingIdCommandService){
        this.assignTrackingIdCommandService = assignTrackingIdCommandService;
    }

    @StreamListener(target = RoutingBinding.ROUTING)
    public void receiveEvent(CargoRoutedEvent cargoRoutedEvent) {
        System.out.println("Cargo routed Event"+cargoRoutedEvent);
        System.out.println(cargoRoutedEvent.getCargoRoutedEventData());
        System.out.println(cargoRoutedEvent.getCargoRoutedEventData().getBookingId());
        //Process the Event
        assignTrackingIdCommandService.assignTrackingNumberToCargo(
                TrackingDetailsCommandEventAssembler.toCommandFromEvent(cargoRoutedEvent));

    }
}
