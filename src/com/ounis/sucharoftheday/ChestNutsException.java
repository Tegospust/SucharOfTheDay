/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ounis.sucharoftheday;

/**
 *
 * @author AndroidDev
 */
public class ChestNutsException extends Exception {

    protected static final String EXC_EMPTY_CHEST_NUTS_LIST = "Lista nie zawiera sucharków!";
    
    ChestNutsException(String erroMessage) {
        super(erroMessage);
    }
    
     
}
