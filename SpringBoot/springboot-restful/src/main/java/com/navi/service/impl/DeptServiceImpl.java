package com.navi.service.impl;

import com.navi.entity.Dept;
import com.navi.repository.DeptRepository;
import com.navi.repository.StudentRepository;
import com.navi.service.DeptService;
import com.navi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private StudentService studentService;

    @Override
    public boolean saveDept(Dept dept) {
        Dept obj = repository.save(dept);
        return obj != null;
    }

    /*
    cglib生产的代理对象会加入methodinterceptor拦截
    public final boolean deleleDeptById(Integer n) {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            DeptServiceImpl$$EnhancerBySpringCGLIB$$c13c256d.CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor != null) {
            Object object = methodInterceptor.intercept(this, CGLIB$deleleDeptById$1$Method, new Object[]{n}, CGLIB$deleleDeptById$1$Proxy);
            return object == null ? false : (Boolean)object;
        }
        return super.deleleDeptById(n);
    }
     */
    @Transactional
    @Override
    public boolean deleleDeptById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            int i = 1 / 0;
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
            return obj;
        }
        return null;
    }

    @Override
    public List<Dept> selectAllList() {
        return repository.findAll();

    }

}
