package com.ecoresystems.greweekly.analyticalwriting;


import com.ecoresystems.greweekly.analyticalwriting.domain.WritingAnswer;
import com.ecoresystems.greweekly.analyticalwriting.service.AnalyticalWritingService;
import com.ecoresystems.greweekly.auth.User;
import com.ecoresystems.greweekly.auth.UserRepository;
import com.ecoresystems.greweekly.data.entity.AnalyticalWriting;
import com.ecoresystems.greweekly.data.repository.WritingAnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, Object>> getAnswers(Authentication authentication) throws UnsupportedEncodingException{
//        String userMail = authentication.getName();
        Map<String,Object> response = new HashMap<>();
        String userMail = "sample@sample.com";
        List<WritingAnswer> writingAnswers = analyticalWritingService.getWritingAnswersForUser(userMail);
        List<AnalyticalWriting> writingQuestions = analyticalWritingService.getAllWritingQuestions();
        response.put("answers",writingAnswers);
        response.put("questions",writingQuestions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
