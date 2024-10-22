package ru.prokhorov.payment.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Исключение при работе с внешними системами.
 *
 * @author Evgeniy_Prokhorov
 */
@Getter
public class IntegrationException extends RuntimeException {

    private final int codeStatus;

    public IntegrationException(String message, int codeStatus) {
        super(message);
        this.codeStatus = codeStatus;
    }
}
