package ru.prokhorov.hw1.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Тип продукта.
 *
 * @author Evgeniy_Prokhorov
 */
@Getter
@AllArgsConstructor
public enum ProductType {
    ACCOUNT("Счет"),
    CARD("Карта");

    final String description;
}
