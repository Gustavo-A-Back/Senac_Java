/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.exercicio;

import java.util.Comparator;

/**
 *
 * @author Aluno
 */
public class Produto {
    
    private String nome;
    private Double preco;
    private double imposto;
    
    
    
    

    public String getNome() {
        return nome;
      
    }

    public double getPreco() {
        return preco;
    }

    public double getImposto() {
        return imposto;
    }
    
    
    public Produto(String nome, double preco, double imposto){
        this.nome = nome;
        this.preco=preco;
        this.imposto=imposto;
        
    }
    
    public Double getPrecoTotal(){
        return this.preco + this.imposto;
    }
    
    public void exibirInformacoes(){
        System.out.println("NOME: " + this.nome);
        System.out.println("PREÇO: " + this.preco);
        System.out.println("IMPOSTO: "+ this.imposto);
        System.out.println("\n");
    }

    
}
    

