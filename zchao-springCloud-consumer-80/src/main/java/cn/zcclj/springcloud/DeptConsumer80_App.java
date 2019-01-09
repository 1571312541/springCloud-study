package cn.zcclj.springcloud;

import cn.zcclj.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 〈〉
 *
 * @author 22902
 * @create 2019/1/7
 */
@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候加载自定义的ribbon配置类，使用自定义的负载均衡算法
@RibbonClient(name = "ZCHAO-SPRINGCLOUD-DEPT",configuration = MyselfRule.class)
public class DeptConsumer80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class,args);
    }

}
