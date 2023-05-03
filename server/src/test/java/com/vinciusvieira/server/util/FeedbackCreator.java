package com.vinciusvieira.server.util;

import com.vinciusvieira.server.api.representation.models.request.FeedbackResquest;
import com.vinciusvieira.server.domain.models.Feedback;

import java.util.UUID;

public abstract class FeedbackCreator {
    public static Feedback mockValidFeedback(){
        return Feedback.builder()
                .idFeedback(UUID.fromString("7f9f2b4d-0c46-4f17-819f-b7157c324642"))
                .comment("Comment Test")
                .type("TESTE")
                .screenshot("Foto para screenshot")
                .build();
    }

    public static FeedbackResquest mockValidFeedbackRequest(){
        return FeedbackResquest.builder()
                .comment("Comment Test")
                .type("TESTE")
                .screenshot("Foto para screenshot")
                .build();
    }

    public static FeedbackResquest mockInvalidFeedbackRequest(){
        return FeedbackResquest.builder()
                .comment(null)
                .type(null)
                .build();
    }
}
