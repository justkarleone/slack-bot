package ru.BoshkaLab.dao;

import ru.BoshkaLab.entities.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserDAO implements IUserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(User newUser) {
        entityManager.persist(newUser);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeById(long id) {
        User user = get(id);
        delete(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public User get(long id) {
        return entityManager.find(User.class, id);
    }
}
