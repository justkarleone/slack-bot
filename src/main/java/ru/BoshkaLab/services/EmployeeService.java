package ru.BoshkaLab.services;

import ru.BoshkaLab.entities.Employee;

public interface EmployeeService {
    double getProgress(long employeeId);
    void add(String slackId, String fullName);
}
