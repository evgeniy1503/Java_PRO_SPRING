package ru.prokhorov.payment.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.prokhorov.payment.dto.ErrorResponseDto;
import ru.prokhorov.payment.exception.BalanceException;
import ru.prokhorov.payment.exception.EntityNotFoundException;
import ru.prokhorov.payment.exception.IntegrationException;

/**
 * Перехватчик исключений.
 *
 * @author Evgeniy_Prokhorov
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDto handleEntityNotFoundException(EntityNotFoundException e) {
        return new ErrorResponseDto(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler(BalanceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handleBalanceException(BalanceException e) {
        return new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(IntegrationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handleIntegrationException(IntegrationException e) {
        return new ErrorResponseDto(e.getCodeStatus(), e.getMessage());
    }
}
