package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author huwei
 * @title: OrderApiFeginApplication
 * @projectName springcloudproject
 * @description: TODO
 * @date 2019/11/515:56
 */
@SpringBootApplication//springboot核心配置
@EnableEurekaClient//开启eureka客户端
@EnableFeignClients//开启feign客户端
@EnableHystrix//开启hystrix断路器
@EnableCaching//开启缓存
@EnableHystrixDashboard//开启负载监控
public class OrderApiFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApiFeignApplication.class,args);
    }
    @Bean
    public CacheManager cacheManager(){
        //配置缓存名称为orderCache
        return new ConcurrentMapCacheManager("orderCache");
    }
}
