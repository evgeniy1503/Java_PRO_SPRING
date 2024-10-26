package ru.prokhorov.produck.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.prokhorov.produck.entity.enums.ProductType;

import java.math.BigDecimal;

/**
 * Продукт.
 *
 * @author Evgeniy_Prokhorov
 */
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Product {
    Long id;
    Long userId;
    String accountNumber;
    BigDecimal amount;
    ProductType productType;
}
