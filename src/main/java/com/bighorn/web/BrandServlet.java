package com.bighorn.web; /**
 * @author: lzh
 * @date: 2022/5/11 21:57
 * @description:
 */

import com.alibaba.fastjson.JSON;
import com.bighorn.pojo.Brand;
import com.bighorn.pojo.PageBean;
import com.bighorn.service.BrandService;
import com.bighorn.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    //获取BrandService对象
    private BrandService brandService = new BrandServiceImpl();

    //查询所有功能
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 调用BrandService的selectAll()方法完成查询
        List<Brand> brands = brandService.selectAll();
        // 2.将brands集合转换成json数组
        String jsonString = JSON.toJSONString(brands);
        //3. 响应数据  application/json   text/json
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    //添加品牌数据功能
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.处理post请求乱码的字符集
        request.setCharacterEncoding("utf-8");
        // 2.获取请求体数据,getParameter 不能接收json的数据
        BufferedReader reader = request.getReader();
        String json = reader.readLine();
        // 3.将JSON字符串转为Java对象
        Brand brand = JSON.parseObject(json, Brand.class);
        // 4.调用 BrandService的add()方法将数据添加到数据库
        brandService.add(brand);
        // 5. 响应成功标识
        response.getWriter().write("success");
    }

    //批量删除功能
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.处理post请求乱码的字符集
        request.setCharacterEncoding("utf-8");
        // 2.获取json数组 [1,2,3]
        BufferedReader reader = request.getReader();
        String json = reader.readLine();
        // 3.将JSON字符串转为java int[]数组
        int[] ids = JSON.parseObject(json, int[].class);
        // 4.调用 BrandService的deleteByIds()方法将数据删除
        brandService.deleteByIds(ids);
        // 5. 响应成功标识
        response.getWriter().write("success");
    }

    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 1.获取 当前页数 和 每页展示条数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        // 2.调用service查询
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);
        // 3.将对象转换为json格式
        String jsonString = JSON.toJSONString(pageBean);
        // 4.响应数据给前端
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 条件分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 1.处理post请求乱码的字符集
        request.setCharacterEncoding("utf-8");
        // 1.获取 当前页数 和 每页展示条数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        // 2.获取json数据：brand条件
        BufferedReader reader = request.getReader();
        String json = reader.readLine();
//        System.out.println("获取到的json："+json);
        // 3.将获取到的json数据转换成brand对象
        Brand brand = JSON.parseObject(json, Brand.class);
//        System.out.println("转换后的brand"+brand);
        // 4.调用service查询
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);
        // 5.将查询到的数据转换为json格式
        String jsonString = JSON.toJSONString(pageBean);
        // 6.响应数据给前端
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
