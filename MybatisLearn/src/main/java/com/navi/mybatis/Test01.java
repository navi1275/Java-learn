package com.navi.mybatis;

import com.navi.mvc.entity.Dept;
import com.navi.mvc.mapper.DeptMapper;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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

    public static void main1(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession();

        Dept o = sqlSession.selectOne("com.navi.mvc.mapper.DeptMapper.selectByNo", 111);
        System.out.println(o);

        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept o1 = mapper.selectById(111);
        System.out.println(o1);


    }


    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("Kobe");
        Person p2 = new Person();
        p2.setName("Lebron");
        changePerson(p1, p2);
        System.out.println(p1.getName());
        System.out.println(p2.getName());
    }

    public static void changePerson(Person p3,Person p4) {
        p3 = p4;
        p4 = p3;
        p3.setName("Wade");
    }
}
