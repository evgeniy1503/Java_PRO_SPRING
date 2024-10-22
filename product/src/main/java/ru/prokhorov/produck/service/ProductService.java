package ru.prokhorov.produck.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.prokhorov.produck.entity.Product;
import ru.prokhorov.produck.entity.dto.ProductUpdateDto;
import ru.prokhorov.produck.repository.ProductDAO;

import java.util.List;

/**
 * Сервис по работе с {@link ProductDAO}.
 *
 * @author Evgeniy_Prokhorov
 */

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDAO productDAO;

    /**
     * Создать продукт
     *
     * @param product продукт
     */
    public void saveProduct(Product product) {
        productDAO.createProduct(product);
    }

    /**
     * Получить продукт по идентификатору
     *
     * @param id идентификатор
     * @return продукт
     */
    public Product getProductById(Long id) {
        return productDAO.findProductById(id).orElseThrow(() -> new RuntimeException("Продукт не найден с ID: " + id));
    }

    /**
     * Получить список продуктов по идентификатору пользователя
     *
     * @param userId идентификатор пользователя
     * @return список продуктов
     */
    public List<Product> getProductByUserId(Long userId) {
        return productDAO.findProductByUserId(userId);
    }

    public Product updateProduct(Long id,
                                 ProductUpdateDto dto) {
        productDAO.updateProductById(id, dto);
        return getProductById(id);
    }
}