package com.vinciusvieira.server.api.mappers;

import com.vinciusvieira.server.api.representation.models.request.FeedbackResquest;
import com.vinciusvieira.server.domain.models.Feedback;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedbackMapper {
    private final ModelMapper modelMapper;

    public Feedback toFeedbackModel(FeedbackResquest feedbackResquest){
        return modelMapper.map(feedbackResquest, Feedback.class);
    }

    public FeedbackResquest toFeedbackRequestModel(Feedback feedback){
        return modelMapper.map(feedback, FeedbackResquest.class);
    }
}
