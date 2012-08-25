<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Lista item</title>
</head>
<body>
	<p>Cliente: ${pedido.nome}</p>
	<p>Data: ${pedido.data}</p>
	<p>Valor Total: ${pedido.valorTotal}</p>
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