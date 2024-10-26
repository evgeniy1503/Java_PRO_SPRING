package ru.prokhorov.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * ДТО для передачи в сервис Продуктов.
 *
 * @author Evgeniy_Prokhorov
 */
@Getter
@AllArgsConstructor
@ToString
public class ProductIntegrationDto {
    private BigDecimal amount;
}
