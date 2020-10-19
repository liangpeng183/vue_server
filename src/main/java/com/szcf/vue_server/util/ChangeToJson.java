package com.szcf.vue_server.util;

import com.google.gson.Gson;

import java.util.List;

/**
 * @author lp
 * @Description:  json 格式转换
 * @create 2020/10/9 17:38
 */
public class ChangeToJson {

    public static String changeToJson(CommonResult commonResult){
       Gson gson = new Gson();
       System.out.println("json转换："+gson.toJson(commonResult));
       return gson.toJson(commonResult);
    }

}
