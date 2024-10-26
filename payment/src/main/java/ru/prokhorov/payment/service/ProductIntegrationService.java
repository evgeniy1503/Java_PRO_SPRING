package ru.prokhorov.payment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.prokhorov.payment.dto.PaymentReqDto;
import ru.prokhorov.payment.dto.ProductIntegrationDto;
import ru.prokhorov.payment.dto.ProductRespDto;

import java.util.List;

/**
 * Сервис по работе с внешней системой Продукты.
 *
 * @author Evgeniy_Prokhorov
 */

@Component
@RequiredArgsConstructor
public class ProductIntegrationService {

    private final RestTemplate productRestClient;

    /**
     * Получение Продукта по идентификатору пользователя через HTTP запрос
     *
     * @param userId идентификатор пользователя
     * @return список продуктов пользователя
     */
    public List<ProductRespDto> getProductsByUserId(final Long userId) {
        ParameterizedTypeReference<List<ProductRespDto>> responseType = new ParameterizedTypeReference<>() {
        };
        return productRestClient.exchange("/search?userId={userId}", HttpMethod.GET, null, responseType, userId).getBody();
    }

    /**
     * Получение продукта по идентификатору через HTTP запрос
     *
     * @param id идентификатор продукта
     * @return ДТО продукта
     */
    public ProductRespDto getProductById(final Long id) {
        return productRestClient.getForObject("/{id}", ProductRespDto.class, id);
    }

    /**
     * Изменения баланса продукта по его идентификатору через HTTP запрос
     *
     * @param dto ДТО для изменения баланса
     * @return обновленный продукт
     */
    public ProductRespDto updateProductById(final PaymentReqDto dto) {
        ParameterizedTypeReference<ProductRespDto> responseType = new ParameterizedTypeReference<>() {
        };
        HttpEntity<ProductIntegrationDto> requestEntity = new HttpEntity<>(new ProductIntegrationDto(dto.getAmount()));
        return productRestClient.exchange("/{id}", HttpMethod.PUT, requestEntity, responseType, dto.getProductId()).getBody();
    }
}
