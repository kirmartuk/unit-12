package com.github.siberianintegrationsystems.restApp.controller.dto.session;

import com.github.siberianintegrationsystems.restApp.controller.dto.journal.JournalItemDTO;
import com.github.siberianintegrationsystems.restApp.entity.Session;

import java.time.LocalDateTime;

public class SessionItemDTO extends JournalItemDTO {
    private String name;
    private LocalDateTime insertDate;
    private Double result;

    public SessionItemDTO(Session session) {
        this.id = session.getId().toString();
        this.name = session.getFio();
        this.insertDate = session.getInsertDate();
        this.result = session.getPercent();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
