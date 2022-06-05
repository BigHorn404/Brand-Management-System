package com.bighorn.mapper;

import com.bighorn.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lzh
 * @date: 2022/5/3 22:46
 * @description:
 */
public interface BrandMapper {
    /**
     * 查询所有公司数据
     * @return List<Brand>
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     * @param brand
     */
    void add(Brand brand);

    /**
     * 根据id查询数据
     * @param id
     * @return Brand
     */
    Brand selectById(int id);

    /**
     * 修改品牌数据
     * @param brand
     */
    void update(Brand brand);

    /**
     * 根据id删除数据
     * @param id
     */
    void delete(int id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     * @param begin 开始索引
     * @param size  查询条数
     */
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    /**
     * 查询总记录数
     * @return
     */
    int selectTotalCount();

    /**
     * 分页条件查询
     * @param begin 分页查询的起始索引
     * @param size 分页查询的每页条目数
     * @param brand 用来封装条件的对象
     * @return
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    /**
     * 条件查询总记录数
     * @param brand
     * @return
     */
    int selectTotalCountByCondition(Brand brand);
}
