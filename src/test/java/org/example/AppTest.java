package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public  void TesteCriarProduto(){
        Produto produto = new Produto("Teclado gamer",150,10);
        assertEquals("Teclado gamer",produto.getNome());
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
    @Test
    public void TesteAterarPrecoValido(){
        Produto produto = new Produto("Cadeira gamer", 150, 10);
        produto.setPreco(75.0);
        assertEquals(75.0,produto.getPreco(),0.01);
    }
    @Test
    public void TesteAterarEstoquePositivo(){
        Produto produto = new Produto("Cadeira gamer", 150, 10);
        produto.setEstoque(20);
        assertEquals(20,produto.getEstoque());

    }
    @Test
    public void TesteAlterarProdutoValorNegativo(){
        Produto produto = new Produto("Cadeira gamer", 150, 10);
        produto.setPreco(20.0);
        assertTrue(produto.getPreco()>=0, "preço deve ser positivo");
    }
    @Test
    public void TesteVendaQuantMenorEstoque(){
        Produto produto = new Produto("Cadeira gamer", 150, 10);
        Venda venda = new Venda(produto,5);
        assertTrue(venda.realizarVenda());
        assertEquals(5,produto.getEstoque());
    }
    @Test
    public void TestVendaIgualEstoque(){
        Produto produto = new Produto("Cadeira gamer", 150, 10);
        Venda venda = new Venda(produto,10);
        assertTrue(venda.realizarVenda());
        assertEquals(0,produto.getEstoque());
    }
    @Test
    public void TesteVendaQuantMaiorEstoque(){
        Produto produto = new Produto("Cadeira gamer", 150, 10);
        Venda venda = new Venda(produto,15);
        assertFalse(venda.realizarVenda());
    }
    @Test
    public void testCalcularTotalVenda(){
        Produto produto = new Produto("Cadeira gamer", 100, 10);
        Venda venda = new Venda(produto,2);
        venda.realizarVenda();
        assertEquals(200.0,venda.getTotalVenda(),0.01);

    }
    @Test
    public void TesteAumentarEstoquePosVenda(){
        Produto produto = new Produto("Cadeira gamer", 150, 10);
        produto.aumentarEstoque(5);
        assertEquals(15,produto.getEstoque());
    }
    @Test
    public void TesteDiminuirEstoque(){
        Produto produto = new Produto("Cadeira gamer", 150, 10);
        Venda venda = new Venda(produto,7);
        venda.realizarVenda();
        assertEquals(3,produto.getEstoque());
    }
    @Test
    public void TesteVendaProdutoInexistente(){
        Produto produto = null;
        Venda venda = new Venda(produto,5);
        assertThrows(NullPointerException.class, venda::realizarVenda);
    }
    @Test
    public void TesteCriarVendaQtdNegativa(){
        Produto produto = new Produto("Cadeira gamer", 150, 10);
        Venda venda = new Venda(produto,10);
        assertTrue(venda.realizarVenda());

    }
    @Test
    public void TesteAlterarEstoqueComEstoqueInsuficiente(){
        Produto produto = new Produto("Cadeira gamer", 150, 5);
        Venda venda = new Venda(produto,10);
        venda.realizarVenda();
        assertEquals(5,produto.getEstoque());
    }
    @Test
    public void testCriacaoVariosProdutosVendas() {
        Produto produto1 = new Produto("Monitor Gamer", 30.0, 10);
        Produto produto2 = new Produto("Teclado Gamer", 40.0, 10);
        Venda venda1 = new Venda(produto1, 5);
        Venda venda2 = new Venda(produto2, 5);
        assertTrue(venda1.realizarVenda());
        assertTrue(venda2.realizarVenda());
        assertEquals(5, produto1.getEstoque());
        assertEquals(5, produto2.getEstoque());
    }
    @Test
    public void testTotalVendaPrecoAlteradoAntesVenda() {
        Produto produto = new Produto("Mousepad", 40.0, 10);
        produto.setPreco(100.0);
        Venda venda = new Venda(produto, 2);
        venda.realizarVenda();
        assertEquals(200.0, venda.getTotalVenda(), 0.01);
    }
    @Test
    public void testVendaEstoqueInicialZero() {
        Produto produto = new Produto("PC gamer", 50.0, 0);
        Venda venda = new Venda(produto, 1);
        assertFalse(venda.realizarVenda());
    }
    @Test
    public void testAumentoEstoque() {
        Produto produto = new Produto("Memoria Ram", 50.0, 0);
        produto.aumentarEstoque(5);
        Venda venda = new Venda(produto, 3);
        assertTrue(venda.realizarVenda());
        assertEquals(2, produto.getEstoque());
}

}
