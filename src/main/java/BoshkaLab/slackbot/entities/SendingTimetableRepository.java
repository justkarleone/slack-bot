package BoshkaLab.slackbot.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SendingTimetableRepository extends JpaRepository<SendingTimetable, Long> {
}
