package cn.zcclj.springcloud.service;

import cn.zcclj.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 〈〉
 *
 * @author 22902
 * @create 2019/1/9
 */
@FeignClient(value = "ZCHAO-SPRINGCLOUD-DEPT")
@Component //放入容器 供zchao-springCloud-consumer-feign-80使用
public interface DeptClientService {


    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    Boolean addDept(Dept dept);
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    Dept findById(@PathVariable("id") Long id);
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    List<Dept> findAll();

    /**
     * 服务发现
     * @return
     */
    @RequestMapping(value = "/dept/dispatchclient",method = RequestMethod.GET)
    public Object dispatchclient();




}
