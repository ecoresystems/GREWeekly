package com.ecoresystems.greweekly.analyticalwriting;


import com.ecoresystems.greweekly.analyticalwriting.domain.WritingAnswer;
import com.ecoresystems.greweekly.analyticalwriting.service.AnalyticalWritingService;
import com.ecoresystems.greweekly.auth.User;
import com.ecoresystems.greweekly.auth.UserRepository;
import com.ecoresystems.greweekly.data.repository.WritingAnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping(value="/api")
//@PreAuthorize("hasRole('ROLE_USER')")
public class AnalyticalWritingAPIController {

    private final UserRepository userRepository;
    private final WritingAnswersRepository writingAnswersRepository;

    @Autowired
    private AnalyticalWritingService analyticalWritingService;

    public AnalyticalWritingAPIController(UserRepository userRepository, WritingAnswersRepository writingAnswersRepository){
        super();
        this.userRepository = userRepository;
        this.writingAnswersRepository = writingAnswersRepository;
    }

    @PostMapping(value="/save_answer")
    public @ResponseBody String saveAnswer(@RequestBody WritingAnswer writingAnswer) throws UnsupportedEncodingException {
        User user = userRepository.findByMail(writingAnswer.getUserMail());
        writingAnswer.setUserId(user.getId());
        this.writingAnswersRepository.save(writingAnswer.translateModelToAnswer());
        return "answer_saved";
    }

    @GetMapping(value = "/get_answers")
    public @ResponseBody List<WritingAnswer> getAnswers(Authentication authentication) throws UnsupportedEncodingException{
//        String userMail = authentication.getName();
        String userMail = "sample@sample.com";
        return analyticalWritingService.getWritingAnswersForUser(userMail);
    }
}
