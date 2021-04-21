package com.example.akka.Consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Consumer {
    String INPUT = "input";

    @Input(INPUT)
    SubscribableChannel incoming();
}
