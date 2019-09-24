package com.practicalddd.cargotracker.trackingms.infrastructure.brokers.rabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface HandlingBinding {

    String HANDLING = "cargoHandlingChannel";

    @Input(HANDLING)
    SubscribableChannel cargoHandling();
}
