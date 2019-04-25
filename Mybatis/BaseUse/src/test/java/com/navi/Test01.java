package com.navi;

import com.navi.entity.Dept;
import com.navi.mapper.DeptMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Test01 Class
 *
 * @author navi
 * @date 2018-12-17
 * @since 1.0.0
 */
@Slf4j
public class Test01 {

    @Test
    public void test() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession sqlSession = factory.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", "");
        mapper.selectByNo(map1);

        Map<String, Object> map = new HashMap<>();
        map.put("id", 0);
        Dept o1 = mapper.selectById(map);
        // System.out.println(o1);

    }

}
