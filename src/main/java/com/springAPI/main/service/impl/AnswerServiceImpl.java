package com.springAPI.main.service.impl;

import com.springAPI.main.entity.AnswerEntity;
import com.springAPI.main.repository.AnswerRepository;
import com.springAPI.main.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Override
    public AnswerEntity save(AnswerEntity answerEntity) {
        return answerRepository.save(answerEntity);
    }

    @Override
    public Optional<AnswerEntity> findById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public List<AnswerEntity> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        answerRepository.deleteById(id);
    }
}
