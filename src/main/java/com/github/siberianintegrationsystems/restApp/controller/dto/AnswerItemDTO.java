package com.github.siberianintegrationsystems.restApp.controller.dto;

import com.github.siberianintegrationsystems.restApp.entity.Answer;

public class AnswerItemDTO {
    public String id;
    public String answerText;
    public Boolean isCorrect;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public AnswerItemDTO() {

    }

    public AnswerItemDTO(Answer answer) {
        id = answer.getId().toString();
        answerText = answer.getName();
        isCorrect = answer.getCorrect();
    }
}
