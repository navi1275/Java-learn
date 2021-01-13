package com.navi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.navi.service.IDeptService;
import com.navi.entity.Dept;
import com.navi.mapper.DeptMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author navi
 * @since 2018-12-06
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean insertDept(Dept dept) {
        Integer count = baseMapper.insert(dept);
        System.out.println("插入 " + count + " 条记录");
        int i = 1 / 0;
        return retBool(count);
    }

}
