package com.example.akka.process;

import java.util.concurrent.CompletionStage;

import com.example.akka.objects.Employee;

import akka.Done;
import akka.stream.javadsl.Sink;

public class EmployeeSink {
    public Sink<Employee, CompletionStage<Done>> sink() {
        return Sink.foreach(System.out::println);
    }
}
