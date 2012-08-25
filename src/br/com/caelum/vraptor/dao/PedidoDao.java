package br.com.caelum.vraptor.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.loja.Item;
import br.com.caelum.vraptor.loja.Pedido;

@Component
public class PedidoDao {
	private final Session session;

	public PedidoDao(Session session) {
		this.session = session;
	}

	public void salva(Pedido pedido) {
		Transaction tx = session.beginTransaction();
		session.save(pedido);
		tx.commit();
	}
	
	public Pedido carrega(Long id) {
	    return (Pedido) this.session.load(Pedido.class, id);
	}
	
	public void atualiza(Pedido pedido) {
	    Transaction tx = session.beginTransaction();
	    this.session.update(pedido);
	    tx.commit();
	}
	public void remove(Pedido pedido) {
	    Transaction tx = session.beginTransaction();
	    this.session.delete(pedido);
	    tx.commit();
	}

	public List<Pedido> listaTudo() {
		return this.session.createCriteria(Pedido.class).list();
	}
}
