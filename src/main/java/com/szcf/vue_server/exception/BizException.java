package com.szcf.vue_server.exception;

/**
 * @author lp
 * @Description: 自定义异常类 用于处理我们发生的业务异常
 * @create 2020/10/20 15:59
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    // 构造函数
    public BizException() {
        super();  // 指向父类  （注意区别 this）
    }

    public BizException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(Throwable cause, String errorCode, String errorMsg) {
        super(cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(BaseExceptionInfo baseExceptionInfo){
        super(baseExceptionInfo.getResultCode());
        this.errorCode = baseExceptionInfo.getResultCode();
        this.errorMsg = baseExceptionInfo.getResultMsg();
    }
    public BizException(BaseExceptionInfo baseExceptionInfo,Throwable cause){
        super(baseExceptionInfo.getResultCode(),cause);
        this.errorCode = baseExceptionInfo.getResultCode();
        this.errorMsg = baseExceptionInfo.getResultMsg();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


}
