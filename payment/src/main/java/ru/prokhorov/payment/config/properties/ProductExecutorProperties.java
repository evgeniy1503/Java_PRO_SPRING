package ru.prokhorov.payment.config.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Настройки интеграции для обращения к модулю Продуктов.
 *
 * @author Evgeniy_Prokhorov
 */
@ConfigurationProperties(prefix = "integration.products")
@RequiredArgsConstructor
@Getter
public class ProductExecutorProperties {

    private final RestProperties productExecutor;

}
