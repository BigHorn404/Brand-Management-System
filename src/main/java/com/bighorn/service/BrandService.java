package com.bighorn.service;

import com.bighorn.pojo.Brand;
import com.bighorn.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lzh
 * @date: 2022/5/11 19:05
 * @description:
 */
public interface BrandService {
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
    void deleteByIds(int[] ids);

    /**
     *分页查询
     * @param currentPage 当前页数
     * @param pageSize 每页展示条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage,int pageSize);

    /**
     * 条件查询
     * @param currentPage 当前页数
     * @param pageSize 每页展示条数
     * @param brand 传入的条件对象
     * @return
     */
    PageBean<Brand>  selectByPageAndCondition(int currentPage,int pageSize,Brand brand);


}
