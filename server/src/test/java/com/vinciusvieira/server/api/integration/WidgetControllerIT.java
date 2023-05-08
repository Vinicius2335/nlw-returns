package com.vinciusvieira.server.api.integration;

import com.vinciusvieira.server.api.representation.models.request.FeedbackResquest;
import com.vinciusvieira.server.util.FeedbackCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DisplayName("Teste de Integração WidgetController")
class WidgetControllerIT {
    @Autowired
    private TestRestTemplate testRestTemplate;

    private FeedbackResquest expectedFeedBackRequest;

    @BeforeEach
    void setUp() {
        expectedFeedBackRequest = FeedbackCreator.mockValidFeedbackRequest();
    }

    // BUG: problema com environment variable
    @Test
    @DisplayName("createFeedbacks return FeedbackResquest when successful")
    void createFeedbacks_ReturnFeedbackRequest_WhenSuccessul(){
        FeedbackResquest feedbackToSave = FeedbackCreator.mockValidFeedbackRequest();

        ResponseEntity<FeedbackResquest> exchange = testRestTemplate.exchange(
                "/feedbacks",
                HttpMethod.POST,
                new HttpEntity<>(feedbackToSave),
                FeedbackResquest.class
        );

        assertAll(
                () -> assertNotNull(exchange.getBody()),
                () -> assertEquals(HttpStatus.CREATED, exchange.getStatusCode()),
                () -> assertEquals(expectedFeedBackRequest, exchange.getBody())
        );
    }
}