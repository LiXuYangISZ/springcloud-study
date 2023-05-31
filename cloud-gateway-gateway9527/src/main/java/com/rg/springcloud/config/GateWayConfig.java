package com.rg.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lxy
 * @version 1.0
 * @Description
 * @date 2022/1/6 20:42
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_rg",r->r.path("/lady").uri("https://news.baidu.com/lady")).
                route("path_route_rg2",r->r.path("/guonei").uri("https://news.baidu.com/guonei")).
                build();
        return routes.build();
    }
}
