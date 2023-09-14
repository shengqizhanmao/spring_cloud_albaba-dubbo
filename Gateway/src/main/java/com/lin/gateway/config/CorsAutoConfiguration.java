package com.lin.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/*
* 解决跨域问题*/
@Configuration
public class CorsAutoConfiguration {
	@Bean
	public WebFilter corsFilter() {
		/**
		* ServerWebExchange：请求上下文，里面可以获取request和response等信息
		* WebFilterChain：放行链，将请求放行给下一个过滤器
		*/
		return (ServerWebExchange ctx, WebFilterChain chain) -> {
			ServerHttpRequest request = ctx.getRequest();
			if(CorsUtils.isCorsRequest(request)) {
				ServerHttpResponse response = ctx.getResponse();
				HttpHeaders headers = response.getHeaders();
				// 允许跨域访问
				headers.set(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,
					request.getHeaders().getOrigin());
				// 允许的header
				headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
					"X-Token,Token,Authorization,x-requested-with,Content-Type");
				headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,
					"PUT,POST,GET,OPTIONS,DELETE");
				headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
				headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "*");
				headers.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600");
				if(request.getMethod() == HttpMethod.OPTIONS) {
					response.setStatusCode(HttpStatus.OK);
					return Mono.empty();
				}
			}
			return chain.filter(ctx);
		};
	}
}
/*
————————————————
原文链接：https://blog.csdn.net/qq_45538969/article/details/127235482*/
