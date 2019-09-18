package com.github.siberianintegrationsystems.restApp.controller;

import com.github.siberianintegrationsystems.restApp.controller.dto.*;
import com.github.siberianintegrationsystems.restApp.controller.dto.session.SessionRequestDTO;
import com.github.siberianintegrationsystems.restApp.data.AnswerRepository;
import com.github.siberianintegrationsystems.restApp.data.QuestionRepository;
import com.github.siberianintegrationsystems.restApp.service.JournalService;
import com.github.siberianintegrationsystems.restApp.service.QuestionService;
import com.github.siberianintegrationsystems.restApp.service.SessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/session")
public class SessionRestController {
    private final JournalService journalService;
    private final QuestionService questionService;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final SessionService sessionService;

    public SessionRestController(JournalService journalService, QuestionService questionService, QuestionRepository questionRepository, AnswerRepository answerRepository, SessionService sessionService) {
        this.journalService = journalService;
        this.questionService = questionService;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.sessionService = sessionService;
    }


    @GetMapping("questions-new")
    public List<QuestionsItemDTO> get(){
        return questionService.getQuestions();
    }
    @PostMapping("")
    public String create(@RequestBody SessionRequestDTO dto) {
        return sessionService.create(dto);
    }
}
