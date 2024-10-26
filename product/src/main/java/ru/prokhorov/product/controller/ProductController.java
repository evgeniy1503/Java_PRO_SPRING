package ru.prokhorov.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.prokhorov.product.entity.Product;
import ru.prokhorov.product.entity.dto.ProductUpdateDto;
import ru.prokhorov.product.service.ProductService;

import java.util.List;

/**
 * Контроллер по работе с Продуктами.
 *
 * @author Evgeniy_Prokhorov
 */
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void create(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> getProductByUserId(@RequestParam Long userId) {
        return ResponseEntity.ok(productService.getProductByUserId(userId));
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody ProductUpdateDto dto,
                                 @PathVariable Long id) {
        return productService.updateProduct(id, dto);
    }

}
