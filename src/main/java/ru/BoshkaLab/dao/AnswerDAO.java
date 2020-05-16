package ru.BoshkaLab.dao;

import ru.BoshkaLab.entities.Answer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AnswerDAO implements IAnswerDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Answer answer) {
        entityManager.persist(answer);
    }

    @Override
    public void update(Answer answer) {
        entityManager.merge(answer);
    }

    @Override
    public void delete(Answer answer) {
        entityManager.remove(answer);
    }

    @Override
    public void removeById(long id) {
        Answer answer = get(id);
        delete(answer);
    }

    @Override
    public Answer get(long id) {
        return entityManager.find(Answer.class, id);
    }
}
