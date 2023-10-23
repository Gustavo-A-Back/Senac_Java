/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.exercicio;

import java.util.Comparator;


public class Ordlist implements Comparator<Produto> {
    
    @Override
   public int compare(Produto o1, Produto o2) {
    
        
    if(o1.getPrecoTotal().compareTo(o2.getPrecoTotal())>0){
        return 1;
    }
    return -1;
    } 
    
}
