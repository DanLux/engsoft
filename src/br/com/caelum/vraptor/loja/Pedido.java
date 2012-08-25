package br.com.caelum.vraptor.loja;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String data;
	private int quantidade = 0;
	private double valorTotal = 0;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<Item> itens = new ArrayList<Item>();

	public Pedido() {
		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
		this.data = formatarDate.format(data);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void adicionaItem(Item item) {
		this.itens.add(item);
		item.atualizaPrecoTotal();
		this.setQuantidade(this.quantidade + item.getQuantidade());
		this.calculaValorTotal();
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void calculaValorTotal() {
		double total = 0.;
		for (Item item : itens)
			total = total + item.getPrecoTotal();

		this.valorTotal = total;
	}
}
