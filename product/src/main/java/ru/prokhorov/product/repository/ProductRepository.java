package ru.prokhorov.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.prokhorov.product.entity.Product;

import java.util.List;

/**
 * ProductRepository.
 *
 * @author Evgeniy_Prokhorov
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByUserId(Long userId);
}
