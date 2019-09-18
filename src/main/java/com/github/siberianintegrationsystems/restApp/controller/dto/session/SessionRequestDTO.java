package com.github.siberianintegrationsystems.restApp.controller.dto.session;

import com.github.siberianintegrationsystems.restApp.controller.dto.AnsweredQuestionDTO;

import java.util.List;

public class SessionRequestDTO {
    private String name;
    private List<AnsweredQuestionDTO> questionsList;

    public SessionRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AnsweredQuestionDTO> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<AnsweredQuestionDTO> questionsList) {
        this.questionsList = questionsList;
    }
}
