package com.szcf.vue_server.exception;

/**
 * @author lp
 * @Description: 自定义 异常 基础接口类
 * @create 2020/10/20 15:42
 */
public interface BaseExceptionInfo {

    /*
    *  错误码
    * */
     String getResultCode();

    /*
    * 错误描述
    * */
    String getResultMsg();


}
