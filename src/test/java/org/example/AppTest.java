package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public  void TesteCriarProduto(){
        Produto produto = new Produto("cadeira",150,10);
        assertEquals("cadeira",produto.getNome());
        assertEquals(150.00,produto.getPreco());
        assertEquals(10,produto.getEstoque());
    }
    @Test
    public void TestePecoNegativo (){
        Produto produto = new Produto("Monitor gamer", 150, 10);
        assertFalse(produto.getPreco() < 0, "O preço deve ser positivo");

    }
    @Test
    public void TesteEstoqueNegativo (){
        Produto produto = new Produto("Cadeira gamer", 150, -10);
        assertFalse(produto.getEstoque() > 0, "A quantidade deve ser positiva");
    }
    @Test
    public void TesteTrocaDeNome (){
        Produto produto = new Produto("Cadeira gamer", 150, 10);
        produto.setNome("Cadeira Gamer Alterada");
        assertEquals("Cadeira Gamer Alterada", produto.getNome());

    }


}
