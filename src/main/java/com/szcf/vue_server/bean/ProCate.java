package com.szcf.vue_server.bean;

import com.szcf.vue_server.common.BaseBean;

import java.io.Serializable;

/**
 * @author lp
 * @Description:  商品类别表
 * @create 2020/9/27 21:39
 */
public class ProCate extends BaseBean implements Serializable {


    private String cName;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
