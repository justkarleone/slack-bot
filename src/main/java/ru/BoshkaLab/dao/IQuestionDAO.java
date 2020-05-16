package ru.BoshkaLab.dao;

import ru.BoshkaLab.entities.Question;

public interface IQuestionDAO {
    void create(Question question);
    void delete(Question question);
    void removeById(long id);
    Question get(long id);
}
