package com.vinciusvieira.server.domain.exceptions;

import java.io.Serial;

public class MensagemNaoEnviadaException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 3361697114479668824L;

    public MensagemNaoEnviadaException(String message, Throwable cause) {
        super(message, cause);
    }
}
