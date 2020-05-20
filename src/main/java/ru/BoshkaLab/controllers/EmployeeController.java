package ru.BoshkaLab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.BoshkaLab.entities.Employee;
import ru.BoshkaLab.repositories.EmployeeRepository;
import ru.BoshkaLab.services.EmployeeServiceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("all")
    public Iterable<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable long id) {
        return employeeRepository.getOne(id);
    }

    @PostMapping("/add")
    public Employee add(@RequestBody Map<String, String> newEmployee) {
        if (!newEmployee.containsKey("slackId") ||
                !newEmployee.containsKey("fullName") ||
                !newEmployee.containsKey("timeOfEntering"))
            return null;

        String slackId = newEmployee.get("slackId");
        String fullName = newEmployee.get("fullName");
        String time = newEmployee.get("timeOfEntering");

        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date timeOfEntering = new Date(System.currentTimeMillis());

        Employee employee = new Employee(slackId, fullName, timeOfEntering);
        employeeRepository.saveAndFlush(employee);
        return employee;
    }

    @GetMapping("progress/{id}")
    public double getProgress(@PathVariable long id) {
        return employeeService.getProgress(id);
    }
}
