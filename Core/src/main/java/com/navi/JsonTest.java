package com.navi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

/**
 * JsonTest Class
 *
 * @author ganxf
 * @date 2019-12-31
 */
public class JsonTest {


    public static void main(String[] args) {
        JSONObject jsonObject = JSON.parseObject("{\"age.age\":23,\"weight\":165}");
        JSONPath.remove(jsonObject, "age.age");
        Object age = jsonObject.get("age.age");
        Object weight = jsonObject.get("weight");
        System.out.println(age);
        System.out.println(age.getClass());
        System.out.println(weight.getClass());

        System.out.println("...".replace(".", "\\\\."));
    }
}
