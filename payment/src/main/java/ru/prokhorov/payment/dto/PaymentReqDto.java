package ru.prokhorov.payment.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * ДТО для совершения платежа.
 *
 * @author Evgeniy_Prokhorov
 */
@Getter
@Setter
public class PaymentReqDto {
    private Long productId;
    private BigDecimal amount;
}
