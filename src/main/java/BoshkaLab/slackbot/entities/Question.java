package BoshkaLab.slackbot.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
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
    private Set<Answer> answer;

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
