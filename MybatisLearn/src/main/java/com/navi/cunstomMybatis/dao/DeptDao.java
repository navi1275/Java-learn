package com.navi.cunstomMybatis.dao;

import com.navi.cunstomMybatis.bean.Dept;

import java.util.List;

/**
 * DeptDao Class
 *
 * @author ganxf
 * @date 2018/11/12
 */
public interface DeptDao {

    public List<Dept> findAll();
}
