package com.navi;

/**
 * TestSpring Class
 *
 * @author navi
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

    @Resource
    private DeptMapper deptMapper;

    @Test
    public void test3(){
        Dept dept = new Dept();
        dept.setId(100111);
        dept.setDeptNo("dept01111");
        dept.setDeptName("商务部111");
        dept.setLocation("广州市黄埔区");
        boolean save = deptService.insertDept(dept);
        System.out.println(save);
    }

    @Test
    public void test1(){

        Dept dept = deptService.getById(100);
        System.out.println(dept);
    }

    @Test
    public void test2(){
        Dept dept = deptMapper.selectByNo(2);
        System.out.println(dept);
    }
}
