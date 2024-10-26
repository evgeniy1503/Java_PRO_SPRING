package ru.prokhorov.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.prokhorov.product.entity.enums.ProductType;

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
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "user_id")
    Long userId;

    @Column(name = "account_number")
    String accountNumber;

    @Column(name = "amount")
    BigDecimal amount;

    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)
    ProductType productType;
}
