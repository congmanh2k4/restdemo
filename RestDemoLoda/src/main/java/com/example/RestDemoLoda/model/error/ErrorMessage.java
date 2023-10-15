/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RestDemoLoda.model.error;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author manhnche
 */
@Data
@AllArgsConstructor
public class ErrorMessage {
    private int statusCode;
    private String message;
}
