package ru.prokhorov.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ДТО для описания ошибок приложения.
 *
 * @author Evgeniy_Prokhorov
 */
@Getter
@AllArgsConstructor
public class ErrorResponseDto {
    private int code;
    private String message;
}
