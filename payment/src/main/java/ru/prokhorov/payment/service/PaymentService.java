package ru.prokhorov.payment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.prokhorov.payment.dto.PaymentReqDto;
import ru.prokhorov.payment.dto.ProductRespDto;
import ru.prokhorov.payment.exception.BalanceException;
import ru.prokhorov.payment.exception.EntityNotFoundException;

import java.util.Objects;

/**
 * Сервис по работе с платежами.
 *
 * @author Evgeniy_Prokhorov
 */
@Service
@RequiredArgsConstructor
public class PaymentService {

    private final ProductIntegrationService productIntegrationService;

    /**
     * Совершение платежа
     *
     * @param requestDto ДТО для данных по платежу
     * @return Измененный продукт после платежа
     */
    public ProductRespDto executePayment(final PaymentReqDto requestDto) {
        ProductRespDto product = productIntegrationService.getProductById(requestDto.getProductId());
        validationProduct(product, requestDto);
        return productIntegrationService.updateProductById(requestDto);
    }

    /**
     * Валидация продукта на баланс и существования продукта
     *
     * @param product Целевой продукт
     * @param dto ДТО для изменения продукта
     */
    private void validationProduct(final ProductRespDto product,
                                   final PaymentReqDto dto) {
        if (Objects.isNull(product)) {
            throw new EntityNotFoundException("Не найден продукт с ID " + dto.getProductId());
        }
        if (product.getAmount().compareTo(dto.getAmount()) < 0) {
            throw new BalanceException("Недостаточно средств для совершения операции по продукту с ID " + dto.getProductId());
        }
        dto.setAmount(product.getAmount().subtract(dto.getAmount()));
    }
}
