package com.szcf.vue_server.util;

import com.szcf.vue_server.common.ResultCode;

/**
 * @author lp
 * @Description:   返回结果 工具类
 * @create 2020/10/23 10:09
 */
public class ResultUtil {

    /*
    *   成功 且 带数据
    * */
    public static CommonResult success(Object object){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(ResultCode.SUCCESS.getCode());
        commonResult.setMessage(ResultCode.SUCCESS.getMsg());
        commonResult.setData(object);
        return commonResult;
    }

    /*
    *  成功 不带 数据
    * */
    public static CommonResult success(){
        return success(null);
    }

    /*
    *  带有分页  总数
    * */
    public static  CommonResult success(Object object,int count){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(ResultCode.SUCCESS.getCode());
        commonResult.setMessage(ResultCode.SUCCESS.getMsg());
        commonResult.setData(object);
        commonResult.setTotal(count);
        return commonResult;
    }

    /*
    *  失败
    * */
    public static CommonResult fail(){
        CommonResult commonResult = new CommonResult();
        commonResult.setMessage(ResultCode.FAILED.getMsg());
        commonResult.setCode(ResultCode.FAILED.getCode());
        return commonResult;
    }

    /*
    *  空数据
    * */
    public static CommonResult dataNull(){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(ResultCode.NOT_DATA.getCode());
        commonResult.setMessage(ResultCode.NOT_DATA.getMsg());
        commonResult.setData("");
        return commonResult;
    }

}
