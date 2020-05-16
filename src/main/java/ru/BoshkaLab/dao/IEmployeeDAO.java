package ru.BoshkaLab.dao;

import ru.BoshkaLab.entities.Employee;

public interface IEmployeeDAO {
    void create(Employee employee);
    void update(Employee employee);
    void delete(Employee employee);
    void removeById(long id);
    Employee get(long id);
}
