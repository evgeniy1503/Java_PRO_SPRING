package ru.prokhorov.payment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.prokhorov.payment.dto.PaymentReqDto;
import ru.prokhorov.payment.dto.ProductRespDto;
import ru.prokhorov.payment.service.PaymentService;
import ru.prokhorov.payment.service.ProductIntegrationService;

import java.util.List;

/**
 * Контроллер для работы с платежами.
 *
 * @author Evgeniy_Prokhorov
 */

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final ProductIntegrationService productIntegrationService;
    private final PaymentService paymentService;

    @GetMapping("/products")
    public List<ProductRespDto> getProducts(@RequestParam Long userId) {
        return productIntegrationService.getProductsByUserId(userId);
    }

    @PostMapping("/pay")
    public ProductRespDto executePayment(@RequestBody PaymentReqDto requestDto) {
        return paymentService.executePayment(requestDto);
    }
}
