package com.navi.cunstomMybatis.test;

import com.navi.cunstomMybatis.bean.Dept;
import com.navi.cunstomMybatis.dao.DeptDao;
import com.navi.cunstomMybatis.util.DefaultSqlSession;

import java.util.List;

/**
 * TestMain01 Class
 *
 * @author ganxf
 * @date 2018/11/12
 */
public class TestMain01 {

    public static void main(String[] args) {
        DefaultSqlSession session = new DefaultSqlSession();

        DeptDao mapper = (DeptDao) session.getMapper(DeptDao.class);

        List<Dept> all = mapper.findAll();

        System.out.println(all);
    }
}
