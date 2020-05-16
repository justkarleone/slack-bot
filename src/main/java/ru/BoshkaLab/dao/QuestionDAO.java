package ru.BoshkaLab.dao;

import ru.BoshkaLab.entities.Question;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class QuestionDAO implements IQuestionDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Question question) {
        entityManager.persist(question);
    }

    @Override
    public void delete(Question question) {
        entityManager.remove(question);
    }

    @Override
    public void removeById(long id) {
        Question question = get(id);
        delete(question);
    }

    @Override
    public Question get(long id) {
        return entityManager.find(Question.class, id);
    }
}
