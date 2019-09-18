package com.github.siberianintegrationsystems.restApp.controller.dto;

import com.github.siberianintegrationsystems.restApp.controller.dto.session.SessionQuestionAnswer;

import java.util.List;

public class AnsweredQuestionDTO {
    private String id;
    private List<SessionQuestionAnswer> answersList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SessionQuestionAnswer> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<SessionQuestionAnswer> answersList) {
        this.answersList = answersList;
    }
}
