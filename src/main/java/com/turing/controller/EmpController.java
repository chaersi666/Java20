package com.turing.controller;

import com.turing.entity.EasyuiDatagrid;
import com.turing.entity.Emp;
import com.turing.entity.Emp2;
import com.turing.service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * 员工表控制器
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    //依赖service层
    @Autowired
    private EmpService empService;

//    //跳转主页
//    @RequestMapping("/index")
//    public String index(){
//        return "index";
//    }

//    //跳转登陆静态页面
//    @RequestMapping("/")
//    public String login(){
//        return "login";
//    }

    /**
     * 登陆验证
     * @param emp
     * @param session
     * @return
     */
    @RequestMapping("/checkLogin")
    public String checkLogin(Emp emp, HttpSession session){
        emp = empService.findEmp(emp);
         if(emp == null){
            //登录失败，
            return "login";
        }else{
            //登录成功，进入主页
            //把用户保存到session
            session.setAttribute("emp", emp);
            return "redirect:/emp/index";//跳转控制器
        }
    }

    /**
     * 查询所有员工
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String index(Model model){
        List<Emp2> list = empService.findAll();
        //绑定数据
        model.addAttribute("list", list);
        //跳转视图
        return "index";
    }

    /**
     * 添加员工
     * @param emp
     * @return
     */
    @PostMapping("/insert")
    @ResponseBody
    public String insert(Emp emp){
        return empService.insertEmp(emp)>0?"success":"erro";
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        return empService.deleteEmp(id)>0?"success":"erro";
    }

    //批量删除员工
//    @GetMapping("/deletes")
//    @ResponseBody
//    public String deleteBatch(String[] ids){
//        return empService.deleteBatch(ids)?"success":"error";
//    }

    /**
     * 修改员工
     * @param emp
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public String update(Emp emp){
        return empService.updateEmp(emp)>0?"success":"erro";
    }

    /**
     * 异步登录，返回json
     * @param emp
     * @param session
     * @return
     */
    @RequestMapping("/checkLogin2")
    @ResponseBody
    public String checkLogin2(Emp emp ,HttpSession session){
        emp=empService.findEmp(emp);
        if(emp == null){
            //登陆失败
            return "登陆失败。";
        }else {
            //成功，保存到session，进入主页
            session.setAttribute("emp",emp);
            return "登录成功！";
        }
    }

    /**
     * 分页查询，
     * @param pageNow 当前页
     * @param pageSize 每页显示多少条
     * @return EasyUI数据表格所需格式
     */
    @PostMapping("/page")
    @ResponseBody
    public EasyuiDatagrid selectPage(@RequestParam(defaultValue = "1",name = "page") Integer pageNow, @RequestParam(defaultValue = "5",name = "rows") Integer pageSize){
        return empService.findPage(pageNow, pageSize);
    }
}
