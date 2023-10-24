package com.springAPI.main.controller;

import com.springAPI.main.entity.AnswerEntity;
import com.springAPI.main.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/answers")
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping
    public List<AnswerEntity> getAllAnswers() {
        return answerService.findAll();
    }

    @GetMapping("/{id}")
    public AnswerEntity getAnswerById(@PathVariable Long id) {
        return answerService.findById(id).orElse(null);
    }

    @PostMapping
    public AnswerEntity createAnswer(@RequestBody AnswerEntity answer) {
        return answerService.save(answer);
    }

    @PutMapping("/{id}")
    public AnswerEntity updateAnswer(@PathVariable Long id, @RequestBody AnswerEntity answer) {
        return answerService.save(answer);
    }

    @DeleteMapping("/{id}")
    public void deleteAnswer(@PathVariable Long id) {
        answerService.deleteById(id);
    }
}