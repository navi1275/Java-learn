package com.navi.repository;

import com.navi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DeptRepository Class
 *
 * @author navi
 * @date 2019-04-12
 * @since 1.0.0
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
