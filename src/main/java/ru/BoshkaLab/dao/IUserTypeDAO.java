package ru.BoshkaLab.dao;

import ru.BoshkaLab.entities.UserType;

public interface IUserTypeDAO {
    void create(UserType userType);
    UserType get(long id);
}
