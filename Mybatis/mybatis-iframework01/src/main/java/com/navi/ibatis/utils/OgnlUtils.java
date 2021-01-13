package com.navi.ibatis.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import jdk.nashorn.internal.runtime.regexp.JdkRegExp;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import ognl.Ognl;
import ognl.OgnlContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OgnlUtils {
	/**
	 * 根据Ongl表达式，获取指定对象的参数值
	 * @param expression
	 * @param paramObject
	 * @return
	 */
	public static Object getValue(String expression, Object paramObject) {
		try {
			OgnlContext context = new OgnlContext();
			context.setRoot(paramObject);

			//mybatis中的动态标签使用的是ognl表达式
			//mybatis中的${}使用的是ognl表达式
			Object ognlExpression = Ognl.parseExpression(expression);// 构建Ognl表达式
			Object value = Ognl.getValue(ognlExpression, context, context.getRoot());// 解析表达式

			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<String> getKeywords(String p){
		List<String> result = new ArrayList<>();
		String reg = "(?<=(?<!\\\\)\\$\\{)(.*?)(?=(?<!\\\\)\\})";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher("${aaa}");
		while (matcher.find()){
			result.add(matcher.group());
		}
		return result;
	}
	public static String getKeyword(String p){
		List<String> keywords = getKeywords(p);
		return CollUtil.isNotEmpty(keywords) ? keywords.get(0) : "";
	}

	//
	public static void main(String[] args) {
		Map<String, Object> map  = new HashMap<>();
		map.put("aaa", "bbb");
		List<String> keywords = getKeywords("${aaa}");
		if(CollUtil.isNotEmpty(keywords)){
			String s = keywords.get(0);
			System.out.println(s);
			if(StrUtil.isNotBlank(s)) {
				Object value = getValue(s, map);
				System.out.println(value);
			}
		}

	}

	/**
	 * 通过Ognl表达式，去计算boolean类型的结果
	 * @param expression
	 * @param parameterObject
	 * @return
	 */
	public static boolean evaluateBoolean(String expression, Object parameterObject) {
		Object value = OgnlUtils.getValue(expression, parameterObject);
		if (value instanceof Boolean) {
			return (Boolean) value;
		}
		if (value instanceof Number) {
			return new BigDecimal(String.valueOf(value)).compareTo(BigDecimal.ZERO) != 0;
		}
		return value != null;
	}
}
