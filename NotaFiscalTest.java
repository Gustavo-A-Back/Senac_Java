

import com.senac.exercicio.NomeProdutoInvalidoException;
import com.senac.exercicio.NotaFiscal;
import com.senac.exercicio.Produto;
import com.senac.exercicio.ProdutoNaoEncontradoException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class NotaFiscalTest {
    
    
@Test
void quandoCalcularValorTotal_deveTerSucesso() {
        // arrange
        
        NotaFiscal nota = new NotaFiscal();
        Produto carro = new Produto("corsa",20000,100);
        Produto moto = new Produto("mt03",25000,150);
        Produto bike = new Produto("caloi",6000,80);
        
        
        nota.adicionarProduto(bike);
        nota.adicionarProduto(carro);
        nota.adicionarProduto(moto);


        // act
        double resultado = nota.calcularValorTotal();

        // assert
        Assertions.assertEquals(51330, resultado);
    }

@Test
void quandoSomarPrecoTotal_deveTerSucesso() {
        // arrange

        Produto carro = new Produto("corsa",20000,100);

        // act
        double resultado = carro.getPrecoTotal();

        // assert
        Assertions.assertEquals(20100, resultado);
    }




@Test
void quandoAdicionarProdutoValido_DeveTerSucesso (){
        // arrange
        NotaFiscal nota = new NotaFiscal();
        Produto carro = new Produto("corsa",20000,100);
        

        // act
        nota.adicionarProduto(carro);

        // assert
        Assertions.assertEquals(1, nota.getProdutos().size());
        
        
    }

@Test
void quandoAdicionarProdutoComNumeroDeCaracteresMaiorQuePermitido_DeveExibirNomeProdutoInvalidoException (){
        // arrange
        NotaFiscal nota = new NotaFiscal();
        Produto carro = new Produto("corsa classic 1.6 turbo flex",20000,100);
        int TAMANHO_MAXIMO_NOME_PRODUTO = 20;
        

        // act
        NomeProdutoInvalidoException resultado = assertThrows(NomeProdutoInvalidoException.class, () -> nota.adicionarProduto(carro));
        
        // assert
        Assertions.assertEquals(String.format("O produto %s não foi adicionado pois o nome não pode ter mais que %d caracteres.", carro.getNome(),TAMANHO_MAXIMO_NOME_PRODUTO), resultado.getMessage());

}



@Test
void quandoRemoverProdutoValido_DeveTerSucesso (){
        // arrange
        NotaFiscal nota = new NotaFiscal();
        Produto carro = new Produto("carro",20000,100);
         Produto moto = new Produto("moto",10000,100);
        

        // act
        nota.adicionarProduto(carro);
        nota.adicionarProduto(moto);
        nota.removerProduto("moto");

        // assert
        Assertions.assertEquals(1, nota.getProdutos().size());
        
}

@Test
void quandoTentarRemoverProdutoInvalido_DeveExibirProdutoNaoEncontradoException (){
        // arrange
        NotaFiscal nota = new NotaFiscal();
         String nomeItem = "teste";
        

        // act
        ProdutoNaoEncontradoException resultado = assertThrows(ProdutoNaoEncontradoException.class, () -> nota.removerProduto(nomeItem));
        
        // assert
        Assertions.assertEquals(String.format("O produto %s não foi removido pois não foi encontrado.", nomeItem), resultado.getMessage());
        
}


@Test
void quandoPesquisarUmProdutoValidoPorNome_DeveTerSucesso (){
        // arrange
        NotaFiscal nota = new NotaFiscal();
        Produto carro = new Produto("carro",20000,100);
         Produto moto = new Produto("moto",10000,100);
        

        // act
        nota.adicionarProduto(carro);
        nota.adicionarProduto(moto);
        Produto resultado = nota.getProdutoPorNome("moto");
 

        // assert
        Assertions.assertEquals(moto.getNome(),resultado.getNome() );
        
}

@Test
void quandoPesquisarUmProdutoValidoPorNome_DeveExibirProdutoNaoEncontradoException (){
        // arrange
        NotaFiscal nota = new NotaFiscal();
        String nomePR = "teste";
        

        // act
        ProdutoNaoEncontradoException resultado = assertThrows(ProdutoNaoEncontradoException.class, () -> nota.getProdutoPorNome(nomePR));
        
        // assert
        Assertions.assertEquals(String.format("O produto %s não foi encontrado.", nomePR), resultado.getMessage());
        
}


}
