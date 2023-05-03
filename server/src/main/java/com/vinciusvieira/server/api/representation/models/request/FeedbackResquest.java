package com.vinciusvieira.server.api.representation.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FeedbackResquest {
    @NotBlank(message = "Type não pode ser nulo ou vazio")
    private String type;
    @NotBlank(message = "Comment não pode ser nulo ou vazio")
    private String comment;
    private String screenshot;
}
