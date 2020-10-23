package com.szcf.vue_server.controller;

import com.szcf.vue_server.bean.Product;
import com.szcf.vue_server.common.GlobalExceptionHandler;
import com.szcf.vue_server.exception.BizException;
import com.szcf.vue_server.service.impl.ProductServiceImpl;
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
    private ProductServiceImpl productService;   //注入 实现类  （一般注入接口吧？？ 可完善）

    // 列表 初始化数据
    @RequestMapping("/getAll")
    public String getAllPro(){
        return productService.getAllPro();
    }

    // 新增
    @RequestMapping("/add")
    public String addPro(@RequestBody Product product) { // RequestBody  接收对象
        System.out.println("新增商品：" + product.getgName());
        System.out.println("新增商品：" + product.getgCat());
        System.out.println("新增商品：" + product.getgNum());
        System.out.println("新增商品：" + product.getgPrice());
        return productService.addPro(product);
    }

    // 搜索  多条件判断（sql）   支持模糊查询
    @RequestMapping("/search")
    public String searchPro(String gName, String gCat,int currentPage,int pageSize){
        System.out.println("搜索条件："+ gName+"  ---  "+ gCat);
        return  productService.queryProByCondition(gName,gCat,currentPage,pageSize);
    }

    //  分页查询
    @RequestMapping("/getProByPage")
    public String getProByPage(int currentPage,int pageSize){
        System.out.println("当前页："+ currentPage);
        System.out.println("每页记录数："+ pageSize);
        return productService.getByPage(currentPage,pageSize);
    }

    // 删除
    @RequestMapping("/deleteById/{gId}")
    public String deleteById(@PathVariable("gId") String gId){
        System.out.println("根据id删除："+ gId);
        if(gId.equals("")){
            throw new BizException("-1","传入id为空！");
        }
        return productService.deleteById(gId);
    }

    // 修改
    @RequestMapping("/updatePro")
    public String updateProduct(@RequestBody Product product){
        System.out.println("修改id："+ product.getgId());
        return productService.updatePro(product);

    }


}
