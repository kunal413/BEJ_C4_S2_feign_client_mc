package com.niit.jap.demoAPIGatWay.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes().
                route(p->p
                        .path("/userservice/**")
                        .uri("http://authentication-service:64200/")
                )
                .route(p->p
                        .path("/usertrackapi/user/**")
                        .uri("http://track-service:64100/"))
                .build();


    }
}
