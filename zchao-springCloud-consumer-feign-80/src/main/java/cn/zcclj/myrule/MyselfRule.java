package cn.zcclj.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈自定义算法〉
 *
 * @author 22902
 * @create 2019/1/9
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule() {
        return new RoundRobinRule_zc();
    }

}
