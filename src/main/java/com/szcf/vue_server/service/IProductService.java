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

    String addPro(Product product);

    String getAllPro();

    String deleteById(String gId);

    String queryProByCondition(String gName,String gCat);

    String  updatePro(Product product);

}
