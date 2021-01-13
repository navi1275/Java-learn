package com.navi.web;

import com.navi.dto.Student;
import org.assertj.core.util.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoController Class
 *
 * @author ganxf
 * @date 2020/7/2
 */
@RestController
public class DemoController {

    @RequestMapping("hello")
    public Object hello(){
        Student student = Student.builder().name("xiaohong").age(16).build();
        return student;
    }

    @RequestMapping("list")
    public Object list(){

        Student student1 = Student.builder().name("xiaohong").age(16).build();
        Student student2 = Student.builder().name("xiaoli").age(16).build();
        Student student3 = Student.builder().name("xiaofei").age(16).build();
        return Lists.list(student1,student2,student3);
    }

    @RequestMapping("exception")
    public void exception(){
        throw new RuntimeException("exception");
    }

    @RequestMapping("student")
    public Object exception(@RequestBody Student student){
        return student;
    }

    @RequestMapping("re")
    public ResponseEntity responseEntity(){

        ResponseEntity<Student> responseEntity = new ResponseEntity<Student>(Student.builder().name("xiaofei").age(16).build(), HttpStatus.BAD_GATEWAY);
        return responseEntity;
    }
}
