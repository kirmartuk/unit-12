package com.github.siberianintegrationsystems.restApp.controller.dto;

import com.github.siberianintegrationsystems.restApp.controller.dto.journal.JournalItemDTO;

import java.util.List;

public class QuestionsNewItemDTO extends JournalItemDTO {
    private String name;
    private List<AnswerItemDTO> answers;

    public QuestionsNewItemDTO(String id, String name, List<AnswerItemDTO> answers) {
        this.id = id;
        this.name = name;
        this.answers = answers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AnswerItemDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerItemDTO> answers) {
        this.answers = answers;
    }
}
