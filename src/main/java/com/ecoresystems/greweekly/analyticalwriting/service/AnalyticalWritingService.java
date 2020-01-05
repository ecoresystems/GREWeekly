package com.ecoresystems.greweekly.analyticalwriting.service;

import com.ecoresystems.greweekly.analyticalwriting.domain.WritingQuestion;
import com.ecoresystems.greweekly.data.entity.AnalyticalWriting;
import com.ecoresystems.greweekly.data.entity.Users;
import com.ecoresystems.greweekly.data.entity.WritingAnswers;
import com.ecoresystems.greweekly.data.repository.AnalyticalWritingRepository;
import com.ecoresystems.greweekly.data.repository.UsersRepository;
import com.ecoresystems.greweekly.data.repository.WritingAnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
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

    public AnalyticalWriting getWritingQuestionForUser(String userMail){

        AtomicInteger issueCount = new AtomicInteger(0);
        AtomicInteger argumentCount = new AtomicInteger(0);
        Users user = this.usersRepository.findByMail(userMail);
        short typeSelection;
        Iterable<WritingAnswers> answers = (Iterable<WritingAnswers>) this.writingAnswersRepository.findAllByUserId(user.getId());
        List<Integer> answeredQuestions = new ArrayList<Integer>();
        answers.forEach(answer->{
            int questionId = answer.getQuestionId();
            answeredQuestions.add(questionId);
            AnalyticalWriting analyticalWriting = this.analyticalWritingRepository.findById(questionId);
            short questionType = analyticalWriting.getType();
            if (questionType==0)
                issueCount.getAndIncrement();
            else
                argumentCount.getAndIncrement();
        });
        int answeredCount = 0;
        if (issueCount.get()>=argumentCount.get()){
            typeSelection = (short) 0;
            answeredCount = issueCount.get();
        }
        else{
            typeSelection = (short)1;
            answeredCount = argumentCount.get();
        }



        List<AnalyticalWriting> questions = this.analyticalWritingRepository.findAllByType(typeSelection);
        AnalyticalWriting returnQuestion = new AnalyticalWriting();
        int loopCounter = 0;
        if (answeredCount < questions.size()){
            while (true){
                Random rand = new Random();
                AnalyticalWriting randomElement = questions.get(rand.nextInt(questions.size()));
                if (!answeredQuestions.contains(randomElement.getId())){
                    returnQuestion = randomElement;
                    break;
                }
                else if (loopCounter > 100){
                    break;
                }
                loopCounter ++;
            }

        }

        return returnQuestion;
    }
}
