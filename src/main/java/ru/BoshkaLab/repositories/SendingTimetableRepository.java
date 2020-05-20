package ru.BoshkaLab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.BoshkaLab.entities.SendingTimetable;

public interface SendingTimetableRepository extends JpaRepository<SendingTimetable, Long> {
}
