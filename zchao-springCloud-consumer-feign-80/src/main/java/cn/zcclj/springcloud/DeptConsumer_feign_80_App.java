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
@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候加载自定义的ribbon配置类，使用自定义的负载均衡算法
@RibbonClient(name = "ZCHAO-SPRINGCLOUD-DEPT",configuration = MyselfRule.class)
@EnableFeignClients(basePackages = {"cn.zcclj.springcloud"})
//@ComponentScan("cn.zcclj.springcloud") //可以不用这个注解，因为会跟SpringBootApplication中重复，可以在DeptClientService类中加@Component
public class DeptConsumer_feign_80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_feign_80_App.class,args);
    }

}
