package ru.prokhorov.produck.repository;

import ru.prokhorov.produck.entity.Product;
import ru.prokhorov.produck.entity.dto.ProductUpdateDto;

import java.util.List;
import java.util.Optional;

/**
 * Репозиторий для {@link Product}.
 *
 * @author Evgeniy_Prokhorov
 */
public interface ProductDAO {
    /**
     * Сохранение продукт
     *
     * @param product Продукт
     */
    void createProduct(Product product);

    /**
     * Получение продукта по идентификатору
     *
     * @param id идентификатор
     * @return Пользователь
     */
    Optional<Product> findProductById(Long id);


    /**
     * Получить список продуктов по идентификатору пользователя
     *
     * @param userId идентификатор пользователя
     * @return список продуктов
     */
    List<Product> findProductByUserId(Long userId);

    void updateProductById(Long id, ProductUpdateDto dto);
}
