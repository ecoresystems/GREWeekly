package com.ecoresystems.greweekly.analyticalwriting;


import com.ecoresystems.greweekly.analyticalwriting.domain.WritingAnswer;
import com.ecoresystems.greweekly.analyticalwriting.domain.WritingQuestion;
import com.ecoresystems.greweekly.analyticalwriting.service.AnalyticalWritingService;
import com.ecoresystems.greweekly.data.entity.AnalyticalWriting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Controller

@RequestMapping(value = "/analytical_writing")
@PreAuthorize("hasRole('ROLE_USER')")
public class AnalyticalWritingController {

    @Autowired
    private AnalyticalWritingService analyticalWritingService;

    @RequestMapping(method= RequestMethod.GET)
    public String getQuestions(@RequestParam(value="date", required=false)String dateString, Model model){

        AnalyticalWriting writingQuestion = this.analyticalWritingService.getWritingQuestionForUser("sample@sample.com");
        model.addAttribute("writingQuestion", writingQuestion);
        return "analytical_writing";
    }
}
