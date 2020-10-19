package com.szcf.vue_server.bean;

import java.io.Serializable;

/**
 * @author lp
 * @Description:  商品表
 * @create 2020/9/27 19:10
 */
public class Product implements Serializable  {

    private String gId;   // id
    private String gName;    // 名称
    private String gCat;    // 类别
    private int gNum;     // 数量    (int 基本数据类型  )
    private double gPrice;   // 价格

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgCat() {
        return gCat;
    }

    public void setgCat(String gCat) {
        this.gCat = gCat;
    }

    public int getgNum() {
        return gNum;
    }

    public void setgNum(int gNum) {
        this.gNum = gNum;
    }

    public double getgPrice() {
        return gPrice;
    }

    public void setgPrice(double gPrice) {
        this.gPrice = gPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "gId='" + gId + '\'' +
                ", gName='" + gName + '\'' +
                ", gCat='" + gCat + '\'' +
                ", gNum='" + gNum + '\'' +
                ", gPrice='" + gPrice + '\'' +
                '}';
    }
}
