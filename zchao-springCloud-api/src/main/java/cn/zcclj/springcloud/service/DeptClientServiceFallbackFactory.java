package cn.zcclj.springcloud.service;

import cn.zcclj.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈〉
 *
 * @author 22902
 * @create 2019/1/9
 */
@Component  //放入容器
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Boolean addDept(Dept dept) {
                return null;
            }

            @Override
            public Dept findById(Long id) {
                return new Dept(id,"findById——fallback，服务器已经挂了，但是做了服务降级处理，客户端在服务器不可用时不会消耗服务端","no data");
            }

            @Override
            public List<Dept> findAll() {
                return null;
            }

            @Override
            public Object dispatchclient() {
                return null;
            }
        };
    }
}
