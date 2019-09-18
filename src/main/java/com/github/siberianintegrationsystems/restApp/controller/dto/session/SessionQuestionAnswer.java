package com.github.siberianintegrationsystems.restApp.controller.dto.session;

public class SessionQuestionAnswer {
    private String id;
    private Boolean isSelected;

    public SessionQuestionAnswer() {
    }

    public SessionQuestionAnswer(String id, Boolean isSelected) {
        this.id = id;
        this.isSelected = isSelected;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean selected) {
        isSelected = selected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
