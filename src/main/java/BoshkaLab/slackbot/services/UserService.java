package BoshkaLab.slackbot.services;

import BoshkaLab.slackbot.entities.User;

public interface UserService {
    void addUser(User user);
    void deleteUser(long id);
    void editUser(User user);
}
