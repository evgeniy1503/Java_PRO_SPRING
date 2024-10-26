package ru.prokhorov.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.prokhorov.product.entity.Product;
import ru.prokhorov.product.entity.dto.ProductUpdateDto;
import ru.prokhorov.product.repository.ProductRepository;

import java.util.List;

/**
 * Сервис по работе с Репозиторием
 *
 * @author Evgeniy_Prokhorov
 */

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productDAO;

    /**
     * Создать продукт
     *
     * @param product продукт
     */
    @Transactional
    public void saveProduct(Product product) {
        productDAO.save(product);
    }

    /**
     * Получить продукт по идентификатору
     *
     * @param id идентификатор
     * @return продукт
     */
    @Transactional(readOnly = true)
    public Product getProductById(Long id) {
        return productDAO.findById(id).orElseThrow(() -> new RuntimeException("Продукт не найден с ID: " + id));
    }

    /**
     * Получить список продуктов по идентификатору пользователя
     *
     * @param userId идентификатор пользователя
     * @return список продуктов
     */
    @Transactional(readOnly = true)
    public List<Product> getProductByUserId(Long userId) {
        return productDAO.findProductByUserId(userId);
    }

    /**
     * Обновление данных по продукту
     *
     * @param id идентификатор продукта
     * @param dto ДТО продукта
     * @return обновленный продукт
     */
    @Transactional
    public Product updateProduct(Long id,
                                 ProductUpdateDto dto) {
        Product oldProduct = this.getProductById(id);
        oldProduct.setAmount(dto.getAmount());
        productDAO.save(oldProduct);
        return getProductById(id);
    }
}
