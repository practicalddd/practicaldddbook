package com.practicalddd.cargotracker.trackingms.interfaces.events;


import com.practicalddd.cargotracker.shareddomain.events.CargoHandledEvent;
import com.practicalddd.cargotracker.trackingms.application.internal.commandservices.AssignTrackingIdCommandService;
import com.practicalddd.cargotracker.trackingms.infrastructure.brokers.rabbitmq.HandlingBinding;
import com.practicalddd.cargotracker.trackingms.infrastructure.brokers.rabbitmq.RoutingBinding;
import com.practicalddd.cargotracker.trackingms.interfaces.events.transform.TrackingActivityCommandEventAssembler;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

/**
 * Event Handler for the Cargo Routed Event that the Tracking Bounded Context is interested in
 */
@Service
@EnableBinding(HandlingBinding.class)
public class CargoHandledEventHandler {

    private AssignTrackingIdCommandService assignTrackingIdCommandService; // Application Service Dependency

    /**
     * Provide the dependencies
     * @param assignTrackingIdCommandService
     */
    public CargoHandledEventHandler(AssignTrackingIdCommandService assignTrackingIdCommandService){
        this.assignTrackingIdCommandService = assignTrackingIdCommandService;
    }

    @StreamListener(target = HandlingBinding.HANDLING)
    public void receiveEvent(CargoHandledEvent cargoHandledEvent) {
        //Process the Event
        System.out.println("XXXXXXXXXX"+cargoHandledEvent.getCargoHandledEventData());
        assignTrackingIdCommandService.addTrackingEvent(
                TrackingActivityCommandEventAssembler
                        .toCommandFromEvent(cargoHandledEvent));

    }
}
