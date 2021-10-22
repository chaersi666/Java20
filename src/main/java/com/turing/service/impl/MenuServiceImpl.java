package com.turing.service.impl;

import com.turing.entity.Attributes;
import com.turing.entity.Menu;
import com.turing.mapper.MenuMapper;
import com.turing.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<Menu> findMenu() {
        //获取所有菜单
        List<Menu> Menus = menuMapper.findAll();
        return findFatherMenu(Menus);
    }

    /**
     * 查询一级菜单
     * @param menus
     * @return
     */
    private List<Menu> findFatherMenu(List<Menu> menus) {
        //创建一个父菜单
        List<Menu>fatherMenus = new ArrayList<>();
        //遍历所有集合
        menus.forEach(menu -> {
            //判断Pid是否为0？
            if (menu.getPid()==0){
                //给父菜单设置子菜单
                menu.setChildren(findChildrenMenu(menu.getId(),menus));
                //添加到父菜单中
                fatherMenus.add(menu);
            }
        });
        return fatherMenus;
    }

    /**
     * 查询子菜单
     * @param id
     * @param menus
     * @return
     */
    private List<Menu> findChildrenMenu(Integer id, List<Menu> menus) {
        //创建一个子菜单集合
        List<Menu> childrenMenus = new ArrayList<>();
        //遍历所有菜单
        menus.forEach(menu -> {
            //根据id来判断是否是子菜单
            if(menu.getPid()==id){
                //创建属性对象
                Attributes att=new Attributes();
                att.setUrl(menu.getUrl());
                att.setIcon(menu.getIcon());
                menu.setAttributes(att);

                //给子菜单设置子菜单【递归】
                menu.setChildren(findChildrenMenu(menu.getId(),menus));
                //添加到子菜单列表中
                childrenMenus.add(menu);
            }
        });
        return childrenMenus;
    }


}

