package cn.zcclj.springcloud.service;

import cn.zcclj.springcloud.entity.Dept;

import java.util.List;

/**
 * (Dept)表服务接口
 *
 * @author zc
 * @since 2019-01-07 11:16:56
 */
public interface DeptService {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}