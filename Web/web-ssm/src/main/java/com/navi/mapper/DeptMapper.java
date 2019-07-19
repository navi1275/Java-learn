package com.navi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.navi.entity.Dept;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author navi
 * @since 2018-12-06
 */
public interface DeptMapper extends BaseMapper<Dept> {
// public interface DeptMapper{

    Dept selectByNo(Integer no);

}
