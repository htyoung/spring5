package com.hty.spring5core.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.reactive.filter.OrderedWebFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
@EnableAutoConfiguration
@EnableWebFlux
@EnableScheduling
@EnableAspectJAutoProxy
public class AppConfig implements WebFluxConfigurer {
    @Bean
    public WebFilter webFilter() {
        return new OrderedWebFilter() {
            @Override
            public int getOrder() {
                return 0;
            }

            @Override
            public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
                return chain.filter(exchange);
            }
        };
    }

    @Override
    public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
        //启用访问日志，仅在日志级别在DEBUG级别以上有效
        configurer.defaultCodecs().enableLoggingRequestDetails(true);
        //配置Jackson序列的属性
        configurer.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(new Jackson2ObjectMapperBuilder().serializationInclusion(JsonInclude.Include.NON_NULL).build()));
    }
}
