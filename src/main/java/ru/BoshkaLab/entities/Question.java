package ru.BoshkaLab.entities;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name="question")
@Proxy(lazy = false)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Integer interval;

    public Question() {
    }

    public Question(String text, Integer interval) {
        this.text = text;
        this.interval = interval;
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
}
