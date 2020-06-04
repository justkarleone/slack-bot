package ru.BoshkaLab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.BoshkaLab.entities.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    int countAllByEmployee_Id(int employeeId);
}
