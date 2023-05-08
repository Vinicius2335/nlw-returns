package com.vinciusvieira.server.util;

import com.vinciusvieira.server.domain.models.Email;

public abstract class EmailCreator {

    public static Email mockValidEmail(){
        return Email.builder()
                .emailTo("teste@gmail.com")
                .subject("teste")
                .body("corpo da mensagem de teste")
                .build();
    }
}
