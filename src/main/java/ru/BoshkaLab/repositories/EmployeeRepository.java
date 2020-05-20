package ru.BoshkaLab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.BoshkaLab.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findBySlackId(String slack_id);
}
