package com.hty.spring5.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routeHello() {
        return RouterFunctions.route().GET("/hello1", request -> Mono.just(request.queryParam("time")).flatMap(item -> ServerResponse.ok().syncBody(item))).build();
    }
}
