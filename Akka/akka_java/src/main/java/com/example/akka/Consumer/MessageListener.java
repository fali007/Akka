//package com.example.akka.Consumer;
//
//import com.example.akka.message.Message;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//
//@Component
//@Slf4j
//public class MessageListener {
//    @StreamListener(Consumer.INPUT)
//    public void handleMessage(@Payload Message message){
//        log.info(String.format("Message - %s is pulled from kafka",message));
//    }
//}
