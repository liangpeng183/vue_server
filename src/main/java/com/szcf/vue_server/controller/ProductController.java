package com.szcf.vue_server.controller;

import com.szcf.vue_server.bean.Product;
import com.szcf.vue_server.constant.Const;
import com.szcf.vue_server.service.impl.ProductServiceImpl;
import com.szcf.vue_server.util.ChangeToJson;
import com.szcf.vue_server.util.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author lp
 * @Description: ${todo}
 * @create 2020/9/27 23:32
 */
@RestController
@RequestMapping("/pro")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    // 列表 初始化数据
    @RequestMapping("/getAll")
    public String getAllPro(){
        System.out.println("初始化数据");
        List<Product> productList = productService.getAllPro();
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
        return ChangeToJson.changeToJson(commonResult);
    }

    // 新增
    @RequestMapping("/add")
    public String addPro(@RequestBody Product product) { // RequestBody  接收对象
        System.out.println("新增商品：" + product.getgName());
        System.out.println("新增商品：" + product.getgCat());
        System.out.println("新增商品：" + product.getgNum());
        System.out.println("新增商品：" + product.getgPrice());
        String gId = UUID.randomUUID().toString().replace("-","").substring(0,6);
        Product pro = new Product();
        pro.setgId(gId);
        pro.setgName(product.getgName());
        pro.setgCat(product.getgCat());
        pro.setgNum(product.getgNum());
        pro.setgPrice(product.getgPrice());

        CommonResult commonResult = new CommonResult();
        commonResult.setData("");
        int n  = productService.addPro(pro);
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

    // 搜索  多条件判断（sql）   支持模糊查询
    @RequestMapping("/search")
    public String searchPro(String gName, String gCat){
        CommonResult commonResult = new CommonResult();
        // 根据输入条件 搜索情况  （sql 分析）
        List<Product> productList = productService.queryProByCondition(gName,gCat);
        if(productList.size() > 0) {
            commonResult.setData(productList);
            commonResult.setCode(Const.SUCCESS_CODE);
            commonResult.setMessage(Const.SUCCESS_MSG);
        }else {
            commonResult.setData("");
            commonResult.setCode(Const.FAIL_CODE);
            commonResult.setMessage(Const.FAIL_MSG);
        }
        return  ChangeToJson.changeToJson(commonResult);
    }

    // 删除
    @RequestMapping("/deleteById/{gId}")
    public String deleteById(@PathVariable("gId") String gId){
        System.out.println("根据id删除："+ gId);
        int n = productService.deleteById(gId);
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

    // 修改
    @RequestMapping("/updatePro")
    public String updateProduct(@RequestBody Product product){
        System.out.println("修改id："+ product.getgId());
        int n = productService.updatePro(product);
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