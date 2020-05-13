package BoshkaLab.slackbot.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String answer;
//    @Column(name = "time_of_answer")
    private Date timeOfAnswer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id", referencedColumnName = "id")
    private Question question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getTimeOfAnswer() {
        return timeOfAnswer;
    }

    public void setTimeOfAnswer(Date timeOfAnswer) {
        this.timeOfAnswer = timeOfAnswer;
    }
}
