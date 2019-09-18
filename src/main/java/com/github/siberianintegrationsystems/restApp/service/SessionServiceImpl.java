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

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;
    private final AnswerRepository answerRepository;
    private final SelectedAnswerRepository selectedAnswerRepository;



    public SessionServiceImpl(SessionRepository sessionRepository, AnswerRepository answerRepository, SelectedAnswerRepository selectedAnswerRepository) {
        this.sessionRepository = sessionRepository;
        this.answerRepository = answerRepository;
        this.selectedAnswerRepository = selectedAnswerRepository;
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
        saveSelectedAnswer(dto.getQuestionsList(),session);




        return Double.toString(percent);
    }


    private void saveSelectedAnswer(List<AnsweredQuestionDTO> dto, Session session){
        dto.forEach(answeredQuestionDTO ->
                        answeredQuestionDTO.getAnswersList()
                                .forEach(sessionQuestionAnswer -> selectedAnswerRepository.save(
                                        new SelectedAnswer(session,
                                        answerRepository.findAnswerById(Long.valueOf(sessionQuestionAnswer.getId())))
                                        )
                                )
        );


    }


    private List<SessionQuestionAnswer> filter(List<SessionQuestionAnswer> dto){
        return dto.stream()
                .filter(sessionQuestionAnswer ->  sessionQuestionAnswer.getSelected()
                        == answerRepository.findAnswerById(Long.valueOf(sessionQuestionAnswer.getId())).getCorrect() )
                .collect(Collectors.toList());



    }
    private long getRightCountAnswers(List<AnsweredQuestionDTO> dto){
        return dto.stream()
                .map(answeredQuestionDTO -> filter(answeredQuestionDTO.getAnswersList()))
                .mapToLong(List::size).sum();






                    }

    private long getCountAnswers(List<AnsweredQuestionDTO> dto) {
        return dto.stream()
                .map(AnsweredQuestionDTO::getAnswersList)
                .mapToLong(List::size).sum();

    }
}
