package com.vinciusvieira.server.api.exceptionhandler;

import com.vinciusvieira.server.domain.exceptions.MensagemNaoEnviadaException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
         HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<Problema.Campo> campos = new ArrayList<>();

        List<FieldError> camposComErro = ex.getBindingResult().getFieldErrors();
        camposComErro.forEach(erro -> campos.add(new Problema.Campo(
                erro.getField(),
                erro.getDefaultMessage()
        )));

        Problema problema = new Problema();
        problema.setStatus(status.value());
        problema.setDataHora(OffsetDateTime.now());
        problema.setTitulo("Um ou mais campos estão inválido. Faça o preenchimento correto e tente novamente.");
        problema.setCampos(campos);

        return handleExceptionInternal(ex, problema, headers, status, request);
    }

    @ExceptionHandler(MensagemNaoEnviadaException.class)
    public ResponseEntity<Object> handleMensagemNaoEnviadaException(MensagemNaoEnviadaException ex, WebRequest request){
       HttpStatusCode status = HttpStatus.BAD_REQUEST;

       Problema problema = new Problema();
       problema.setStatus(status.value());
       problema.setDataHora(OffsetDateTime.now());
       problema.setTitulo("Erro ao tentar enviar email. Tente novamente.");

       return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
    }
}
