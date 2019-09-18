package com.github.siberianintegrationsystems.restApp.service;

import com.github.siberianintegrationsystems.restApp.controller.dto.AnsweredQuestionDTO;
import com.github.siberianintegrationsystems.restApp.controller.dto.session.SessionQuestionAnswer;
import com.github.siberianintegrationsystems.restApp.controller.dto.session.SessionRequestDTO;
import com.github.siberianintegrationsystems.restApp.data.AnswerRepository;
import com.github.siberianintegrationsystems.restApp.data.QuestionRepository;
import com.github.siberianintegrationsystems.restApp.data.SelectedAnswerRepository;
import com.github.siberianintegrationsystems.restApp.data.SessionRepository;
import com.github.siberianintegrationsystems.restApp.entity.Answer;
import com.github.siberianintegrationsystems.restApp.entity.SelectedAnswer;
import com.github.siberianintegrationsystems.restApp.entity.Session;

import jdk.nashorn.internal.runtime.Debug;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private static Logger log = Logger.getLogger(SessionServiceImpl.class.getName());


    public SessionServiceImpl(SessionRepository sessionRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.sessionRepository = sessionRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;

    }


    @Override
    public String create(SessionRequestDTO dto) {
        Session session = new Session();
        session.setFio(dto.getName());
        session.setInsertDate(LocalDateTime.now());

        double allAnswers= getCountAnswers(dto.getQuestionsList());
        double correctAnswers = getRightCountAnswers(dto.getQuestionsList());
        double percent =  Math.round(correctAnswers / allAnswers * 100);
        session.setPercent(percent);
        sessionRepository.save(session);


        return Double.toString(percent);
    }
    private List<SessionQuestionAnswer> filter(List<SessionQuestionAnswer> dto){
        System.out.println(dto.stream().map(sessionQuestionAnswer -> sessionQuestionAnswer.getId()+sessionQuestionAnswer.isSelected()).collect(Collectors.toList()));
        List<SessionQuestionAnswer> answers =
        dto.stream()
                .filter(sessionQuestionAnswer ->  sessionQuestionAnswer.isSelected()
                        == answerRepository.findAnswerById(Long.valueOf(sessionQuestionAnswer.getId())).getCorrect() )
                .collect(Collectors.toList());
        List<String> right =
                dto.stream()
                .map(sessionQuestionAnswer ->sessionQuestionAnswer.getId()+answerRepository.findAnswerById(Long.valueOf(sessionQuestionAnswer.getId())).getCorrect())
                .collect(Collectors.toList());
        System.out.println(right.toString());
        System.out.println(answers.stream().map(sessionQuestionAnswer -> sessionQuestionAnswer.getId()+sessionQuestionAnswer.isSelected()).collect(Collectors.toList()));
        return answers;



    }
    private long getRightCountAnswers(List<AnsweredQuestionDTO> dto){
        return dto.stream()
                .map(answeredQuestionDTO -> filter(answeredQuestionDTO.getAnswersList()))
                .mapToLong(List::size).sum();



                /*
        return dto.stream()
                .map(answeredQuestionDTO ->
                        answeredQuestionDTO.getAnswersList()
                                .stream().filter(sessionQuestionAnswer ->
                                (answerRepository.findById(Long.valueOf(sessionQuestionAnswer.getId())).get()
                                        .getCorrect()).equals(sessionQuestionAnswer.isSelected()))
                                .mapToLong(value -> value.size()).sum();*/



                    }

    private long getCountAnswers(List<AnsweredQuestionDTO> dto) {
        return dto.stream()
                .map(AnsweredQuestionDTO::getAnswersList)
                .mapToLong(List::size).sum();

    }
}
