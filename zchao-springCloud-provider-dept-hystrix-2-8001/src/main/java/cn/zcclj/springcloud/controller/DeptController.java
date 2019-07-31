package cn.zcclj.springcloud.controller;

import cn.zcclj.springcloud.entity.Dept;
import cn.zcclj.springcloud.service.DeptService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dept)表控制层
 *
 * @author zc
 * @since 2019-01-07 11:16:56
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    /**
     * 服务对象
     */
    @Resource
    private DeptService deptService;
    /**
     * 服务发现
     */
    @Resource
    private DiscoveryClient client;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)

    public Dept findById(@PathVariable("id") Long id){
        Dept dept = deptService.findById(id);
        if(null == dept){
            //自定义一个异常抛出，以便使用服务降级
            throw new RuntimeException("id为"+id+"没有对应信息");
        }
        return dept;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Dept> findAll(){
        return deptService.findAll();
    }

    /**
     * 服务发现
     * @return
     */
    @RequestMapping(value = "/dispatchclient",method = RequestMethod.GET)
    public Object dispatchclient(){
        //所有微服务
        List<String> services = client.getServices();
        System.out.println("所有微服务"+services);

        List<ServiceInstance> instances = client.getInstances("ZCHAO-SPRINGCLOUD-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println("ZCHAO-SPRINGCLOUD-DEPT   "+instance.getServiceId());
            System.out.println("ZCHAO-SPRINGCLOUD-DEPT   "+instance.getUri());
            System.out.println("ZCHAO-SPRINGCLOUD-DEPT   "+instance.getHost());
            System.out.println("ZCHAO-SPRINGCLOUD-DEPT   "+instance.getPort());
            System.out.println("ZCHAO-SPRINGCLOUD-DEPT   "+instance.getMetadata());
        }
        return this.client;

    }





}