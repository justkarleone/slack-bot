package BoshkaLab.slackbot.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(
            mappedBy = "userType",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private Set<User> users;

    public UserType() {
        users = new HashSet<>();
    }

    public UserType(String name) {
        this.name = name;
        users = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
        for (User user : users)
            user.setType(this);
    }
}
