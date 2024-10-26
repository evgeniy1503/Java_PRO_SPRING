package ru.prokhorov.product.entity.dto;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * ProductUpdateDto.
 *
 * @author Evgeniy_Prokhorov
 */
@Getter
public class ProductUpdateDto {
    private BigDecimal amount;
}
