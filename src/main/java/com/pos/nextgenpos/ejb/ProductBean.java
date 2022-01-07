/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.pos.nextgenpos.ejb;

import com.pos.nextgenpos.common.ProductDetails;
import com.pos.nextgenpos.entity.Product;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author radvo
 */
@Stateless
public class ProductBean {

    private static final Logger LOG = Logger.getLogger(ProductBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public List<ProductDetails> getAllProducts() {
        LOG.info("getAllProducts");
        try {
            List<Product> products = (List<Product>) em.createQuery("SELECT p FROM Product p").getResultList();
            return copyProductsToDetails(products);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<ProductDetails> copyProductsToDetails(List<Product> products) {
        List<ProductDetails> detailsList = new ArrayList<>();
        for (Product product : products) {
            ProductDetails productDetails = new ProductDetails(
                    product.getId(),
                    product.getPrice(),
                    product.getName(),
                    product.getQuantity()
            );

            detailsList.add(productDetails);
        }
        return detailsList;
    }

    public List<ProductDetails> addToCart(Collection<Integer> ids, Integer qt) {
        LOG.info("addToCartByIds");
        List<ProductDetails> shoppingCartList = new ArrayList<>();
        for (Integer id : ids) {
            Product product = em.find(Product.class, id);
            ProductDetails productDetails = new ProductDetails(
                    product.getId(),
                    product.getPrice(),
                    product.getName(),
                    qt);
            shoppingCartList.add(productDetails);
        }
        return shoppingCartList;
    }

    public ProductDetails findById(Integer productId) {
        Product product = em.find(Product.class, productId);
        return new ProductDetails(product.getId(), product.getPrice(), product.getName(), product.getQuantity());

    }

    public Collection<String> findUsernames(Collection<Integer> userIds) {
        LOG.info("findUsernames");
        List<String> usernames = (List<String>) em.createQuery("SELECT p.name FROM Product p WHERE p.id IN ?1").setParameter(1, userIds).getResultList();
        return usernames;
    }

    public void createProduct(String name, Double price, Integer quantity) {
        LOG.info("createProduct");
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        em.persist(product);
    }

    public void updateProduct(Integer productId, String name, Double price, Integer quantity) {

        LOG.info("updateProduct");
        Product product = em.find(Product.class, productId);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

    }

    public void deleteProductsByIds(Collection<Integer> ids) {
        LOG.info("deleteProductsByIds");
        for (Integer id : ids) {
            Product product = em.find(Product.class, id);
            em.remove(product);
        }
    }

}
