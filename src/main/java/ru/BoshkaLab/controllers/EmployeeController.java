package ru.BoshkaLab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.BoshkaLab.entities.Employee;
import ru.BoshkaLab.repositories.EmployeeRepository;
import ru.BoshkaLab.services.EmployeeServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeServiceImpl employeeService;

//    @GetMapping("/all")
//    public Iterable<Employee> getAll() {
//        return employeeRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Employee getOne(@PathVariable Integer id) {
//        return employeeRepository.getOne(id);
//    }
//
//    @PostMapping("/add")
//    public void add(@RequestBody Map<String, String> newEmployee) {
//        String slackId;
//        String fullName;
//
//        try {
//            slackId = newEmployee.get("slackId");
//            fullName = newEmployee.get("fullName");
//
//            employeeService.add(slackId, fullName);
//        }
//        catch (Exception e) {
//            return;
//        }
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String employeeList(ModelMap modelMap){
        modelMap.put("employee", employeeRepository.findAll());
        return "employee/employee";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String employeeList(@PathVariable(value = "id") int id, ModelMap modelMap){
        modelMap.put("employee", employeeRepository.getOne(id));
        return "employee/employeeSingle";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(HttpServletRequest request){
        String name = request.getParameter("name").trim();
        String surname = request.getParameter("surname");
        String slackId = request.getParameter("slack").trim();
        employeeService.add(slackId, name, surname);
        return "redirect: ";
    }

    @GetMapping("progress/{id}")
    public double getProgress(@PathVariable int id) {
        return employeeService.getProgress(id);
    }
}
