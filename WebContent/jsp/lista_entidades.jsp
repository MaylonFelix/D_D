<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
	<html lang="pt-BR">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lista Entidades</title>

			<!--  BootStrap -->
			<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" >
			<script type="text/javascript"	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
			
			<!-- jQuery -->
			<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>


</head>
<body>
	<h1>Entidades</h1>
	<div class="table-responsive">
	<table class="table table-hover table-bordered table-condensed">
		<!-- percorre contatos montando as linhas da tabela -->
		<tr><th>Id</th><th>Nome</th><th>Descrição</th><th>Remover</th></tr>
		<c:forEach var="entidade" items="${entidades}">
			<tr>
				<td>${entidade.id}</td>
				<td>${entidade.nome}</td>
				<c:choose>
					<c:when test="${not empty entidade.descricao}">
						<td>${entidade.descricao}</td>
					</c:when>
					<c:otherwise>
						<td><font color="red"> Nenhuma descrição informada</font></td>
					</c:otherwise>
				</c:choose>
				<td><a href="mvc?logica=RemoveEntidadeLogica&id=${entidade.id}">Remover</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<button
		onclick="window.location.href='${pageContext.request.contextPath}/jsp/cadastra_entidade_mvc.jsp'">Cadastra
		Entidade MVC</button>
	<br />

	<!--  
		<table border="1">
			<c:forEach var="entidader" items="${dao.lista}" varStatus="id">
				<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
					<td>${id.count}</td>
					<td>${entidader.nome}</td>
					<td>${entidader.descricao}</td>
				</tr>
			</c:forEach>
		</table>
	</table>

-->

</body>
</html>