package com.bighorn.web.old; /**
 * @author: lzh
 * @date: 2022/5/4 16:42
 * @description:
 */

import com.bighorn.pojo.Brand;
import com.bighorn.service.BrandService;
import com.bighorn.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/update")
public class UpdateServlet extends HttpServlet {
    //获取BrandService对象
    private BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.处理post请求乱码的字符集
        request.setCharacterEncoding("utf-8");
        // 2.接收客户端提交的数据
        String id = request.getParameter("id");
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        // 3.将数据封装到Brand对象中
        // 3.1创建Brand对象
        Brand brand = new Brand();
        // 3.2调用set方法封装数据
        brand.setId(Integer.parseInt(id));
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));
        // 4.调用 BrandService的update()方法将数据更新
        brandService.update(brand);
        // 5.转发到查询所有Servlet,查询查询数据
        request.getRequestDispatcher("/select").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
