package com.turing.service.impl;

import com.turing.entity.Dept;
import com.turing.mapper.DeptMapper;
import com.turing.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门表CRUD实现类
 */
@Service
public class DeptServiceImpl implements DeptService {

    //依赖DAO层
    //Spring的注解
    @Autowired(required = false)
    private DeptMapper deptMapper;

    /**
     * 通过id查询信息实现
     * @param id
     * @return
     */
    @Override
    public Dept findById(Integer id) {
        return deptMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加
     */
    @Override
    public void add() {
        Dept dept = new Dept();
        dept.setDname("售后部");
        dept.setLoc("郴州");
        deptMapper.insert(dept);
    }

    /**
     * 根据ID删除部门
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return deptMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询所有部门实现类
     * @return
     */
    @Override
    public List<Dept> findAll() {
        return deptMapper.selectByExample(null);
    }

}
