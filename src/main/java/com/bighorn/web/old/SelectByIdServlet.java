package com.bighorn.web.old; /**
 * @author: lzh
 * @date: 2022/5/4 20:13
 * @description:
 */

import com.bighorn.pojo.Brand;
import com.bighorn.service.BrandService;
import com.bighorn.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectByIdServlet", value = "/selectById")
public class SelectByIdServlet extends HttpServlet {
    //获取BrandService对象
    private BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 0.获取客户端传入的id
        String id = request.getParameter("id");
        // 1. 调用BrandService的selectById(int id)方法完成查询
        Brand brand = brandService.selectById(Integer.parseInt(id));
        // 2.将查询结果brand存入request域对象中
        request.setAttribute("brand", brand);
        // 3.将资源转发到update.jsp中
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
