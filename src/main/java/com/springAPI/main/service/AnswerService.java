package com.springAPI.main.service;

import com.springAPI.main.entity.AnswerEntity;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    AnswerEntity save(AnswerEntity answerEntity);
    Optional<AnswerEntity> findById(Long id);
    List<AnswerEntity> findAll();
    void deleteById(Long id);
}
