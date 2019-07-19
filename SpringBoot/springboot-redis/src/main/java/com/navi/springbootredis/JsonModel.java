package com.navi.springbootredis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonModel extends JSONObject {

    private static final long serialVersionUID = 8360690361547207994L;

    /**
     * 成功
      */
    public static final int CODE_SUCCESS = 0;
    /**
     * 系统内部错误
     */
    public static final int CODE_SYS_ERROR = 1;

    /**
     * 验证失败
     */
    public static final int CODE_VALID_ERROR = 2;
    /**
     * 业务相关错误
     */
    public static final int CODE_SERVICE_ERROR = 3;


    /**
     * 鉴权失败:未登录
     */
    public static final int CODE_AUTHENTICATION_ERROR = 4;


    /**
     * 没权限
     */
    public static final int CODE_UNAUTHORIZED_ERROR = 5;


    public JsonModel(int code) {
        super();
        this.setCode(code);
    }

    public JsonModel() {
        this(CODE_SUCCESS);
    }

    public JsonModel(int code, Object msg) {
        super();
        this.setCode(code);
        this.setMsg(msg);
    }

    public JsonModel(Object data) {
        super();
        this.setCode(CODE_SUCCESS);
        this.setData(data);
    }


    public static JsonModel success() {
        return new JsonModel(CODE_SUCCESS);
    }

    public static JsonModel success(Object obj) {
        return new JsonModel(obj);
    }

    public static JsonModel fail(String msg) {
        return new JsonModel(CODE_SERVICE_ERROR, msg);
    }

    public static JsonModel fail(int code, Object msg) {
        return new JsonModel(code, msg);
    }

    public static JsonModel validFail() {
        return new JsonModel(CODE_VALID_ERROR, null);
    }

    public static JsonModel validFail(String msg) {
        return new JsonModel(CODE_VALID_ERROR, msg);
    }

    public static JsonModel serviceFail(String msg) {
        return new JsonModel(CODE_SERVICE_ERROR, msg);
    }

    public static JsonModel authenticationFail(String msg) {
        return new JsonModel(CODE_AUTHENTICATION_ERROR, msg);
    }

    public static JsonModel unauthorizedFail(String msg) {
        return new JsonModel(CODE_UNAUTHORIZED_ERROR, msg);
    }


    public static JsonModel sysFail(String msg) {
        return new JsonModel(CODE_SYS_ERROR, msg);
    }



    public static JsonModel init(boolean bol) {
        return bol ? JsonModel.success() : JsonModel.fail("操作失败");
    }

    public int getCode() {
        return getIntValue("code");
    }

    public void setCode(int code) {
        this.put("code", code);
        this.put("success", code == CODE_SUCCESS);
    }

    public String getMsg() {
        return getString("msg");
    }

    public void setMsg(Object msg) {
        this.put("msg", msg);
    }

    public <T> T getData() {
        return (T) get("data");
    }

    public void setData(Object data) {
        this.put("data", data);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}