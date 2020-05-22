package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author huwei
 * @title: GateWayApplication
 * @projectName springcloudproject
 * @description: TODO
 * @date 2019/11/2614:58
 */

@SpringBootApplication
@EnableEurekaClient
//@EnableZuulProxy//好像zuulProxy自动带有eureka客户端的效果,也就是说上面的eurekaClint可以不写,ps:此是开启zuul模式路由，而现在在springcloud中已经用spring gateway替代
//注意使用springcloud自身的gateway时。不需要任何的额外注解例如EnableXXX
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class,args);
    }
}
