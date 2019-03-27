package com.navi.mapper;

import com.navi.entity.Dept;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ganxf
 * @since 2018-12-06
 */
// public interface DeptMapper extends BaseMapper<Dept> {
public interface DeptMapper{

    Dept selectById(@Param("param") Map<String, Object> param);

    @Select("select * from dept where id = #{id}")
    Dept selectById1(Integer id);

    Dept selectByNo(@Param("param") Map<String, Object> param);



}
