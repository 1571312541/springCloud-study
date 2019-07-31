package cn.zcclj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 〈〉
 *
 * @author 22902
 * @create 2019/1/7
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_hystrix_dashboard_9001_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_hystrix_dashboard_9001_App.class,args);
    }

}
