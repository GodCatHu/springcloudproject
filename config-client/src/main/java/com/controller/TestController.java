package com.controller;

import com.config.ClientConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huwei
 * @title: TestController
 * @projectName springcloudproject
 * @description: TODO
 * @date 2019/10/3110:35
 */
@RestController
public class TestController {
    @Autowired
    private ClientConfiguration clientConfiguration;
    //value是自动注入配置文件中的属性，从远程文件读取过来的依然可以注入(spring config)
    @Value("${server.port}")
    String key;
    @RequestMapping("/getkey")
    public String getKey(){
        return key;
    }
    @RequestMapping("/ping")
    public String ping(){
        return clientConfiguration.showProperties();
    }
}
