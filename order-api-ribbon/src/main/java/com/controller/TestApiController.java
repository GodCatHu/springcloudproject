package com.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author huwei
 * @title: TestApiController
 * @projectName springcloudproject
 * @description: TODO
 * @date 2019/11/411:42
 */
@RestController
public class TestApiController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/test")
    public JSONObject test(){
        ResponseEntity<JSONObject> result= restTemplate.getForEntity("http://order-service/test",JSONObject.class);
        return result.getBody();
    }
}
