/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.nextgenpos.common;

/**
 *
 * @author radvo
 */
public class UserDetails {

    private Integer id;
    private String username;
    private String position;

    public UserDetails(Integer id, String username, String position) {
        this.id = id;
        this.username = username;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPosition() {
        return position;
    }

}
