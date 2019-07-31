package cn.zcclj.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 〈〉
 *
 * @author 22902
 * @create 2019/1/7
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //springcloud ribbon是基于netflix ribbon 实现的一套客户端 负载均衡的机器
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 以随机模式代替默认的轮询模式
     * 当在启动类中加入@RibbonClient(name = "ZCHAO-SPRINGCLOUD-DEPT",configuration = MyselfRule.class)时，
     * 将不使用该模式，会使用自定义的算法
     * @return IRule
     */
    @Bean
    public IRule myRule() {
//        return new RandomRule(); //随机
        return new RetryRule();
    }


}
