package cn.zcclj.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 〈自定义轮询方法
 *      每个服务轮询五次
 * 〉
 *
 * @author 22902
 * @create 2019/1/9
 */
public class RoundRobinRule_zc extends AbstractLoadBalancerRule {

    /**
     * 总共被调用的次数，要求5次
     */
    private int total = 0;
    /**
     * 当前服务下标
     */
    private int currentIndex = 0;

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            //获得可访问的服务器
            List<Server> upList = lb.getReachableServers();
            //获得所有的服务器
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }
            // 限制每个服务调用5次后轮询
            if (total < 5){
                server = upList.get(currentIndex);
                total ++;
            }else {
                total = 0;
                currentIndex ++;
                if (currentIndex >= upList.size()){
                    currentIndex = 0;
                }
            }


            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }


    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }

}
