package com.turing.mapper;

import com.turing.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from menu")
    List<Menu> findAll();
}
