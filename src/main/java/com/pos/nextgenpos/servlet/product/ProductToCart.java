/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.pos.nextgenpos.servlet.product;

import com.pos.nextgenpos.common.ProductDetails;
import com.pos.nextgenpos.ejb.CartBean;
import com.pos.nextgenpos.ejb.ProductBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
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
@WebServlet(name = "ProductToCart", urlPatterns = {"/ProductToCart"})
public class ProductToCart extends HttpServlet {

    @Inject
    private ProductBean productBean;

    @Inject
    private CartBean cartBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        request.setAttribute("activePage", "ProductToCart");

        List<ProductDetails> products = productBean.getAllProducts();
        request.setAttribute("products", products);
        /* String[] productIdsAsString = request.getParameterValues("product_ids");
        if (productIdsAsString != null) {
            List<Integer> productIds = new ArrayList<>();
            for (String productIdAsString : productIdsAsString) {
                productIds.add(Integer.parseInt(productIdAsString));

            }

            
            List<ProductDetails> list = productBean.AddToCart(productIds, quantity);
            request.setAttribute("cart", list);
            //productBean.AddToCart(productIds, quantity);
        }*/

        if (!cartBean.getProductIds().isEmpty()) {
            Collection<String> usernames = productBean.findUsernames(cartBean.getProductIds());
            request.setAttribute("invoices", usernames);
        }
        request.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(request, response);

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

            //Integer quantity = Integer.parseInt(request.getParameter("quantity"));
            //List<ProductDetails> list = productBean.AddToCart(productIds, quantity);
            //request.setAttribute("cart", list);
            cartBean.getProductIds().addAll(productIds);
            //productBean.AddToCart(productIds, quantity);
        }
        Integer quant = Integer.parseInt(request.getParameter("q"));
        request.setAttribute("qt", quant);
        response.sendRedirect(request.getContextPath() + "/ProductToCart");
    }

    @Override
    public String getServletInfo() {
        return "ProductToCart v1.0";
    }

}
