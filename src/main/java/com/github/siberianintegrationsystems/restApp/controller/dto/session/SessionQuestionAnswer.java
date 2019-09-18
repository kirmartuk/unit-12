package com.github.siberianintegrationsystems.restApp.controller.dto.session;

public class SessionQuestionAnswer {
    private String id;
    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
