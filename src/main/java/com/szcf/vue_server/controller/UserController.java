package com.szcf.vue_server.controller;


import com.google.gson.Gson;
import com.szcf.vue_server.bean.User;
import com.szcf.vue_server.util.ChangeToJson;
import com.szcf.vue_server.util.CommonResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author lp
 * @Description: ${todo}
 * @create 2020/8/7 16:43
 */
@RestController
public class UserController {



   // @CrossOrigin(origins = "*") //  跨域  见config 跨域配置
    @RequestMapping("/login")
    public String login(@RequestBody User user) {   // RequestBody 整个对象  或 @RequestParam--》一个一个参数
        System.out.println("用  户： " + user.getUsername());
        System.out.println("密  码： " + user.getPassword());
        CommonResult commonResult = new CommonResult();
        commonResult.setCode("200");
        commonResult.setMessage("成功！");
        commonResult.setData(user);
        return ChangeToJson.changeToJson(commonResult);
    }

}
