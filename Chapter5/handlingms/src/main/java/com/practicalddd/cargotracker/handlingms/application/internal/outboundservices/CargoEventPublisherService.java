package com.practicalddd.cargotracker.handlingms.application.internal.outboundservices;

import com.practicalddd.cargotracker.handlingms.infrastructure.brokers.rabbitmq.CargoEventSource;
import com.practicalddd.cargotracker.shareddomain.events.CargoHandledEvent;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 *
 */
@Service
@AllArgsConstructor
@EnableBinding(CargoEventSource.class)
public class CargoEventPublisherService {

    CargoEventSource cargoEventSource;

    @TransactionalEventListener
    public void handleCargoHandledEvent(CargoHandledEvent cargoHandledEvent){
        cargoEventSource.cargoHandling().send(MessageBuilder.withPayload(cargoHandledEvent).build());
    }
}
