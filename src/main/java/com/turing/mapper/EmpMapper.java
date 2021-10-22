package com.turing.mapper;

import com.turing.entity.Emp;
import com.turing.entity.Emp2;
import com.turing.entity.EmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EmpMapper {
    int countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(Integer empno);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    //查员工表
    List<Emp2> selectEmpAndDept();

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(1) from emp")
    int selectCount();

    /**
     * 分页查询
     * @param pageNow 当前页
     * @param pageSize 每页显示多少条
     * @return 分页后的员工列表
     */
    @Select("select * from emp limit #{pageNow},#{pageSize}")
    List<Emp> findPage(@Param("pageNow") Integer pageNow,@Param("pageSize") Integer pageSize);

    /**
     * 批量删除
     * @param ids 编号数组
     * @return 删除结果
     */
   //boolean deleteBatch(@Param("ids") String[] ids);
}