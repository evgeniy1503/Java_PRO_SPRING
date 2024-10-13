package ru.prokhorov.hw1.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import ru.prokhorov.hw1.entity.enums.ProductType;

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
