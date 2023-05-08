package com.vinciusvieira.server.domain.services;

import com.vinciusvieira.server.domain.exceptions.MensagemNaoEnviadaException;
import com.vinciusvieira.server.domain.models.Email;
import com.vinciusvieira.server.util.EmailCreator;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.org.webcompere.systemstubs.environment.EnvironmentVariables;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith({SpringExtension.class, SystemStubsExtension.class})
@DisplayName("Testes unitários para EnviarEmailService")
class EnviarEmailServiceTest {
    @InjectMocks
    private EnviarEmailService enviarEmailService;

    @Mock
    private JavaMailSender mailSendermock;

    @SystemStub
    private EnvironmentVariables environmentVariables;

    private Email emailToSend;

    @BeforeEach
    void setUp() throws MessagingException {
        emailToSend = EmailCreator.mockValidEmail();
        environmentVariables.set("GMAIL", "teste@gmail.com");

        // mailSendermock - createMimeMessage
        MimeMessage mockMimeMessage = Mockito.mock(MimeMessage.class);
        BDDMockito.when(mailSendermock.createMimeMessage()).thenReturn(mockMimeMessage);

        // mailSendermock - send
        BDDMockito.doNothing().when(mailSendermock).send(any(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("enviarEmailSimples send a simple email when successful")
    void enviarEmailSimples_SendSimpleEmail_WhenSuccessful(){
        assertDoesNotThrow(() -> enviarEmailService.enviarEmailSimples(emailToSend));
    }

    @Test
    @DisplayName("enviarEmailSimples Throws MensagemNaoEnviadaException when there is an error")
    void enviarEmailSimples_ThrowsMensagemNaoEnviadaException_WhenThereIsAnError(){
        BDDMockito.doThrow(MensagemNaoEnviadaException.class).when(mailSendermock).send(any(SimpleMailMessage.class));

        assertThrows(MensagemNaoEnviadaException.class, () -> enviarEmailService.enviarEmailSimples(emailToSend));
    }

    @Test
    void testEnviroment(){
        environmentVariables.set("ENV", "vinicius");

        assertEquals("vinicius", System.getenv("ENV"));
    }

    @Test
    @DisplayName("enviarEmailHtml send a email with tags html when successful")
    void enviarEmailHtml_SendEmailWithTagsHtml_WhenSuccessul(){
        assertDoesNotThrow(() -> enviarEmailService.enviarEmailHtml(emailToSend));
    }

    @Test
    @DisplayName("enviarEmailHtml throws MensagemNaoEnviadaException when there is a error")
    void enviarEmailHtml_ThrowsMensagemNaoEnviadaException_WhenThereIsAError(){
        BDDMockito.doThrow(MensagemNaoEnviadaException.class).when(mailSendermock)
                .send(any(MimeMessage.class));

        assertThrows(MensagemNaoEnviadaException.class, ()-> enviarEmailService.enviarEmailHtml(emailToSend));
    }
}