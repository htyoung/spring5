package com.hty.spring5.core.controller;

import com.hty.spring5.core.exception.BusinessException;
import com.hty.spring5.core.model.ResultWrapper;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public ResultWrapper hello(ServerWebExchange serverWebExchange, ServerHttpRequest request) {
        throw new BusinessException("业务异常");
        //return ResultWrapper.asSuccess(123);
    }
}
