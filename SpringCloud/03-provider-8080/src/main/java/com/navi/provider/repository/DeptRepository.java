package com.navi.provider.repository;

import com.navi.provider.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DeptRepository Class
 *
 * @author navi
 * @date 2019-04-12
 * @since 1.0.0
 */
public interface DeptRepository extends JpaRepository<Dept, Integer> {
}
