package com.szcf.vue_server.common;

import java.io.Serializable;

/**
 * @author lp
 * @Description:  基本实体  共有属性
 * @create 2020/10/22 16:55
 */
public class BaseBean implements Serializable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
