package com.feign.fallback;

import com.alibaba.fastjson.JSONObject;
import com.feign.OrderServiceFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * @author huwei
 * @title: OrderServiceFeignFallback
 * @projectName springcloudproject
 * @description: TODO
 * @date 2019/11/1215:39
 */
@Component
public class OrderServiceFeignFallback implements FallbackFactory<OrderServiceFeign> {
    @Autowired
    CacheManager cacheManager;
    public JSONObject testFallbackMethod(){
        Cache.ValueWrapper wrapper = cacheManager.getCache("orderCache").get("test");
        if(wrapper!=null){
            return (JSONObject)wrapper.get();
        }
        return new JSONObject();
    }
    class OrderServiceFeignImpl implements OrderServiceFeign{

        @Override
        public JSONObject test() {
            Cache.ValueWrapper wrapper = cacheManager.getCache("orderCache").get("test");
            if(wrapper!=null){
                return (JSONObject)wrapper.get();
            }
            return new JSONObject();
        }
    }
    @Override
    public OrderServiceFeign create(Throwable throwable) {
//        return new OrderServiceFeign() {
//            @Override
//            public JSONObject test() {
//                return null;
//            }
//
//        };
        return new OrderServiceFeignImpl();
    }
}
