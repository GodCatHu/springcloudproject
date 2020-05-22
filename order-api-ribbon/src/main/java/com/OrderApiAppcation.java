package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * @author huwei
 * @title: OrderApiAppcation
 * @projectName springcloudproject
 * @description: TODO
 * @date 2019/11/411:40
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClients({
        @RibbonClient(name = "order-service")
})
//@EnableHystrix
public class OrderApiAppcation {
//    @Bean
//    @LoadBalanced
//    RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
    @Bean
    @LoadBalanced
    RestTemplate restTemplateRule(RestTemplateBuilder restTemplateBuilder){
        //此Bean规则是定义了连接微服务主机超时时间，定义了从微服务读取数据的超时时间(全局中只能有一个RestTemplate  Bean)
        return restTemplateBuilder.setConnectTimeout(Duration.ofNanos(1000)).setReadTimeout(Duration.ofNanos(1000)).build();
    }
    public static void main(String[] args) {
        SpringApplication.run(OrderApiAppcation.class,args);
    }
}
