package BoshkaLab.slackbot.services.impl;

import BoshkaLab.slackbot.entities.User;
import BoshkaLab.slackbot.entities.UserRepository;
import BoshkaLab.slackbot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    EntityManager entityManager;

    @Override
    public void addUser(User user) {
        User savedUser = userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void editUser(User changedUser) {
        User user = entityManager.find(User.class, changedUser.getId());
        if (user == null)
            return;

        user.setLogin(changedUser.getLogin());
        user.setPassword(changedUser.getPassword());
        user.setEmail(changedUser.getEmail());
        user.setName(changedUser.getName());
        user.setSurname(changedUser.getSurname());
        user.setType(changedUser.getType());
        
        entityManager.flush();
    }
}
