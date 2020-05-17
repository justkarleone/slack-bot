package ru.BoshkaLab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.BoshkaLab.entities.Question;
import ru.BoshkaLab.repositories.QuestionRepository;

import java.util.Map;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("all")
    public Iterable<Question> getAll() {
        return questionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Question getOne(@PathVariable long id) {
        return questionRepository.getOne(id);
    }

    @PostMapping("/add")
    public Question add(@RequestBody Map<String, String> newQuestion) {
        if (!newQuestion.containsKey("text") ||
                !newQuestion.containsKey("interval"))
            return null;

        String text = newQuestion.get("text");
        Integer interval = Integer.parseInt(newQuestion.get("interval"));

        Question question = new Question(text, interval);
        questionRepository.saveAndFlush(question);

        return question;
    }

    @PutMapping("/update")
    public Question update(@RequestBody Question question) {
        questionRepository.saveAndFlush(question);
        return question;
    }
}
