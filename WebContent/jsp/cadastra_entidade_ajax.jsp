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

			<!-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/my_style.css"> -->

			<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" >	
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
			<!-- <script type="text/javascript"	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.0/jquery.min.js"></script> -->
			<script type="text/javascript"	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
			<script type="text/javascript"  charset="UTF-8" src="${pageContext.request.contextPath}/js/AjaxForm.js"></script>

		</head>
		<body>
			
			<h1>Cadastra Entidade Ajax</h1>
			
			<div id="feedback" class="alert alert-success alert-dismissable">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			</div>
			
			<div id="alert_placeholder"></div>
			
			<button id="alert" type="button">alert</button>
			
			
			<div class="bs-example">
    			<div class="alert alert-danger alert-error">
        		<a href="#" class="close" data-dismiss="alert">&times;</a>
        		<strong>Error!</strong> A problem has been occurred while submitting your data.
   				</div>
			</div>


			<form id="myAjaxRequestForm" name="cadastra_entidade" accept-charset="utf-8" action="${pageContext.request.contextPath}/CadastraEntidadeAjax">
				<label for="nome">Nome:</label><br /> 
				<input id="nome" name="nome"	placeholder="Digite o nome da entidade" size="50" autofocus  /><br />
				<label for="descricao">Descrição:</label><br />
				<textarea rows="3" cols="40" id="descricao" name="descricao" placeholder="Digite a descrição da entidade" ></textarea><br /> 
				<input type="button" value="Salvar" id="salvar" /> 
				<!--<input type="button" value="Teste" id="teste" />-->
			</form>
			<button  onclick="window.location.href='${pageContext.request.contextPath}/mvc?logica=ListaEntidadeLogica'">Lista Entidade</button> <br/> 
			<div id="anotherSection">
				<fieldset>
					<legend>Response from jQuery Ajax Request</legend>
					<div id="ajaxResponse"></div>
				</fieldset>
			</div>
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