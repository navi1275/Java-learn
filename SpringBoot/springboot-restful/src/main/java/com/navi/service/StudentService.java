package com.navi.service;

import com.navi.entity.Student;

import java.util.List;

/**
 * StudentService Class
 *
 * @author navi
 * @date 2019-04-12
 * @since 1.0.0
 */
public interface StudentService {

    boolean saveStudent(Student dept);

    boolean deleleStudentById(Integer id);

    boolean updateStudent(Student dept);

    Student selectStudentById(Integer id);

    List<Student> selectAllList();
}
