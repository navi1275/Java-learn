package com.navi.service.impl;

import com.navi.entity.Dept;
import com.navi.mapper.DeptMapper;
import com.navi.service.IDeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ganxf
 * @since 2018-12-06
 */
@Service
// public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {
public class DeptServiceImpl implements IDeptService{

    //@Autowired
    //private DeptMapper deptMapper;

    /**
     * oo
     * @param no
     * @return
     */
    public Dept selectById(Integer no){
        return null;
    }

}
