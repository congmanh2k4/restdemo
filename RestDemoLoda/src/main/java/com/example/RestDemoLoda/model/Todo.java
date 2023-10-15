/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RestDemoLoda.model;

import lombok.Data;

/**
 *
 * @author manhnche
 */
@Data
public class Todo {
    private String title;
    private String detail;

    public Todo(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    public Todo() {
    }
    
}
