package com.navi.proxy.multilevel.impl;


import com.navi.proxy.multilevel.service.BaseService;

/**
 * 蝉 Class
 * 实现基本行为接口
 *
 * @author Administrator
 * @date 2018-11-08
 * @since 1.0.0
 */
public class Cicadas implements BaseService {
    @Override
    public void eating() {
        System.out.println("我是小蝉，悠闲的吃着树叶");
    }
}
