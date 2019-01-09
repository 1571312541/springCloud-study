package cn.zcclj.springcloud.controller;

import cn.zcclj.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 〈〉
 *
 * @author 22902
 * @create 2019/1/7
 */
@RestController
@RequestMapping(value = "/dept_consumer")
public class DeptController_consumer {

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    //ribbon和eureka整合后，直接通过微服务名称调用，不用关心地址和端口
    private static final String REST_URL_PREFIX = "http://ZCHAO-SPRINGCLOUD-DEPT";

    /**
     * 使用 使用restTemplate访问restful接口 (url, requestMap,ResponseBean.class)
     * 这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/add")
    public Boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/get/{id}")
    public Dept findDeptById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping(value = "/list")
    public List<Dept> findAll() {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }

    @RequestMapping(value = "/dispatchclient")
    public Object dispatchclient() {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/dispatchclient", Object.class);
    }

}
