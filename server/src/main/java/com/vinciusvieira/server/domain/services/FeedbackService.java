package com.vinciusvieira.server.domain.services;

import com.vinciusvieira.server.api.mappers.FeedbackMapper;
import com.vinciusvieira.server.api.representation.models.request.FeedbackResquest;
import com.vinciusvieira.server.domain.models.Email;
import com.vinciusvieira.server.domain.models.Feedback;
import com.vinciusvieira.server.domain.repositories.FeedbackRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapper feedbackMapper;
    private final EnviarEmailService enviarEmailService;

    @Transactional
    public FeedbackResquest createFeedbackSimples(Feedback feedback){
        Feedback feedbackSaved = feedbackRepository.save(feedback);

        Email email = Email.builder()
                .emailTo(System.getenv("SEND_TO")) //environmment variable
                .subject("Novo Feedback enviado, do tipo: " + feedback.getType())
                .body("Comentário: " +feedback.getComment() + "\nScreenshot: " + feedback.getScreenshot())
                .build();

        enviarEmailService.enviarEmailSimples(email);
        return feedbackMapper.toFeedbackRequestModel(feedbackSaved);
    }

    @Transactional
    public FeedbackResquest createFeedbackHtml(Feedback feedback) {
        Feedback feedbackSaved = feedbackRepository.save(feedback);
        String feedbackScreenshot;

        if (feedback.getScreenshot().isBlank()){
            feedbackScreenshot = "Nenhum Screenshot foi adicionado";
        } else {
//            feedbackScreenshot = String.format("<a href='%s' target='_blank'>Visualizar</a>", feedback.getScreenshot());
            feedbackScreenshot = "<img src=\"" + feedback.getScreenshot() +"\" alt='Imagem'/>";
        }

        String htmContent =
                "<p><strong>Tipo do feedback: </strong>" + feedback.getType() + "</p>"+
                "<p><strong>Comentário: </strong>" + feedback.getComment() + "</p>" +
                "<p><strong>Screenshot: </strong>" + feedbackScreenshot + " </p>";

        Email email = Email.builder()
                .emailTo(System.getenv("SEND_TO")) //environmment variable
                .subject("Novo Feedback enviado")
                .body(htmContent)
                .build();

        enviarEmailService.enviarEmailHtml(email);
        return feedbackMapper.toFeedbackRequestModel(feedbackSaved);
    }
}
