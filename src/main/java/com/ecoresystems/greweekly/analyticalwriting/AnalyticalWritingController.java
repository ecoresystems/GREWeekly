package com.ecoresystems.greweekly.analyticalwriting;


import com.ecoresystems.greweekly.analyticalwriting.service.AnalyticalWritingService;
import com.ecoresystems.greweekly.data.entity.AnalyticalWriting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping(value = "/analytical_writing")
@PreAuthorize("hasRole('ROLE_USER')")
public class AnalyticalWritingController {

    @Autowired
    private AnalyticalWritingService analyticalWritingService;

    @RequestMapping(method= RequestMethod.GET)
    public String getQuestions(Authentication authentication, Model model){
        String currentUser = authentication.getName();
        AnalyticalWriting writingQuestion = this.analyticalWritingService.getWritingQuestionForUser(currentUser);
        model.addAttribute("writingQuestion", writingQuestion);
        return "analytical_writing";
    }

    @GetMapping(value="/saved_answers")
    public String getAnswers(){
        return "answers_view";
    }
}
