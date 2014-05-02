<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
	<html lang="pt-BR">
		<!--
			LEMBRANDO-SE QUE O jsp DEVERÁ SEMPRE INICIAR COM ESTA LINHA  
			... page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" ...
		 -->
		<head>
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
    		<title>Cadastra Entidade</title>
    			
    		<!-- Meu estilo -->
    		<!-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/my_style.css"> -->
    		
    		<!--  BootStrap -->
			<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" >
			<script type="text/javascript"	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
			
			<!-- jQuery -->
			<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
			
			<!-- jQuery UI 
			<link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/smoothness/jquery-ui.css" />
			<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
			
			 Tema do jQueryUI 
			<!--  <link rel="stylesheet" href="<%=request.getContextPath()%>/jquery-ui/css/hot-sneaks/jquery-ui-1.10.4.custom.css" />
			<script src="<%=request.getContextPath()%>/jquery-ui/js/jquery-1.10.2.js"></script>
			<script src="<%=request.getContextPath()%>/jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>
			<script src="<%=request.getContextPath()%>/jquery-ui/js/jquery-ui-1.10.4.custom.min.js"></script>	-->

			<!-- <script type="text/javascript"	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.0/jquery.min.js"></script> -->
			
<script type="text/javascript"> 



</script>
		</head>
		<body>
			<h1>Cadastra Entidade MVC</h1>
			
			<form  id="myAjaxRequestForm" name="cadastra_entidade" accept-charset="utf-8" action="${pageContext.request.contextPath}/mvc" method="post" >
				
				<label for="nome">Nome:</label><br /> 
				<input id="nome" name="nome"	placeholder="Digite o nome da entidade" size="50" autofocus  /><br/>
				
				<label for="descricao">Descrição:</label><br />
				<textarea rows="3" cols="40" id="descricao" name="descricao" placeholder="Digite a descrição da entidade" ></textarea><br /> 
				<input type="submit" value="Salvar" id="salvar" />
			 	<input type="hidden" value="CadastraEntidadeLogica" name="logica" id="logica" class="ui-button "/>
			 	
			 	
			</form><br/>
			
			
			<button  onclick="window.location.href='${pageContext.request.contextPath}/mvc?logica=ListaEntidadeLogica'">Lista Entidade</button> <br/>
			<button onclick="window.location.href='${pageContext.request.contextPath}/jsp/cadastra_entidade_ajax.jsp'">Cadastra Entidade Ajax</button><br/>
			<br /> 
			<br /> 
			
		</body>
		<!-- 
		<script>
		$( "#salvar" ).click(function( event ) {
		  event.preventDefault();
		  $( "#anotherSection" ).append( "default " + event.type + " prevented" ).appendTo( "#log" );
		});
		</script>
		 -->
	</html>