package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author huwei
 * @title: ClientConfiguration
 * @projectName springcloudproject
 * @description: TODO
 * @date 2019/10/3114:58
 */
@Component
@RefreshScope
public class ClientConfiguration {
    @Value("${sample.string.property}")
    private String sampleStringProperty;
    @Value("${sample.int.property}")
    private int sampleIntProperty;
    public String showProperties(){
        return String.format("HuWei from %s %d",sampleStringProperty,sampleIntProperty);
    }
}
