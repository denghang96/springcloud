package com.dengooo.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    /**
     * 网关路由有两种配置方式，一种就是在yml中直接配置，一种就是在这里硬编码
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder  routes = routeLocatorBuilder.routes();

        /*
         * 代表访问http://localhost:9527/guonei
         * 跳转到http://news.baidu.com/guonei
         * */
        routes.route("route1",
                r->r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        /*
         * 代表访问http://localhost:9527/guoji
         * 跳转到http://news.baidu.com/guoji
         * */
        routes.route("route2",
                r->r.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}