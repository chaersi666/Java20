package com.turing.service;

import com.turing.entity.Menu;

import java.util.List;

public interface MenuService {
    /**
     * 查询菜单列表
     * @return
     */
    List<Menu> findMenu();
}
