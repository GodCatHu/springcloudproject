package com.service.impl;

import com.service.Test;
import org.springframework.stereotype.Service;

/**
 * @author huwei
 * @title: TestImpl
 * @projectName springcloudproject
 * @description: TODO
 * @date 2019/11/410:50
 */
@Service
public class TestImpl implements Test {
    @Override
    public String test() {
        System.out.println("ascascascascas");
        return "ribbon服务";
    }
}
