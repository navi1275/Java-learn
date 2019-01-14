package com.navi.mvc.mapper;

import com.navi.mvc.entity.Dept;

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

    Dept selectByNo(Integer no);

}
