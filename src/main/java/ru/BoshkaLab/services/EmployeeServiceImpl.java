package ru.BoshkaLab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.BoshkaLab.entities.Employee;
import ru.BoshkaLab.repositories.AnswerRepository;
import ru.BoshkaLab.repositories.EmployeeRepository;
import ru.BoshkaLab.repositories.QuestionRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public double getProgress(long employeeId) {
        long questionCount = questionRepository.count();
        double answeredQuestion = answerRepository.countAllByEmployee_Id(employeeId);
        return answeredQuestion / questionCount;
    }

    @Override
    public void add(Employee employee) {
        employeeRepository.saveAndFlush(employee);
    }
}
