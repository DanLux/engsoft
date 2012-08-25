package br.com.caelum.vraptor.test;
import br.com.caelum.vraptor.loja.*;
import org.junit.Test;
import junit.framework.Assert;

public class CalculaValorTotalTeste {
	@Test
	public void testaListaVazia() {
		Pedido meuPedido = new Pedido();
		meuPedido.setNome("Félix Feliz");
		Assert.assertEquals(0., meuPedido.getValorTotal());
	}
	
	@Test
	public void testaListaComElementoUnico() {
		Pedido meuPedido = new Pedido();
		meuPedido.setNome("Bilbo Bolseiro");
		
		Item novoItem = new Item();
		novoItem.setDescricao("Um Anel");
		novoItem.setPreco(566698732178432147.7);
		novoItem.setQuantidade(1);
		
		meuPedido.adicionaItem(novoItem);
		Assert.assertEquals(566698732178432147.7, meuPedido.getValorTotal());
	}
	
	@Test
	public void testaListaComElementoMultiplo() {
		Pedido meuPedido = new Pedido();
		meuPedido.setNome("Garfield");
		
		Item novoItem = new Item();
		novoItem.setDescricao("lasanha");
		novoItem.setPreco(6.99);
		novoItem.setQuantidade(31);
		
		meuPedido.adicionaItem(novoItem);
		Assert.assertEquals(216.69, meuPedido.getValorTotal());
	}
	
	@Test
	public void testaListaComDoisElementosUnicos() {
		Pedido meuPedido = new Pedido();
		meuPedido.setNome("Xen Xun Xan");
		
		Item novoItem1 = new Item();
		novoItem1.setDescricao("yin");
		novoItem1.setPreco(48795135.5);
		novoItem1.setQuantidade(1);
		Item novoItem2 = new Item();
		novoItem2.setDescricao("yang");
		novoItem2.setPreco(48795136.6);
		novoItem2.setQuantidade(1);
		
		meuPedido.adicionaItem(novoItem1);
		meuPedido.adicionaItem(novoItem2);
		Assert.assertEquals(97590272.1, meuPedido.getValorTotal());
	}
	
	@Test
	public void testaListaComDoisElementosMultiplos() {
		Pedido meuPedido = new Pedido();
		meuPedido.setNome("Dona Maricota");
		
		Item novoItem1 = new Item();
		novoItem1.setDescricao("pera");
		novoItem1.setPreco(0.4);
		novoItem1.setQuantidade(25);
		meuPedido.adicionaItem(novoItem1);
		
		Item novoItem2 = new Item();
		novoItem2.setDescricao("amora");
		novoItem2.setPreco(0.2);
		novoItem2.setQuantidade(32);
		meuPedido.adicionaItem(novoItem2);
		
		Assert.assertEquals(16.4, meuPedido.getValorTotal());
	}
}