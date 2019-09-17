package com.github.siberianintegrationsystems.restApp.service;

import com.github.siberianintegrationsystems.restApp.controller.dto.QuestionsItemDTO;
import com.github.siberianintegrationsystems.restApp.controller.dto.QuestionsNewItemDTO;
import com.github.siberianintegrationsystems.restApp.entity.Question;

import java.util.List;

public interface QuestionService {
    List<QuestionsItemDTO> getQuestions();
    QuestionsItemDTO createQuestion(QuestionsItemDTO dto);
    QuestionsItemDTO editQuestion(QuestionsItemDTO dto);
}
