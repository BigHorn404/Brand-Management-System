package com.bighorn.web.old; /**
 * @author: lzh
 * @date: 2022/5/4 14:48
 * @description:
 */

import com.alibaba.fastjson.JSON;
import com.bighorn.pojo.Brand;
import com.bighorn.service.BrandService;
import com.bighorn.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectAllServlet", value = "/selectAll")
public class SelectAllServlet extends HttpServlet {
    //获取BrandService对象
    private BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 调用BrandService的selectAll()方法完成查询
        List<Brand> brands = brandService.selectAll();
        // 2.将brands集合转换成json数组
        String jsonString = JSON.toJSONString(brands);
        //3. 响应数据  application/json   text/json
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
