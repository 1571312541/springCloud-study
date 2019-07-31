package cn.zcclj.springcloud.service.impl;

import cn.zcclj.springcloud.dao.DeptDao;
import cn.zcclj.springcloud.entity.Dept;
import cn.zcclj.springcloud.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dept)表服务实现类
 *
 * @author zc
 * @since 2019-01-07 11:16:56
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept findById(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}