package com.navi.service;

import com.navi.entity.Dept;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ganxf
 * @since 2018-12-06
 */
// public interface IDeptService extends IService<Dept> {
public interface IDeptService{

    Dept selectById(Integer no);

}
