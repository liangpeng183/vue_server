package com.szcf.vue_server.service.impl;

import com.szcf.vue_server.bean.Product;
import com.szcf.vue_server.constant.Const;
import com.szcf.vue_server.mapper.ProductMapper;
import com.szcf.vue_server.service.IProductService;
import com.szcf.vue_server.util.ChangeToJson;
import com.szcf.vue_server.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author lp
 * @Description: ${todo}
 * @create 2020/10/9 16:35
 */
@Service
public class ProductServiceImpl implements IProductService  {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public String addPro(Product product) {
        String gId = UUID.randomUUID().toString().replace("-","").substring(0,6);
        Product pro = new Product();
        pro.setgId(gId);
        pro.setgName(product.getgName());
        pro.setgCat(product.getgCat());
        pro.setgNum(product.getgNum());
        pro.setgPrice(product.getgPrice());
        CommonResult commonResult = new CommonResult();
        commonResult.setData("");
        int n  = productMapper.addPro(pro);
        System.out.println("新增结果："+ n);
        if(n > 0){
            commonResult.setMessage("增加成功！");
            commonResult.setCode(Const.SUCCESS_CODE);
        }else {
            commonResult.setMessage("增加失败！");
            commonResult.setCode(Const.FAIL_CODE);
        }
        return ChangeToJson.changeToJson(commonResult);
    }

    @Override
    public String getAllPro() {
        System.out.println("初始化数据");
        List<Product> productList = productMapper.getAllPro();
        CommonResult commonResult = new CommonResult();
        if(productList.size() > 0){
            commonResult.setCode(Const.SUCCESS_CODE);
            commonResult.setData(productList);
            commonResult.setMessage("查询"+Const.SUCCESS_MSG);
        }
        else{
            commonResult.setCode(Const.FAIL_CODE);
            commonResult.setData("");
            commonResult.setMessage("查询"+Const.FAIL_MSG);
        }
         return  ChangeToJson.changeToJson(commonResult);
    }

    @Override
    public String deleteById(String gId) {
        int n = productMapper.deleteById(gId);
        CommonResult commonResult = new CommonResult();
        if(n > 0){
            commonResult.setCode(Const.SUCCESS_CODE);
            commonResult.setData(n);
            commonResult.setMessage("删除"+Const.SUCCESS_MSG);
        }else {
            commonResult.setCode(Const.FAIL_CODE);
            commonResult.setData(n);
            commonResult.setMessage("删除"+Const.FAIL_MSG);
        }
        return ChangeToJson.changeToJson(commonResult);
    }

    @Override
    public String queryProByCondition(String gName, String gCat) {
        CommonResult commonResult = new CommonResult();
        // 根据输入条件 搜索情况  （sql 分析）
        List<Product> productList = productMapper.queryProByCondition(gName,gCat);
        if(productList.size() > 0) {
            commonResult.setData(productList);
            commonResult.setCode(Const.SUCCESS_CODE);
            commonResult.setMessage(Const.SUCCESS_MSG);
        }else {
            commonResult.setData("");
            commonResult.setCode(Const.FAIL_CODE);
            commonResult.setMessage(Const.FAIL_MSG);
        }
        return ChangeToJson.changeToJson(commonResult);
    }

    @Override
    public String updatePro(Product product) {
        int n = productMapper.updatePro(product);
        CommonResult com = new CommonResult();
        if(n > 0){
            com.setCode(Const.SUCCESS_CODE);
            com.setMessage(Const.SUCCESS_MSG);
            com.setData(product);
        }else{
            com.setCode(Const.FAIL_CODE);
            com.setMessage(Const.FAIL_MSG);
            com.setData("");
        }
        return ChangeToJson.changeToJson(com);
    }
}
