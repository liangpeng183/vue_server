package com.szcf.vue_server.controller;


import com.google.gson.Gson;
import com.szcf.vue_server.bean.User;
import com.szcf.vue_server.util.ChangeToJson;
import com.szcf.vue_server.util.CommonResult;
import com.szcf.vue_server.util.RedisUtil;
import com.szcf.vue_server.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lp
 * @Description: ${todo}
 * @create 2020/8/7 16:43
 */
@RestController
public class UserController {

    @Resource
    private RedisUtil redisUtil;

    // @CrossOrigin(origins = "*") //  跨域  见config 跨域配置
    @RequestMapping("/login")
    public String login(@RequestBody User user) {   // RequestBody 整个对象  或 @RequestParam--》一个一个参数
        System.out.println("用  户： " + user.getUsername());
        System.out.println("密  码： " + user.getPassword());

        String key = "1";
        // redisUtil.set(key, user);
        String user_redis = (String) redisUtil.get(key);
        System.out.println("redis缓存：" + user_redis);

        if (user_redis == null) {
           return ChangeToJson.changeToJson(ResultUtil.fail());
        }
        System.out.println("hhhh******--" + ChangeToJson.changeToJson(ResultUtil.success(user)));
        return ChangeToJson.changeToJson(ResultUtil.success(user));
        //三目运算
        //return user_redis==null?ChangeToJson.changeToJson(ResultUtil.fail())
        // :ChangeToJson.changeToJson(ResultUtil.success(user));


    }

}
