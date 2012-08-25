package br.com.caelum.vraptor.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.dao.PedidoDao;
import br.com.caelum.vraptor.loja.Item;
import br.com.caelum.vraptor.loja.Pedido;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class PedidosController {
	private final Result result;
	private final PedidoDao dao;
	private final Validator validator;

	public PedidosController(PedidoDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	public List<Pedido> lista() {
		return dao.listaTudo();
	}

	public Pedido listaItem(Long id) {
		Pedido pedido = dao.carrega(id);
		return pedido;
	}

	public void adiciona(final Pedido pedido) {
		if (pedido.getNome() == null) {
			validator.add(new ValidationMessage(
					"Cliente cadastrado deve possuir nome.", null));
		}
		validator.onErrorUsePageOf(PedidosController.class).formulario();
		dao.salva(pedido);
		result.redirectTo(this).cadastraItem(pedido.getId());
	}

	public Pedido cadastraItem(Long id) {
		return dao.carrega(id);
	}

	public void formulario() {
	}

	public void adicionaItem(Long id, final Item item) {
		/*
		 * if (item.getDescricao() == null || item.getDescricao().length() < 3
		 * || item.getDescricao().length() > 50) { validator.add(new
		 * ValidationMessage(
		 * "Item adicionado deve possuir descrição. Limite de 50 caracteres.",
		 * null)); } else if (item.getPreco() == null || item.getPreco() <= 0) {
		 * validator.add(new ValidationMessage(
		 * "Item adicionado deve possuir preço positivo.", null)); }
		 * 
		 * else if (item.getQuantidade() <= 0) { validator.add(new
		 * ValidationMessage(
		 * "Item adicionado deve possuir quantidade positiva.", null)); }
		 * validator.onErrorUsePageOf(PedidosController.class)
		 * .cadastraItem(id);
		 */

		Pedido pedido = dao.carrega(id);
		item.setPedido(pedido);
		pedido.adicionaItem(item);
		dao.atualiza(pedido);
		result.redirectTo(this).cadastraItem(id);
	}

	public void remove(Long id) {
		Pedido pedido = dao.carrega(id);
		dao.remove(pedido);
		result.redirectTo(this).lista();
	}
}
