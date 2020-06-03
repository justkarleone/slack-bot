package ru.BoshkaLab.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String slackId;
    private String fullName;
    private Date timeOfEntering;
    private Date timeOfEnding;

    public Employee() {
    }

    public Employee(String slackId, String fullName, Date timeOfEntering, Date timeOfEnding) {
        this.slackId = slackId;
        this.fullName = fullName;
        this.timeOfEntering = timeOfEntering;
        this.timeOfEnding = timeOfEnding;
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

    public Date getTimeOfEnding() {
        return timeOfEnding;
    }

    public void setTimeOfEnding(Date timeOfEnding) {
        this.timeOfEnding = timeOfEnding;
    }
}
