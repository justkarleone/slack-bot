package BoshkaLab.slackbot.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @Column(name = "slack_id")
    private String slackId;
//    @Column(name = "fullname")
    private String fullName;
//    @Column(name = "time_of_entering")
    private Date timeOfEntering;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private Set<Answer> answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlackId() {
        return slackId;
    }

    public void setSlackId(String slackId) {
        this.slackId = slackId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getTimeOfEntering() {
        return timeOfEntering;
    }

    public void setTimeOfEntering(Date timeOfEntering) {
        this.timeOfEntering = timeOfEntering;
    }
}
