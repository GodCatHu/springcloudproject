package com.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.feign.OrderServiceFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author huwei
 * @title: OrderService
 * @projectName springcloudproject
 * @description: TODO
 * @date 2019/11/1114:28
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderServiceFeign orderServiceFeign;
    @Autowired
    private CacheManager cacheManager;
    @Override
    @HystrixCommand(fallbackMethod = "testFallbackMethod")//当此方法调用微服务失败时进行的回滚调用方法
    @CachePut(value = "orderCache",key = "'test'")//开启缓存,value为配置的整个缓存名称,后面的key则配置了当前方法的缓存key，且要注意此key的值写法是和mybitas类同，#id则取的是方法参数的ID值作为缓存KEY
    public JSONObject test() {
        return orderServiceFeign.test();
    }
    public JSONObject testFallbackMethod(){
        Cache.ValueWrapper wrapper = cacheManager.getCache("orderCache").get("test");
        if(wrapper!=null){
            return (JSONObject)wrapper.get();
        }
        return new JSONObject();
    }
}
