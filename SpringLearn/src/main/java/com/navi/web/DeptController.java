package com.navi.web;


import com.navi.entity.Dept;
import com.navi.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ganxf
 * @since 2018-12-06
 */
@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private IDeptService deptService;

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request){
        Dept dept = deptService.selectById(111);
        request.setAttribute("deptName", dept.getDname());
        return "hello";
    }

    @RequestMapping("/hello2")
    @ResponseBody
    public Object hello2(){
        return deptService.selectById(111);
    }

}
