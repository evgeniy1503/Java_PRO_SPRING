package ru.prokhorov.payment.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * ДТО для ответа.
 *
 * @author Evgeniy_Prokhorov
 */

@Getter
@Setter
@ToString
public class ProductRespDto {
    private Long userId;
    private String accountNumber;
    private BigDecimal amount;
    private String productType;
}
