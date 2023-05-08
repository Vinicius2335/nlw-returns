package com.vinciusvieira.server.api.controllers;

import com.vinciusvieira.server.api.mappers.FeedbackMapper;
import com.vinciusvieira.server.api.representation.models.request.FeedbackResquest;
import com.vinciusvieira.server.domain.models.Feedback;
import com.vinciusvieira.server.domain.services.FeedbackService;
import com.vinciusvieira.server.util.FeedbackCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@DisplayName("Teste unitário de WidgetController")
class WidgetControllerTest {
    @InjectMocks
    private WidgetController widgetController;
    @Mock
    private FeedbackService feedbackServiceMock;
    @Mock
    private FeedbackMapper feedbackMapperMock;

    private FeedbackResquest expectedFeedbackRequest;
    private Feedback expectedFeedback;
    private FeedbackResquest feedbackResquestToSend;



    @BeforeEach
    void setUp() {
        expectedFeedback = FeedbackCreator.mockValidFeedback();
        expectedFeedbackRequest = FeedbackCreator.mockValidFeedbackRequest();
        feedbackResquestToSend = expectedFeedbackRequest;

        // feedbackMapperMock - toFeedbackModel
        BDDMockito.when(feedbackMapperMock.toFeedbackModel(any(FeedbackResquest.class)))
                        .thenReturn(expectedFeedback);

        // feedbackServiceMock - createFeedbackHtml
        BDDMockito.when(feedbackServiceMock.createFeedbackHtml(any(Feedback.class)))
                .thenReturn(expectedFeedbackRequest);
    }

    @Test
    @DisplayName("createFeedbacks return FeedbackResquest when successful")
    void createFeedbacks_ReturnFeedbackRequest_WhenSuccessul(){
        ResponseEntity<FeedbackResquest> feedbacks = widgetController.createFeedbacks(feedbackResquestToSend);

        assertAll(
                () -> assertNotNull(feedbacks.getBody()),
                () -> assertEquals(HttpStatus.CREATED, feedbacks.getStatusCode()),
                () -> assertEquals(expectedFeedbackRequest.getScreenshot(), feedbacks.getBody().getScreenshot()),
                () -> assertEquals(expectedFeedbackRequest.getType(), feedbacks.getBody().getType()),
                () -> assertEquals(expectedFeedbackRequest.getComment(), feedbacks.getBody().getComment())
        );
    }
}