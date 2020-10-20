package com.szcf.vue_server.mapper;

import com.szcf.vue_server.bean.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lp
 * @Description: ${todo}
 * @create 2020/10/9 16:33
 */
@Repository
@Mapper
public interface ProductMapper {

    // 新增 数据
    @Insert("insert into product values(#{gId},#{gName},#{gCat},#{gNum},#{gPrice})")
    int addPro(Product product);

    // 查询所有
    @Select("select * from product ")
    List<Product> getAllPro();

    // 根据id 删除
    @Delete("delete from product where gId = #{gId}")
    int deleteById(String gId);

    // 条件查询  xml
  /*  @Select({"<script>",
            " SELECT * FROM product ",
            " where 1 = 1 ",
            " <when test='gName != null'>",
            " and gName = #{gName}",
            " </when> ",
            " <when test='gCat != null'>",
            " and gCat = #{gCat}",
            " </when>",
            " </script>"})*/
    List<Product> queryProByCondition(@Param("gName")String gName,@Param("gCat")String gCat,
                                      @Param("currentPage")int currentPage,@Param("pageSize")int pageSize);

    // 更新
    @Update("update product set gName = #{gName}, gCat = #{gCat} , gNum =#{gNum} , gPrice =#{gPrice} where gId = #{gId}")
    int updatePro(Product product);

    //分页 查询
    @Select("select  * from product limit #{pageNow},#{pageSize}")
    List<Product> getByPage(@Param("pageNow")int pageNow,@Param("pageSize")int pageSize);

    // 获取总数
//    @Select("SELECT COUNT(*) from product")
    int getCount(@Param("gName")String gName,@Param("gCat")String gCat);

}
