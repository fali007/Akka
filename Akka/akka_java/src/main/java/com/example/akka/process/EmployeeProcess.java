package com.example.akka.process;

import com.example.akka.objects.Employee;

import akka.NotUsed;
import akka.stream.javadsl.Flow;

public class EmployeeProcess<B> {
    public Flow<Employee, Employee, NotUsed> flow() {
        return Flow.fromFunction(emp -> {
            emp.setDept("AI-IT");
            return emp;
        });
    }
}
