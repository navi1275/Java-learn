package com.navi.provider.service.impl;

import com.navi.provider.entity.Dept;
import com.navi.provider.repository.DeptRepository;
import com.navi.provider.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DeptServiceImpl Class
 *
 * @author navi
 * @date 2019-04-12
 * @since 1.0.0
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository repository;

    @Value("${server.port}")
    private String port;

    @Override
    public boolean saveDept(Dept dept) {
        Dept obj = repository.save(dept);
        return obj != null;
    }

    @Override
    public boolean deleleDeptById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateDept(Dept dept) {
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
    public Dept selectDeptById(Integer id) {
        if (repository.existsById(id)) {
            Dept obj = repository.getOne(id);
            obj.setDeptName(obj.getDeptName() + port);
            return obj;
        }
        return null;
    }

    @Override
    public List<Dept> selectAllList() {
        return repository.findAll();

    }
}
