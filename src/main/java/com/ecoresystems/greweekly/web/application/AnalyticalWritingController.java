package com.ecoresystems.greweekly.web.application;


import com.ecoresystems.greweekly.analyticalwriting.domain.WritingQuestions;
import com.ecoresystems.greweekly.analyticalwriting.service.AnalyticalWritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        List<WritingQuestions> writingQuestionsList = this.analyticalWritingService.getWritingQuestionForType();

        Random rand = new Random();
        WritingQuestions randomElement = writingQuestionsList.get(rand.nextInt(writingQuestionsList.size()));
        model.addAttribute("writingQuestions", randomElement);
        return "analytical_writing";
    }
}
