package com.example.akka;

import akka.Done;
import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import com.example.akka.objects.Employee;
import com.example.akka.process.EmployeeProcess;
import com.example.akka.process.EmployeeSink;
import com.example.akka.process.EmployeeSource;

import java.util.concurrent.CompletionStage;

public class RunAkka {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("basic-stream-app");

        Source<Employee, NotUsed> source = new EmployeeSource().source();
        Flow<Employee, Employee, NotUsed> flow = new EmployeeProcess().flow();
        Sink<Employee, CompletionStage<Done>> sink = new EmployeeSink().sink();

        RunnableGraph<NotUsed> runnable = source.via(flow).to(sink);
        ActorMaterializer materializer = ActorMaterializer.create(system);
        runnable.run(materializer);
    }
}
