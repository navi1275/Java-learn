package com.navi.service.impl;

import com.navi.entity.Student;
import com.navi.repository.StudentRepository;
import com.navi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * StudentServiceImpl Class
 *
 * @author navi
 * @date 2019-04-12
 * @since 1.0.0
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public boolean saveStudent(Student dept) {
        Student obj = repository.save(dept);
        return obj != null;
    }

    @Override
    public boolean deleleStudentById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student dept) {
        Integer id = dept.getId();
        if (id == null) {
            return false;
        }
        if (repository.existsById(id)) {
            repository.save(dept);
            return true;
        }
        return false;
    }

    @Override
    public Student selectStudentById(Integer id) {
        if (repository.existsById(id)) {
            Student obj = repository.getOne(id);
            return obj;
        }
        return null;
    }

    @Override
    public List<Student> selectAllList() {
        return repository.findAll();

    }
}
