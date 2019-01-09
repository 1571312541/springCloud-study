package cn.zcclj.springcloud.controller;

import cn.zcclj.springcloud.entity.Dept;
import cn.zcclj.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "/add")
    public Boolean add(Dept dept) {
        return deptClientService.addDept(dept);
    }

    @RequestMapping(value = "/get/{id}")
    public Dept findDeptById(@PathVariable("id") Long id) {
        return deptClientService.findById(id);
    }

    @RequestMapping(value = "/list")
    public List<Dept> findAll() {
        return deptClientService.findAll();
    }

    @RequestMapping(value = "/dispatchclient")
    public Object dispatchclient() {
        return deptClientService.dispatchclient();
    }

}
