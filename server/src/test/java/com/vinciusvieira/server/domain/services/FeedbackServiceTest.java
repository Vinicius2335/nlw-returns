package com.vinciusvieira.server.domain.services;

import com.vinciusvieira.server.api.mappers.FeedbackMapper;
import com.vinciusvieira.server.api.representation.models.request.FeedbackResquest;
import com.vinciusvieira.server.domain.models.Email;
import com.vinciusvieira.server.domain.models.Feedback;
import com.vinciusvieira.server.domain.repositories.FeedbackRepository;
import com.vinciusvieira.server.util.FeedbackCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


@DisplayName("Teste Unitário para FeedbackService")
@ExtendWith(SpringExtension.class)
class FeedbackServiceTest {
    @InjectMocks
    private FeedbackService feedbackService;

    @Mock
    private FeedbackRepository feedbackRepositoryMock;
    @Mock
    private FeedbackMapper feedbackMapperMock;
    @Mock
    private EnviarEmailService enviarEmailServiceMock;

    private Feedback expectedFeedback;
    private FeedbackResquest expectedFeedbackResquest;

    @BeforeEach
    void setUp() {
        expectedFeedback = FeedbackCreator.mockValidFeedback();
        expectedFeedbackResquest = FeedbackCreator.mockValidFeedbackRequest();

        //FeedbackRepository - save
        BDDMockito.when(feedbackRepositoryMock.save(any(Feedback.class)))
                .thenReturn(expectedFeedback);

        // EnviarEmailService - enviarEmailSimples
        BDDMockito.doNothing().when(enviarEmailServiceMock).enviarEmailSimples(any(Email.class));

        // EnviarEmailService - enviarEmailHtml
        BDDMockito.doNothing().when(enviarEmailServiceMock).enviarEmailHtml(any(Email.class));

        // FeedbackMapper - toFeedbackRequestModel
        BDDMockito.when(feedbackMapperMock.toFeedbackRequestModel(any(Feedback.class)))
                .thenReturn(expectedFeedbackResquest);
    }

    @Test
    @DisplayName("createFeedbackSimples Return FeedbackRequest when successful")
    void createFeedbackSimples_ReturnFeedbackRequest_WhenSuccessful(){
        Feedback feedback = FeedbackCreator.mockValidFeedback();
        FeedbackResquest feedbackSimples = feedbackService.createFeedbackSimples(feedback);

        assertAll(
                () -> assertNotNull(feedbackSimples),
                () -> assertEquals(expectedFeedback.getComment(), feedbackSimples.getComment()),
                () -> assertEquals(expectedFeedback.getType(), feedbackSimples.getType()),
                () -> assertEquals(expectedFeedback.getScreenshot(), feedbackSimples.getScreenshot())
        );
    }

    // continuar TEST
    @Test
    @DisplayName("createFeedbackHtml Return a FeedbackRequest when successfull")
    void createFeedbackHtml_ReturnFeedbackRequest_WhenSuccessful(){
        Feedback feedback = FeedbackCreator.mockValidFeedback();
        FeedbackResquest feedbackHtml = feedbackService.createFeedbackHtml(feedback);

        assertAll(
                () -> assertNotNull(feedbackHtml),
                () -> assertEquals(expectedFeedbackResquest.getComment(), feedbackHtml.getComment()),
                () -> assertEquals(expectedFeedbackResquest.getScreenshot(), feedbackHtml.getScreenshot()),
                () -> assertEquals(expectedFeedbackResquest.getType(), feedbackHtml.getType())
        );
    }
}