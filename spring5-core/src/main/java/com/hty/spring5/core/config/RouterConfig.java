package com.hty.spring5.core.config;

import com.hty.spring5.core.function.HelloHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private HelloHandler helloHandler;

    @Bean
    public RouterFunction<ServerResponse> routeHello() {
        return RouterFunctions.route().GET("/hello1", request -> helloHandler.handleHello1(request)).build();
    }
}
