package BoshkaLab.slackbot.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
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
    private Set<Answer> answers;

    public Employee() {
        answers = new HashSet<>();
    }

    public Employee(String slackId, String fullName, Date timeOfEntering) {
        this.slackId = slackId;
        this.fullName = fullName;
        this.timeOfEntering = timeOfEntering;
        this.answers = new HashSet<>();
    }

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

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
        for (Answer answer : answers)
            answer.setEmployee(this);
    }
}
