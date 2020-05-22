package com.feign;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huwei
 * @title: OrderServiceFeign
 * @projectName springcloudproject
 * @description: TODO
 * @date 2019/11/516:31
 */
@FeignClient(name = "order-service")
public interface OrderServiceFeign {
    @RequestMapping("/test")
    public JSONObject test();
}
