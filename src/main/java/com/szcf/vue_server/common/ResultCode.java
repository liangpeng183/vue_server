package com.szcf.vue_server.common;

/**
 * @author lp
 * @Description:  返回封装 枚举类
 * @create 2020/10/22 16:59
 */
public enum ResultCode {

    SUCCESS("200","成功"),    // 成功
    FAILED("-1","失败"),     // 失败
    NOT_DATA("0","暂无数据"),

    NOT_FOUND("404","找不到相关资源"),
    PARAM_ISNUL("400","参数为空"),
    SERVE_ERR("500 ","服务器错误"),

    USER_NOT_EXIST("1","用户不存在"),
    USER_IS_EXIST("2","用户已存在"),
    ;

    private String code;
    private String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
