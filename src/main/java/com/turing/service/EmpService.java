package com.turing.service;

import com.turing.entity.EasyuiDatagrid;
import com.turing.entity.Emp;
import com.turing.entity.Emp2;

import java.util.List;

/**
 * 员工表业务层
 */
public interface EmpService {
    /**
     * 登录验证
     * @param emp
     * @return
     */
    Emp findEmp(Emp emp);

    /**
     * 配置多对一关联查询，查询所有员工
     * @return
     */
    List<Emp2> findAll();

    /**
     * 添加员工
     * @param emp
     * @return
     */
    int insertEmp(Emp emp);

    /**
     * 删除员工
     * @param id
     * @return
     */
    int deleteEmp(int id);

    /**
     * 更新员工
     * @param emp
     * @return
     */
    int updateEmp(Emp emp);

    /**
     * 分页查询
     * @param pageNow 当前页
     * @param pageSize 每页显示多少条
     * @return EasyUI数据表格所需的类型
     */
    EasyuiDatagrid findPage(Integer pageNow,Integer pageSize);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    //boolean deleteBatch(String[] ids);
}
