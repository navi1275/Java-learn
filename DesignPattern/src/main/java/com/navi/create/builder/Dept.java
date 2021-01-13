package com.navi.create.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Dept Class
 *
 * @author ganxf
 * @date 2019-11-18
 */
@Data
@AllArgsConstructor
public class Dept {

    private String name;
    private String deptNo;
    private String location;



    public static void main(String[] args) {
        Dept dept = Dept.builder().deptNo("111").name("dev").location("123").build();
        System.out.println(dept);

        Student student = Student.builder().name("zhangsan").age(12).gender("man").like("ball").build();
        System.out.println(student);
    }

    public static DeptBuilder builder(){
        return new DeptBuilder();
    }


    public static class DeptBuilder{

        private String name;
        private String deptNo;
        private String location;


        public DeptBuilder name(String name){
            this.name=name;
            return this;
        }

        public DeptBuilder deptNo(String deptNo){
            this.deptNo=deptNo;
            return this;
        }

        public DeptBuilder location(String location){
            this.location=location;
            return this;
        }

        public Dept build(){
            return new Dept(name, deptNo, location);
        }

    }

}

