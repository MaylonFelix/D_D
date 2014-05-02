<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
	<html lang="pt-BR">
		<!--
			LEMBRANDO-SE QUE O jsp DEVERÁ SEMPRE INICIAR COM ESTA LINHA  
			... page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" ...
		 -->
		<head>
			<meta charset="utf-8">
    		<title>Cadastra Entidade</title>

			<script type="text/javascript"	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.0/jquery.min.js"></script>

		</head>
		<body>
			<h1>Cadastra Entidade<h1 />
			<form id="myAjaxRequestForm" name="cadastra_entidade" accept-charset="utf-8" action="CadastraEntidade">
				Nome:<br /> 
				<input id="nome" name="nome"	placeholder="Digite o nome da entidade" size="50" autofocus  /><br />
				Descrição:<br />
				<textarea rows="3" cols="40" id="descricao" name="descricao" placeholder="Digite a descrição da entidade" ></textarea><br /> 
				<br /> 
				<input type="submit" value="Salvar" id="salvar" /> 
			</form><br/>
			<button onclick="window.location.href='mvc?logica=ListaEntidadeLogica'">Lista Entidades</button>
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