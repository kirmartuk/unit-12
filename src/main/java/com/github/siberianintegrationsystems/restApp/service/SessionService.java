package com.github.siberianintegrationsystems.restApp.service;

import com.github.siberianintegrationsystems.restApp.controller.dto.AnsweredQuestionDTO;
import com.github.siberianintegrationsystems.restApp.controller.dto.session.SessionRequestDTO;
import com.github.siberianintegrationsystems.restApp.entity.Session;

import java.util.List;

public interface SessionService {
    String create(SessionRequestDTO dto);
}
