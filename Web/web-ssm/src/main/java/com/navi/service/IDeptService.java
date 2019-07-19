package com.navi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.navi.entity.Dept;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author navi
 * @since 2018-12-06
 */
public interface IDeptService extends IService<Dept> {

    boolean insertDept(Dept dept);

}
