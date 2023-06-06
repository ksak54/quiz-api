package com.example.quizapi.service;

import com.example.quizapi.bean.Constants;
import com.example.quizapi.bean.QuizQuestion;
import com.example.quizapi.bean.response.NextQuestionResponse;
import com.example.quizapi.bean.response.QuestionResponse;
import com.example.quizapi.repository.QuestionRepository;
import com.example.quizapi.utils.datamapper.EntityToDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Optional<QuestionResponse> startPlaying() {
        Constants.PAGE = new AtomicInteger(Constants.ZERO);
        Pageable pageable = PageRequest.of(Constants.PAGE.get(), Constants.ONE);
        Page<QuizQuestion> questions = questionRepository.findAll(pageable);
        return questions.getContent().stream().map(EntityToDto::entityToQuestionResponse).findFirst();
    }

    @Override
    public Optional<NextQuestionResponse> next(int id) {
        Constants.PAGE = new AtomicInteger(Constants.PAGE.incrementAndGet() % Constants.Q_BANK);
        Pageable pageable = PageRequest.of(Constants.PAGE.get(), Constants.ONE);
        Page<QuizQuestion> questions =  questionRepository.findAll(pageable);
        Optional<QuizQuestion> quizQuestion = questionRepository.findByQuestionId(id);
        if(quizQuestion.isPresent()) {
            String answer = quizQuestion.get().getAnswer();
            QuestionResponse questionResponse = questions.getContent().stream().map(EntityToDto::entityToQuestionResponse).findFirst().get();
            return Optional.of(NextQuestionResponse
                    .builder()
                    .correctAnswer(answer)
                    .nextQuestion(questionResponse)
                    .build());
        } else {
            return Optional.empty();
        }
    }
}
