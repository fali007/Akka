package com.example.akka.kafkaProcess;

import com.example.akka.Consumer.Consumer;
import com.example.akka.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Slf4j
public class KafkaSource {
    public ArrayList<Message> array = new ArrayList<>();

    @StreamListener(Consumer.INPUT)
    public void handleMessage(@Payload Message message) {
        log.info(String.format("Message - %s - is pulled", message));
        array.add(message);
        log.info(String.format("Message - %s - is added to array", message));
    }

    @Scheduled(fixedRate = 10000 * 60 * 1)
    public void printArray() {
        for (int i = 0; i < array.size(); i++) {
            log.info(String.format(" %d - message is %s", i, array.get(i)));
        }
        array.clear();
    }
}
