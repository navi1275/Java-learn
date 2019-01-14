package com.navi;

import com.navi.entity.Dept;
import com.navi.mapper.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Test01 Class
 *
 * @author ganxiongfeng@foresee.com.cn
 * @date 2018-12-17
 * @since 1.0.0
 */

public class Test01 {

    @Test
    public void test() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession();

        Dept o = sqlSession.selectOne("DeptMapper.selectByNo", 111);
        System.out.println(o);

        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept o1 = mapper.selectById(111);
        System.out.println(o1);

    }

}
