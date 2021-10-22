package com.turing.entity;

import lombok.Data;

import java.util.List;

/**
 * 专门为EasyUI数据表格所需格式封装的一个实体类
 */
@Data
public class EasyuiDatagrid {
    private String total;//总记录数
    private List<Emp> rows;//行记录对象
}
