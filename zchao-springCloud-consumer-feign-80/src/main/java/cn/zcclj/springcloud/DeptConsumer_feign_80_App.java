package cn.zcclj.springcloud;

import cn.zcclj.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 〈〉
 *
 * @author 22902
 * @create 2019/1/7
 */
@SpringBootApplication(scanBasePackages = {"cn.zcclj.springcloud"}) //主要扫描DeptClientService，feign接口
@EnableEurekaClient
//在启动该微服务的时候加载自定义的ribbon配置类，使用自定义的负载均衡算法
@RibbonClient(name = "ZCHAO-SPRINGCLOUD-DEPT",configuration = MyselfRule.class)
@EnableFeignClients(basePackages = {"cn.zcclj.springcloud"})
public class DeptConsumer_feign_80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_feign_80_App.class,args);
    }

}
