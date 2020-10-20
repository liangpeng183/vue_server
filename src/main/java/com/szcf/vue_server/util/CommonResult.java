package com.szcf.vue_server.util;

import java.io.Serializable;

/**
 * @author lp
 * @Description: ${todo}
 * @create 2020/8/7 17:22
 */
public class CommonResult<T> implements Serializable {

    private String code;   // 状态码
    private String message;  // msg  消息
    private T data;   // 数据

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private int total;   //总记录数

    public CommonResult() {
    }

    public CommonResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
