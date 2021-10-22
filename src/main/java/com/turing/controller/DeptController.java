package com.turing.controller;

import com.turing.entity.Dept;
import com.turing.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部门表操作控制器
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    //依赖业务层
    @Autowired
    private DeptService deptService;

    /**
     * 根据ID查询部门控制器
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Dept findById(@PathVariable("id")Integer id){
        return deptService.findById(id);
    }

    /**
     *增加部门控制器
     * @return
     */
    @GetMapping("/add")
    public String add(){
        deptService.add();
        return null;
    }

    /**
     * 通过id删除部门
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public int delete(@PathVariable("id")Integer id){
        deptService.delete(id);
        return 0;
    }

    /**
     * 查询所有部门
     * @return
     */
    @GetMapping("/")
    public List<Dept> findAll(){
        return deptService.findAll();
    }
}
