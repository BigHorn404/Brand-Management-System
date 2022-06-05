package com.bighorn.web.old; /**
 * @author: lzh
 * @date: 2022/5/4 16:42
 * @description:
 */

import com.alibaba.fastjson.JSON;
import com.bighorn.pojo.Brand;
import com.bighorn.service.BrandService;
import com.bighorn.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "AddServlet", value = "/add")
public class AddServlet extends HttpServlet {
    //获取BrandService对象
    private BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
