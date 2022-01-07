/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.pos.nextgenpos.servlet.product;

import com.pos.nextgenpos.common.ProductDetails;
import com.pos.nextgenpos.ejb.ProductBean;
import com.pos.nextgenpos.ejb.UserBean;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author radvo
 */
@WebServlet(name = "EditProduct", urlPatterns = {"/EditProduct"})
public class EditProduct extends HttpServlet {

    @Inject
    ProductBean productBean;
    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("id"));
        ProductDetails product = productBean.findById(productId);
        request.setAttribute("product", product);
        request.getRequestDispatcher("/WEB-INF/pages/editProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String description = request.getParameter("description");
        Double price = Double.parseDouble(request.getParameter("price"));
        Integer productId = Integer.parseInt(request.getParameter("product_id"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        productBean.updateProduct(productId, description, price, quantity);
        response.sendRedirect(request.getContextPath() + "/Products");
    }

    @Override
    public String getServletInfo() {
        return "EditProduct v1.0";
    }

}
