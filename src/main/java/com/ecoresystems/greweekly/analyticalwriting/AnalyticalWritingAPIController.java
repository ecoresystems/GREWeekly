package com.ecoresystems.greweekly.analyticalwriting;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
@PreAuthorize("hasRole('ROLE_USER')")
public class AnalyticalWritingAPIController {
    @PostMapping
    public String saveAnswer(){
        return "answer_saved";
    }
}
