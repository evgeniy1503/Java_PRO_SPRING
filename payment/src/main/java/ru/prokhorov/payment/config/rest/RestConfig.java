package ru.prokhorov.payment.config.rest;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.prokhorov.payment.config.properties.ProductExecutorProperties;
import ru.prokhorov.payment.config.properties.RestProperties;

/**
 * Конфигурация проекта.
 *
 * @author Evgeniy_Prokhorov
 */

@Configuration
@EnableConfigurationProperties(
        {ProductExecutorProperties.class}
)
public class RestConfig {

    @Bean("productRestClient")
    public RestTemplate productRestClient(final ProductExecutorProperties properties,
                                        final RestTemplateErrorResponseHandler errorResponseHandler) {
        final RestProperties productExecutor = properties.getProductExecutor();
        return new RestTemplateBuilder()
                .rootUri(productExecutor.getUrl())
                .setConnectTimeout(productExecutor.getConnectTimeout())
                .setReadTimeout(productExecutor.getReadTimeout())
                .errorHandler(errorResponseHandler)
                .build();
    }
}
