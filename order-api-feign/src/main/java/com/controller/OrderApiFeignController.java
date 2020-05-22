package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huwei
 * @title: OrderApiFeignController
 * @projectName springcloudproject
 * @description: TODO
 * @date 2019/11/516:33
 */
@RestController
public class OrderApiFeignController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/test")
    public JSONObject test(){
        return orderService.test();
    }
}
