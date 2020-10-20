package com.szcf.vue_server.service.impl;

import com.szcf.vue_server.bean.Product;
import com.szcf.vue_server.constant.Const;
import com.szcf.vue_server.mapper.ProductMapper;
import com.szcf.vue_server.service.IProductService;
import com.szcf.vue_server.util.ChangeToJson;
import com.szcf.vue_server.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author lp
 * @Description: ${todo}
 * @create 2020/10/9 16:35
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    //  新增商品
    @Override
    public String addPro(Product product) {
        String gId = UUID.randomUUID().toString().replace("-", "").substring(0, 6);
        Product pro = new Product();
        pro.setgId(gId);
        pro.setgName(product.getgName());
        pro.setgCat(product.getgCat());
        pro.setgNum(product.getgNum());
        pro.setgPrice(product.getgPrice());
        CommonResult commonResult = new CommonResult();
        commonResult.setData("");
        int n = productMapper.addPro(pro);
        System.out.println("新增结果：" + n);
        if (n > 0) {
            commonResult.setMessage("增加成功！");
            commonResult.setCode(Const.SUCCESS_CODE);
        } else {
            commonResult.setMessage("增加失败！");
            commonResult.setCode(Const.FAIL_CODE);
        }
        return ChangeToJson.changeToJson(commonResult);
    }

    // 获取所有数据  （没有分页）
    @Override
    @Cacheable(cacheNames = "productList")
    public String getAllPro() {
        System.out.println("初始化表格数据");
        List<Product> productList = productMapper.getAllPro();
        CommonResult commonResult = new CommonResult();
        if (productList.size() > 0) {
            commonResult.setCode(Const.SUCCESS_CODE);
            commonResult.setData(productList);
            commonResult.setMessage("查询" + Const.SUCCESS_MSG);
        } else {
            commonResult.setCode(Const.FAIL_CODE);
            commonResult.setData("");
            commonResult.setMessage("查询" + Const.FAIL_MSG);
        }
        return ChangeToJson.changeToJson(commonResult);
    }

    // 根据 id  删除
    @Override
    public String deleteById(String gId) {
        int n = productMapper.deleteById(gId);
        CommonResult commonResult = new CommonResult();
        if (n > 0) {
            commonResult.setCode(Const.SUCCESS_CODE);
            commonResult.setData(n);
            commonResult.setMessage("删除" + Const.SUCCESS_MSG);
        } else {
            commonResult.setCode(Const.FAIL_CODE);
            commonResult.setData(n);
            commonResult.setMessage("删除" + Const.FAIL_MSG);
        }
        return ChangeToJson.changeToJson(commonResult);
    }

    // 条件查询  支持模糊搜索 （分页）
    @Override
    public String queryProByCondition(String gName, String gCat,int currentPage,int pageSize) {
        CommonResult commonResult = new CommonResult();
        currentPage = (currentPage -1)*pageSize;
        // 根据输入条件 搜索情况  （sql 分析）
        List<Product> productList = productMapper.queryProByCondition(gName, gCat,currentPage,pageSize);
        int total = productMapper.getCount(gName,gCat);
        System.out.println("ProductServiceImpl--->条件查询总数："+ total);
        if (productList.size() > 0) {
            commonResult.setData(productList);
            commonResult.setCode(Const.SUCCESS_CODE);
            commonResult.setMessage(Const.SUCCESS_MSG);
            commonResult.setTotal(total);
        } else {
            commonResult.setData("");
            commonResult.setCode(Const.FAIL_CODE);
            commonResult.setMessage(Const.FAIL_MSG);
        }
        return ChangeToJson.changeToJson(commonResult);
    }

    // 修改商品信息
    @Override
    public String updatePro(Product product) {
        int n = productMapper.updatePro(product);
        CommonResult com = new CommonResult();
        if (n > 0) {
            com.setCode(Const.SUCCESS_CODE);
            com.setMessage(Const.SUCCESS_MSG);
            com.setData(product);
        } else {
            com.setCode(Const.FAIL_CODE);
            com.setMessage(Const.FAIL_MSG);
            com.setData("");
        }
        return ChangeToJson.changeToJson(com);
    }

    //  分页 查询
    @Override
    public String getByPage(int currentPage, int pageSize) {
        CommonResult commonResult = new CommonResult();
        String gName ="";
        String gCat = "";
        int pageNow = (currentPage - 1) * pageSize;
        List<Product> list = productMapper.getByPage(pageNow, pageSize);

        int total = productMapper.getCount(gName,gCat);// 获取总数
        if (list.size() > 0) {
            commonResult.setCode(Const.SUCCESS_CODE);
            commonResult.setMessage(Const.SUCCESS_MSG);
            commonResult.setData(list);
            commonResult.setTotal(total);
        } else {
            commonResult.setCode(Const.FAIL_CODE);
            commonResult.setMessage(Const.FAIL_MSG);
            commonResult.setData("");

        }
        return ChangeToJson.changeToJson(commonResult);
    }


}
