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
        } catch (Exception e) {
            throw new EJBException(e);
        }
    }

    private List<ProductDetails> copyProductsToDetails(List<Product> products) {
        List<ProductDetails> detailsList = new ArrayList<>();
        for (Product product : products) {
            ProductDetails productDetails = new ProductDetails(
                    product.getId(),
                    product.getName(),
                    product.getPrice()
            );

            detailsList.add(productDetails);
        }
        return detailsList;
    }

    public void createProduct(Integer id, String name, Double price) {
        Product product = new Product();
        product.setId(id);
        product.setPrice(price);
        product.setName(name);
        em.persist(product);
    }

    public ProductDetails findById(Integer productId) {
        Product product = em.find(Product.class, productId);
        return new ProductDetails(product.getId(), product.getName(), product.getPrice());

    }

    public void updateProduct(Integer id, String name, Double price) {

        LOG.info("updateProduct");
        Product product = em.find(Product.class, id);
        product.setName(name);
        product.setPrice(price);
    }

    public void deleteProductsByIds(Collection<Integer> ids) {
        LOG.info("deleteProductsByIds");
        for (Integer id : ids) {
            Product product = em.find(Product.class, id);
            em.remove(product);
        }
    }
}
