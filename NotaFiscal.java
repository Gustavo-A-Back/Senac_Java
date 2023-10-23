/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.exercicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;





/**
 *
 * @author guto_
 */
public class NotaFiscal implements Comparator<Produto>{
    
    private double valorTotal;
    private Produto item;
    public final int TAMANHO_MAXIMO_NOME_PRODUTO = 20;
    
    private List<Produto> produtos= new ArrayList();
  
    public double calcularValorTotal(){
        
        for (Produto soma : getProdutos()){
          valorTotal+=(soma.getPrecoTotal());
        }
        return valorTotal;
    }
    
    public void exibirProdutos (){
        
        for (Produto exibir : getProdutos()){
          exibir.exibirInformacoes();
        }    
        
    }
    
    
    public void adicionarProduto(Produto item){
        if (item.getNome().length() > TAMANHO_MAXIMO_NOME_PRODUTO) {
            String mensagemErro = String.format("O produto %s não foi adicionado pois o nome não pode ter mais que %d caracteres.", item.getNome(), TAMANHO_MAXIMO_NOME_PRODUTO);
            throw new NomeProdutoInvalidoException(mensagemErro);
        } else {
            getProdutos().add (new Produto(item.getNome(),item.getPreco(),item.getImposto()));
    }
    }
    
    public void removerProduto(String nomeItem){
        
        for (Produto remover : getProdutos()){ 


            if (remover.getNome().equals(nomeItem)){
            
                getProdutos().remove(remover);
                return;
            }
        }

        String mensagemErro = String.format("O produto %s não foi removido pois não foi encontrado.", nomeItem);
        throw new ProdutoNaoEncontradoException(mensagemErro);
        
    }
    

   public Produto getProdutoPorNome(String nomePR){
        
        for (Produto find : getProdutos()){ 
            
            boolean teste =find.getNome().equals(nomePR);
            
            if (teste){
              return find;  
            }   
        }
        String mensagemErro = String.format("O produto %s não foi encontrado.", nomePR);
        throw new ProdutoNaoEncontradoException(mensagemErro);     
}
   

   //public boolean possuiProdutoPorNome(String nomePR){
       
   
       //for (Produto find : getProdutos()){ 
           
           // if (find.getNome().equals(nomePR)){
          //     return true;
           // } 
  // }
       // return false;
  
//}

    @Override
    public int compare(Produto o1, Produto o2) {
    if(o1.getNome().compareTo(o2.getNome())>0){
        return 1;
    }
    return -1;
 
    } 
   
       
       
    public List getProdutosOrdenadosPorNome (){
        Collections.sort(getProdutos(),new NotaFiscal());
        return getProdutos();

        }
    
    public List getProdutosOrdenadosPorPreco (){
        Collections.sort(getProdutos(),new Ordlist());
        return getProdutos();

        }

    /**
     * @return the produtos
     */
    public List<Produto> getProdutos() {
        return produtos;
    }

    
}
 
   
  
  

   
        
        
        
         

    
    
    
        
