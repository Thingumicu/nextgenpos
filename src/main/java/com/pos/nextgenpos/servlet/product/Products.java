/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.pos.nextgenpos.servlet.product;

import com.pos.nextgenpos.common.ProductDetails;
import com.pos.nextgenpos.ejb.ProductBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "Products", urlPatterns = {"/Products"})
public class Products extends HttpServlet {

    @Inject
    private ProductBean productBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("activePage", "Products");

        List<ProductDetails> products = productBean.getAllProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/pages/products.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] productIdsAsString = request.getParameterValues("product_ids");
        if (productIdsAsString != null) {
            List<Integer> productIds = new ArrayList<>();
            for (String productIdAsString : productIdsAsString) {
                productIds.add(Integer.parseInt(productIdAsString));
            }
            productBean.deleteProductsByIds(productIds);
        }
        response.sendRedirect(request.getContextPath() + "/Products");

    }

    @Override
    public String getServletInfo() {
        return "Products v1.0";
    }

}
