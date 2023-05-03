package com.vinciusvieira.server.api.controllers;

import com.vinciusvieira.server.api.mappers.FeedbackMapper;
import com.vinciusvieira.server.api.representation.models.request.FeedbackResquest;
import com.vinciusvieira.server.domain.models.Feedback;
import com.vinciusvieira.server.domain.services.FeedbackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600, origins = "*")
@RequiredArgsConstructor
@RestController
public class WidgetController {
    private final FeedbackService feedbackService;
    private final FeedbackMapper feedbackMapper;

    @GetMapping("/hello")
    public String hello(){
        return "Olá Nlw";
    }

    @PostMapping("/feedbacks")
    public ResponseEntity<FeedbackResquest> createFeedbacks(@RequestBody @Valid FeedbackResquest feedbackResquest) {
        Feedback feedbackToSave = feedbackMapper.toFeedbackModel(feedbackResquest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(feedbackService.createFeedbackHtml(feedbackToSave));
    }
}
