package com.vinciusvieira.server.domain.repositories;

import com.vinciusvieira.server.domain.models.Feedback;
import com.vinciusvieira.server.util.FeedbackCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Teste Unitário de FeedbackRepository")
class FeedbackRepositoryTest {
    @Autowired
    private FeedbackRepository feedbackRepository;

    private Feedback expectedFeedback;

    @BeforeEach
    void setup(){
        expectedFeedback = FeedbackCreator.mockValidFeedback();
    }

    @Test
    void uuid(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        assertNotNull(uuid);
    }

    @Test
    @DisplayName("Save Feedback when successful")
    void save_InsertFeedback_WhenSuccessful(){
        Feedback feedbackToSave = FeedbackCreator.mockValidFeedback();
        Feedback feedbackSaved = feedbackRepository.save(feedbackToSave);

        assertAll(
                () -> assertNotNull(feedbackSaved.getIdFeedback()),
                () -> assertEquals(expectedFeedback.getType(), feedbackSaved.getType()),
                () -> assertEquals(expectedFeedback.getComment(), feedbackSaved.getComment())
        );
    }
}