package ru.BoshkaLab.dao;

import ru.BoshkaLab.entities.User;

public interface IUserDAO {
    void create(User user);
    void update(User user);
    void delete(User user);
    void removeById(long id);
    User get(long id);
}
