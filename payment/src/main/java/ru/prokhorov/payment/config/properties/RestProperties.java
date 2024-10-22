package ru.prokhorov.payment.config.properties;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

/**
 * Общие параметры настройки для интеграций.
 *
 * @author Evgeniy_Prokhorov
 */

@Getter
@Setter
public class RestProperties {
    private String url;
    private Duration connectTimeout;
    private Duration readTimeout;
}
