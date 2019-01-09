package cn.zcclj.springcloud.dao;

import cn.zcclj.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Dept)表数据库访问层
 *
 * @author zc
 * @since 2019-01-07 11:16:56
 */
@Mapper
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();


}