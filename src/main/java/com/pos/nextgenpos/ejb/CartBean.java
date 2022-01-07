/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.pos.nextgenpos.ejb;

import java.util.HashSet;
import java.util.Set;
import javax.ejb.Stateless;

/**
 *
 * @author radvo
 */
@Stateless
public class CartBean {

    private Set<Integer> productIds = new HashSet<Integer>();

    public Set<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(Set<Integer> productIds) {
        this.productIds = productIds;
    }

}
