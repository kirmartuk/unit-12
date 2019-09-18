package com.github.siberianintegrationsystems.restApp;

import com.github.siberianintegrationsystems.restApp.controller.SessionRestController;
import com.github.siberianintegrationsystems.restApp.controller.dto.QuestionsItemDTO;
import com.github.siberianintegrationsystems.restApp.data.AnswerRepository;
import com.github.siberianintegrationsystems.restApp.data.QuestionRepository;
import com.github.siberianintegrationsystems.restApp.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestAppApplicationTests {
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;
	private final QuestionService questionService;

	public RestAppApplicationTests(QuestionRepository questionRepository, AnswerRepository answerRepository, QuestionService questionService) {
		this.questionRepository = questionRepository;
		this.answerRepository = answerRepository;
		this.questionService = questionService;
	}




}
