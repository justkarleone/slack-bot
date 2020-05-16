package ru.BoshkaLab.dao;

import ru.BoshkaLab.entities.SendingTimetable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SendingTimetableDAO implements ISendingTableDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(SendingTimetable record) {
        entityManager.persist(record);
    }

    @Override
    public void update(SendingTimetable record) {
        entityManager.merge(record);
    }

    @Override
    public void delete(SendingTimetable record) {
        entityManager.remove(record);
    }

    @Override
    public void removeById(long id) {
        SendingTimetable record = get(id);
        delete(record);
    }

    @Override
    public SendingTimetable get(long id) {
        return entityManager.find(SendingTimetable.class, id);
    }
}
