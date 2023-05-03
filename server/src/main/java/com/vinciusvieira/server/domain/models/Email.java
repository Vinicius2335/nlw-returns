package com.vinciusvieira.server.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Email {
    private String emailTo; // quem recebe
    private String subject; // titulo do email
    private String body; // corpo do email
}
