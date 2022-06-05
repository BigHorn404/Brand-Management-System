package com.bighorn.web.old; /**
 * @author: lzh
 * @date: 2022/5/4 22:11
 * @description:
 */

import com.bighorn.service.BrandService;
import com.bighorn.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {

    //获取BrandService对象
    private BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接受前端传来的id值
        String id = request.getParameter("id");
        // 2.执行BrandService中的delete删除方法
        brandService.delete(Integer.parseInt(id));
        // 3.转发到查询所有Servlet,查询查询数据
        request.getRequestDispatcher("/select").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
