package com.navi;

/**
 * TestSpring Class
 *
 * @author ganxiongfeng@foresee.com.cn
 * @date 2018-12-06
 * @since 1.0.0
 */

import com.navi.entity.Dept;
import com.navi.mapper.DeptMapper;
import com.navi.service.IDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/*.xml")
public class TestSpring {

    @Resource
    private IDeptService deptService;

    @Test
    public void test1(){

        Dept dept = deptService.selectById(111);
        System.out.println(dept);
    }
}
