package com.bighorn.service.impl;

import com.bighorn.mapper.BrandMapper;
import com.bighorn.pojo.Brand;
import com.bighorn.pojo.PageBean;
import com.bighorn.service.BrandService;
import com.bighorn.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author: lzh
 * @date: 2022/5/11 16:06
 * @description:
 */
public class BrandServiceImpl implements BrandService {

    /**
     * 查询所有
     */
    @Override
    public List<Brand> selectAll() {
        // 1.获取SqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 2.获取mapper代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 3.调用接口中的方法
        List<Brand> brands = mapper.selectAll();
        // 4.释放SqlSession资源
        sqlSession.close();
        // 5.返回brand集合
        return brands;
    }

    /**
     * 添加品牌数据
     */
    @Override
    public void add(Brand brand) {
        // 1.获取SqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 2.获取mapper代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 3.调用接口中的方法
        mapper.add(brand);
        // 4.提交事务
        sqlSession.commit();
        // 5.释放SqlSession资源
        sqlSession.close();
    }

    /**
     * 根据id查询数据
     */
    @Override
    public Brand selectById(int id) {
        // 1.获取SqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 2.获取mapper代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 3.调用接口中的方法
        Brand brand = mapper.selectById(id);
        // 4.释放SqlSession资源
        sqlSession.close();
        // 5.返回brand对象
        return brand;
    }

    /**
     * 更新品牌数据
     */
    @Override
    public void update(Brand brand) {
        // 1.获取SqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 2.获取mapper代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 3.调用接口中的方法
        mapper.update(brand);
        // 4.提交事务
        sqlSession.commit();
        // 5.释放SqlSession资源
        sqlSession.close();
    }

    /**
     * 根据id删除数据
     */
    @Override
    public void delete(int id) {
        // 1.获取SqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 2.获取mapper代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 3.调用接口中的方法
        mapper.delete(id);
        // 4.提交事务
        sqlSession.commit();
        // 5.释放SqlSession资源
        sqlSession.close();
    }

    /**
     * 根据ids数组批量删除数据
     */
    @Override
    public void deleteByIds(int[] ids) {
        // 1.获取SqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 2.获取mapper代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 3.调用接口中的方法
        mapper.deleteByIds(ids);
        // 4.提交事务
        sqlSession.commit();
        // 5.释放SqlSession资源
        sqlSession.close();
    }

    /**
     * 分页查询功能
     * @param currentPage 当前页数
     * @param pageSize 每页展示条数
     * @return
     */
    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        // 1.获取SqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 2.获取mapper代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 3.计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 4.调用mapper接口的分页查询方法，查询当前页数据
        List<Brand> rows = mapper.selectByPage(begin, pageSize);
        // 5.调用mapper接口的查询总记录数方法
        int totalCount = mapper.selectTotalCount();
        // 6.将当前页数据和总记录数封装到PageBean中
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        // 7.释放SqlSession资源
        sqlSession.close();
        // 8.返回pageBean
        return pageBean;
    }

    /**
     * 分页条件查询
     * @param currentPage 当前页数
     * @param pageSize 每页展示条数
     * @param brand 传入的条件对象
     * @return
     */
    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        // 1.获取SqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 2.获取mapper代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 3.计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 4.调用mapper接口的条件查询方法
        List<Brand> rows = mapper.selectByPageAndCondition(begin, pageSize,brand);
        // 5.调用mapper接口的查询总记录数方法
        int totalCountByCondition = mapper.selectTotalCountByCondition(brand);
        // 6.将当前页数据和总记录数封装到PageBean中
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCountByCondition);
        // 7.释放SqlSession资源
        sqlSession.close();
        // 8.返回pageBean
        return pageBean;
    }
}
