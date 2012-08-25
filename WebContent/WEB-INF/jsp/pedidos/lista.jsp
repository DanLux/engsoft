<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Cliente</th>
				<th>Data</th>
				<th>Qtd Itens</th>
				<th>Valor Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pedidoList}" var="pedido">
				<tr>
					<td>${pedido.nome }</td>
					<td>${pedido.data }</td>
					<td>${pedido.quantidade }</td>
					<td>${pedido.valorTotal }</td>
					<td><a href="listaItem?id=${pedido.id}">Detalhes</a></td>
					<td><a href="remove?id=${pedido.id}">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>