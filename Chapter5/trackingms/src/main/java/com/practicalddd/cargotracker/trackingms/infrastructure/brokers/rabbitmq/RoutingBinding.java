package com.practicalddd.cargotracker.trackingms.infrastructure.brokers.rabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RoutingBinding {

    String ROUTING = "cargoRoutingChannel";

    @Input(ROUTING)
    SubscribableChannel cargoRouting();
}
