package com.szcf.vue_server.util;

import com.google.gson.Gson;

import java.util.List;

/**
 * @author lp
 * @Description: 返回 json 格式
 * @create 2020/10/9 17:38
 */
public class ChangeToJson {

    private  static Gson gson = new Gson();

    public static String changeToJson(CommonResult commonResult) {
        //System.out.println("json转换："+gson.toJson(commonResult));
        return gson.toJson(commonResult);
    }

  /*  public static String listToJson(List<T> list) {
        return gson.toJson(list);
    }*/

}
