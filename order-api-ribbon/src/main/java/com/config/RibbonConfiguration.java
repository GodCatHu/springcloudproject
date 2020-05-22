package com.config;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huwei
 * @title: RibbonConfiguration
 * @projectName springcloudproject
 * @description: TODO
 * @date 2019/11/1110:43
 */
@Configuration
public class RibbonConfiguration {
    //负载均衡策略
    @Bean
    public IRule ribbonRule(){
//        return new AvailabilityFilteringRule();//过滤掉状态为失败的server，例如有一个server进入了故障模式，那么接下来的请求不会请求到这个server
//        return new BestAvailableRule();  //选择一个最小的并发请求的server
        return new WeightedResponseTimeRule();//根据响应时间分配一个weight，响应时间越长，weight越小，被选中的可能性越低。
//        return new RetryRule();//对选定的负载均衡策略机上重试机制。
//        return new RoundRobinRule();//轮询负载，就是每一个都请求一次(默认负载)
//          return new RandomRule();//对所有的server进行随机选择
//        return new ZoneAvoidanceRule();//复合判断server所在区域的性能和server的可用性选择server(即既要区域的性能高估计是响应时间短，且server也必须要要可以访问)
    }

}
