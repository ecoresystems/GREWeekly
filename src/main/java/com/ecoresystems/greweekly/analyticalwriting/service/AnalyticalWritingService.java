package com.ecoresystems.greweekly.analyticalwriting.service;

import com.ecoresystems.greweekly.analyticalwriting.domain.WritingAnswer;
import com.ecoresystems.greweekly.analyticalwriting.domain.WritingQuestions;
import com.ecoresystems.greweekly.data.entity.AnalyticalWriting;
import com.ecoresystems.greweekly.data.entity.Users;
import com.ecoresystems.greweekly.data.entity.WritingAnswers;
import com.ecoresystems.greweekly.data.repository.AnalyticalWritingRepository;
import com.ecoresystems.greweekly.data.repository.UsersRepository;
import com.ecoresystems.greweekly.data.repository.WritingAnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AnalyticalWritingService {
    private final AnalyticalWritingRepository analyticalWritingRepository;
    private final UsersRepository usersRepository;
    private final WritingAnswersRepository writingAnswersRepository;

    @Autowired
    public AnalyticalWritingService(AnalyticalWritingRepository analyticalWritingRepository, UsersRepository usersRepository, WritingAnswersRepository writingAnswersRepository) {
        this.analyticalWritingRepository = analyticalWritingRepository;
        this.usersRepository = usersRepository;
        this.writingAnswersRepository = writingAnswersRepository;
    }

    public List<WritingQuestions> getWritingQuestionForType(){

        AtomicInteger issueCount = new AtomicInteger(0);
        AtomicInteger argumentCount = new AtomicInteger(0);
        Users user = this.usersRepository.findByMail("sample@sample.com");
        short typeSelection;
        Iterable<WritingAnswers> answers = (Iterable<WritingAnswers>) this.writingAnswersRepository.findAllByUserId(user.getId());

        answers.forEach(answer->{
            int questionId = answer.getQuestionId();
            AnalyticalWriting analyticalWriting = this.analyticalWritingRepository.findById(questionId);
            short questionType = analyticalWriting.getType();
            if (questionType==0)
                issueCount.getAndIncrement();
            else
                argumentCount.getAndIncrement();
        });

        if (issueCount.get()>=argumentCount.get())
            typeSelection = (short) 0;
        else
            typeSelection = 1;


        Iterable<AnalyticalWriting> questions = this.analyticalWritingRepository.findAllByType(typeSelection);


        Map<Integer, WritingQuestions> analyticalWritingMap = new HashMap<>();

        questions.forEach(question->{
            WritingQuestions writingQuestions = new WritingQuestions();
            writingQuestions.setQuestionId(question.getId());
            writingQuestions.setQuestionBody(question.getBody());
            if (question.getType() == 0){
                writingQuestions.setQuestionType("Issue");
            }
            else {
                writingQuestions.setQuestionType("Argument");
            }
            analyticalWritingMap.put(question.getId(),writingQuestions);
        });
        List<WritingQuestions> writingQuestions = new ArrayList<>();

        for(Integer questionId:analyticalWritingMap.keySet()){
            writingQuestions.add(analyticalWritingMap.get(questionId));
        }
        return writingQuestions;
    }
}
