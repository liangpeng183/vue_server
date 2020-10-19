package com.szcf.vue_server.service;

import com.szcf.vue_server.bean.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lp
 * @Description: ${todo}
 * @create 2020/10/9 16:34
 */
@Service
public interface IProductService {

    int addPro(Product product);

    List<Product> getAllPro();

    int deleteById(String gId);

    List<Product> queryProByCondition(String gName,String gCat);

    int updatePro(Product product);

}
