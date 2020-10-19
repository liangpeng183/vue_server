package com.szcf.vue_server.service.impl;

import com.szcf.vue_server.bean.Product;
import com.szcf.vue_server.mapper.ProductMapper;
import com.szcf.vue_server.service.IProductService;
import com.szcf.vue_server.util.ChangeToJson;
import com.szcf.vue_server.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lp
 * @Description: ${todo}
 * @create 2020/10/9 16:35
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int addPro(Product product) {
        return productMapper.addPro(product);
    }

    @Override
    public List<Product> getAllPro() {
         return  productMapper.getAllPro();
    }

    @Override
    public int deleteById(String gId) {
        return productMapper.deleteById(gId);
    }

    @Override
    public List<Product> queryProByCondition(String gName, String gCat) {
        return productMapper.queryProByCondition(gName,gCat);
    }

    @Override
    public int updatePro(Product product) {
        return productMapper.updatePro(product);
    }
}
