package com.navi.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ResultSetHandler Class
 *
 * @author navi
 * @date 2018/11/12
 */
public class ResultSetHandler {

    //将查询的结果集，转换为对应的实体类对象
    public Object handler(ResultSet rs, String resultType) throws ClassNotFoundException, NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Class<?> aClass = Class.forName(resultType);
        Field[] declaredFields = aClass.getDeclaredFields();

        List result = new ArrayList();
        while (rs.next()) {
            Object o = aClass.newInstance();
            for (int i = 0; i < declaredFields.length; i++) {
                Field field = declaredFields[i];
                String fieldName = field.getName();
                Class<?> type = field.getType();
                Method method = aClass.getMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), type);
                method.invoke(o, rs.getObject(fieldName));

            }
            result.add(o);
        }

        return result;
    }
}
