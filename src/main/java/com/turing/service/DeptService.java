package com.turing.service;

import com.turing.entity.Dept;
import com.turing.mapper.DeptMapper;

import java.util.List;

/**
 * 部门表的业务层CRUD接口。
 */
public interface DeptService {

    /**
     * 根据ID查询部门信息
     * @param id
     * @return
     */
    Dept findById(Integer id);

    /**
     * 添加
     */
    void add();

    /**
     * 删除
     */
    int delete(Integer id);

    /**
     * 查询所有部门
     * @return
     */
    List<Dept> findAll();
}
