<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="br.com.pix.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastra Entidade</title>


	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" >		
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<!-- <script type="text/javascript"	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.0/jquery.min.js"></script> -->
	<script type="text/javascript"	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<h1>Resultado Cadastra Entidade</h1>
	<p class="result">Entidade ${entidade.nome} cadastrada com sucesso!</p>
	<br />

	<button
		onclick="window.location.href='${pageContext.request.contextPath}/mvc?logica=ListaEntidadeLogica'">Lista
		Entidade</button>
	<br />

</body>
</html>