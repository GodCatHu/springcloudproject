package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.service.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huwei
 * @title: TestController
 * @projectName springcloudproject
 * @description: TODO
 * @date 2019/11/410:50
 */
@RestController
public class TestController {
    @Autowired
    private Test test;
    @RequestMapping("/test")
    public JSONObject test(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg",test.test());
        return jsonObject;
    }
}
