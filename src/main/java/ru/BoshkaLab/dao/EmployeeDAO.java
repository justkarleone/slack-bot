package ru.BoshkaLab.dao;

import ru.BoshkaLab.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EmployeeDAO implements IEmployeeDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public void delete(Employee employee) {
        entityManager.remove(employee);
    }

    @Override
    public void removeById(long id) {
        Employee employee = get(id);
        delete(employee);
    }

    @Override
    public Employee get(long id) {
        return entityManager.find(Employee.class, id);
    }
}
