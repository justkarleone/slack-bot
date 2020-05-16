package ru.BoshkaLab.dao;

import ru.BoshkaLab.entities.Answer;

public interface IAnswerDAO {
    void create(Answer answer);
    void update(Answer answer);
    void delete(Answer answer);
    void removeById(long id);
    Answer get(long id);
}
