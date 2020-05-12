package BoshkaLab.slackbot.entities;

import javax.persistence.*;
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


}
