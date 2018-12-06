package com.navi.mapper;

import com.navi.entity.Dept;
import com.baomidou.mybatisplus.mapper.BaseMapper;

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
