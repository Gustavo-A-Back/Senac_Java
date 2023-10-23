/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.senac.exercicio;

import java.util.List;

/**
 *
 * @author Aluno
 */
public class Exercicio {
    


     public static void main(String[] args) {

        
            
        Livro useACabecaJava = new Livro("Use a cabeça! Java", 65, 5);
        Televisao televisaoSamsung = new Televisao("Televisao Samsung", 3000, 100);
        Computador computadorAcer = new Computador("Computador Acer", 4500, 90);
        
        NotaFiscal nota = new NotaFiscal();
        nota.adicionarProduto(useACabecaJava);
        nota.adicionarProduto(televisaoSamsung);
        nota.adicionarProduto(computadorAcer);
        
        double valorTotalNota = nota.calcularValorTotal();
        System.out.println("Valor total nota: " + valorTotalNota);
        nota.exibirProdutos();
        
        nota.removerProduto("Televisao Samsung");
        System.out.println("Produtos atualizados");
        nota.exibirProdutos();
        
        Produto produtoBuscado = nota.getProdutoPorNome("Computador Acer");
        System.out.println("Produto buscado");
        produtoBuscado.exibirInformacoes();
        
        
        nota.adicionarProduto(new Televisao("Televisao Sony", 2700, 100));
        nota.adicionarProduto(new Computador("Computador Dell", 6200, 90));
        
        System.out.println("\n-- Produtos ordenados por nome --");
        
        List<Produto> produtosOrdenadosPorNome = nota.getProdutosOrdenadosPorNome();
        for (Produto produto : produtosOrdenadosPorNome) {
            System.out.println("Produto: " + produto.getNome());
            System.out.println("Produto: " + produto.getPreco());
        }
        
      System.out.println("\n-- Produtos ordenados por preco --");
      List<Produto> produtosOrdenadosPorPreco = nota.getProdutosOrdenadosPorPreco();
       for (Produto produto : produtosOrdenadosPorPreco) {
            System.out.println("Produto: " + produto.getNome());
           System.out.println("Produto: " + produto.getPreco());
        }
    }
   }

