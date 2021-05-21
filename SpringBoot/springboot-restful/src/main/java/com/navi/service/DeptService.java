package com.navi.service;

import com.navi.entity.Dept;

import java.util.List;

/**
 * DeptService Class
 *
 * @author navi
 * @date 2019-04-12
 * @since 1.0.0
 */
public interface DeptService {

    boolean saveDept(Dept dept);

    boolean deleleDeptById(Integer id);

    boolean updateDept(Dept dept);

    Dept selectDeptById(Integer id);

    List<Dept> selectAllList();
}
