<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Cadastra</title>
</head>
<body>
	<p>Cliente: ${pedido.nome}</p>
	<p>Data: ${pedido.data}</p>
	</br>

	<form action="adicionaItem">
		<fieldset>
			<legend>Adicionar Itens</legend>
			<label for="descricao">Descri&ccedil;&atilde;o</label>
			<textarea id="descricao" name="item.descricao"> ${item.descricao }</textarea>

			<label for="preco">Pre&ccedil;o</label> <input id="preco"
				type="text" name="item.preco" value="${item.preco }" /> <label
				for="quantidade">Quantidade</label> <input type="text"
				id="quantidade" name="item.quantidade" value="${item.quantidade }" />

			<input id="id" type="hidden"
				name="id" value="${pedido.id }" />
			<button type="submit">Adicionar</button>
		</fieldset>
	</form>
	
	</br>
	<table>
		<thead>
			<tr>
				<th>Descri&ccedil;&atilde;o</th>
				<th>Quantidade</th>
				<th>Pre&ccedil;o</th>
				<th>Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pedido.itens}" var="item">
				<tr>
					<td>${item.descricao }</td>
					<td>${item.quantidade }</td>
					<td>${item.preco }</td>
					<td>${item.precoTotal }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>