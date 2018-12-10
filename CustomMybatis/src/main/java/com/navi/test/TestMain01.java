package com.navi.test;

import com.navi.bean.Dept;
import com.navi.dao.DeptDao;
import com.navi.util.DefaultSqlSession;

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
