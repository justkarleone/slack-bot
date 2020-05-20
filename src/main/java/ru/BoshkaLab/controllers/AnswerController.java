package ru.BoshkaLab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.BoshkaLab.entities.Answer;
import ru.BoshkaLab.repositories.AnswerRepository;

@RestController
@RequestMapping("answer")
public class AnswerController {
    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("all")
    public Iterable<Answer> getAll() {
        return answerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Answer getOne(@PathVariable long id) {
        return answerRepository.getOne(id);
    }
}
