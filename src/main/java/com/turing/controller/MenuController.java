package com.turing.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.turing.entity.Menu;
import com.turing.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 查询列表
     * @return
     */
    @RequestMapping("/")
    public List<Menu> findMenu(){
        return menuService.findMenu();
    }

    /**
     * 查询所有
     * @return
     */
//    @RequestMapping("/all")
//    public List<Menu> findAll(){
//        return menuService.findAll();
//    }
}
