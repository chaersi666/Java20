package com.turing.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private  Integer id;
    @JsonProperty("text")
    private  String name;
    private  Integer pid;
    //子菜单
    private List<Menu> children;

    private Attributes attributes;
    //生成Json时，忽略该字段
    @JsonIgnore
    private String url;
    @JsonIgnore
    private String icon;

}
