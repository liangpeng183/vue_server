package com.szcf.vue_server.bean;

import com.szcf.vue_server.common.BaseBean;

import java.io.Serializable;

/**
 * @author lp
 * @Description: 用户表
 * @create 2020/8/7 17:17
 */
public class User extends BaseBean implements Serializable {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
