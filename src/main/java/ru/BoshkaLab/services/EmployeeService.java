package ru.BoshkaLab.services;

public interface EmployeeService {
    double getProgress(int employeeId);
    void add(String slackId, String name, String surname);
}
