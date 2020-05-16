package ru.BoshkaLab.dao;

import ru.BoshkaLab.entities.User;
import ru.BoshkaLab.entities.UserType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserTypeDAO implements IUserTypeDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(UserType userType) {
        entityManager.persist(userType);
    }

    @Override
    public UserType get(long id) {
        return entityManager.find(UserType.class, id);
    }
}
