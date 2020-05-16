package ru.BoshkaLab.dao;

import ru.BoshkaLab.entities.SendingTimetable;

public interface ISendingTableDAO {
    void create(SendingTimetable record);
    void update(SendingTimetable record);
    void delete(SendingTimetable record);
    void removeById(long id);
    SendingTimetable get(long id);
}
