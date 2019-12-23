package com.hty.spring5.core.function;

import com.hty.spring5.core.model.ResultWrapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class HelloHandler {
    public Mono<ServerResponse> handleHello1(ServerRequest request) {
        String name = request.queryParam("name").orElse("");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).syncBody(ResultWrapper.asSuccess(name));
    }
}
