package ru.BoshkaLab.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;
    private Integer interval;

    @OneToMany(
            mappedBy = "question",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private Set<Answer> answers;

    @OneToMany(
            mappedBy = "question",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private Set<SendingTimetable> timetable;

    public Question() {
        answers = new HashSet<>();
        timetable = new HashSet<>();
    }

    public Question(String text, Integer interval) {
        this.text = text;
        this.interval = interval;
        answers = new HashSet<>();
        timetable = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
        for (Answer answer : answers)
            answer.setQuestion(this);
    }

    public Set<SendingTimetable> getTimetable() {
        return timetable;
    }

    public void setTimetable(Set<SendingTimetable> timetable) {
        this.timetable = timetable;
        for (SendingTimetable record : timetable)
            record.setQuestion(this);
    }
}
