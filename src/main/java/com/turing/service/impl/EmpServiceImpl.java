package com.turing.service.impl;

import com.turing.entity.EasyuiDatagrid;
import com.turing.entity.Emp;
import com.turing.entity.Emp2;
import com.turing.entity.EmpExample;
import com.turing.mapper.EmpMapper;
import com.turing.service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {

    //依赖DAO层
    @Autowired
    private EmpMapper empMapper;

    /**
     * 登录验证实现类
     * @param emp
     * @return
     */
    @Override
    public Emp findEmp(Emp emp) {
        EmpExample example = new EmpExample();
        example.createCriteria().andEnameEqualTo(emp.getEname()).andEmpnoEqualTo(emp.getEmpno());
        //查询所有
        List<Emp> emps = empMapper.selectByExample(example);
        if(emps!=null&&emps.size()>0){
            return emps.get(0);
        }
        return null;
    }

    /**
     * 联合查询
     * @return
     */
    @Override
    public List<Emp2> findAll() {
        return empMapper.selectEmpAndDept();
    }

    /**
     * 添加员工
     * @param emp
     * @return
     */
    @Override
    public int insertEmp(Emp emp) {
        return empMapper.insert(emp);
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @Override
    public int deleteEmp(int id) {
        return empMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新方法
     * @param emp
     * @return
     */
    @Override
    public int updateEmp(Emp emp) {
        return empMapper.updateByPrimaryKeySelective(emp);
    }

    @Override
    public EasyuiDatagrid findPage(Integer pageNow, Integer pageSize) {
        //创建EasyuiDatagrid对象
        EasyuiDatagrid datagrid = new EasyuiDatagrid();
        //设置总记录数
        datagrid.setTotal(empMapper.selectCount()+"");
        //设置对象列表
        datagrid.setRows(empMapper.findPage((pageNow-1)*pageSize, pageSize));
        return datagrid;
    }

//    @Override
//    public boolean deleteBatch(String[] ids) {
//        return empMapper.deleteBatch(ids);
//    }


}
