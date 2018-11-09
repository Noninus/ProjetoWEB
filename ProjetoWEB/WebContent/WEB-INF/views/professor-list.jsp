<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"	%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"	%>	
 <html>
 <head>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/perfect-scrollbar.css">
	
	
	<script language="Javascript">
function confirmacao(matricula) {
     var resposta = confirm("Deseja remover o professor "+matricula+"?");
 
     if (resposta == true) {
          window.location.href = "removeProfessor?cpf="+matricula;
     }
}
</script>
 <title>Professores List</title>

 </head>
      <body>   
      <form action=Menu>
		<input type="submit" value="< Voltar"/>
	</form>
          <div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110">
					<div class="table100-head">
						<table>
						
							<thead>
								<tr class="row100 head">

									<th class="cell100 column1">CPF</th>
									<th class="cell100 column2">Nome</th>
									<th class="cell100 column3">Data Nasc.</th>
									<th class="cell100 column4">Sexo</th>
									<th class="cell100 column5">Alterar</th>
									<th class="cell100 column6">Remover</th>
								</tr>
							</thead>
						</table>
					</div>     
					<div class="table100-body js-pscroll">
						<table>
							<tbody>
								<tr class="row100 body">
								 <c:forEach items="${professor}" var="professor">
					                  <tr>
					                    
										<td class="cell100 column1">${professor.cpf}</td>
										<td class="cell100 column2">${professor.nome}</td>
								 		<td class="cell100 column3">
					                      <fmt:formatDate  value="${professor.dataNascimento}" pattern="dd/MM/yyyy"/>
					                    </td>
										<td class="cell100 column4">${professor.sexo}</td>
					                    <td class="cell100 column5">
					                     <a href="editarProfessor?cpf=${professor.cpf}"><span class="glyphicon glyphicon-pencil"></span></a>
     									</td>
     									<td class="cell100 column6">
					                     <a href="javascript:func()" onclick="confirmacao('${professor.cpf}')"><span class="glyphicon glyphicon-remove"></span></a>
     									</td>
					                  </tr>
					             </c:forEach>
					             
					             <tr class="row100 body" style="background-color:#C3C9F8">
									<td class="cell100 column1">
										<a href="novoProfessor"><span class="glyphicon glyphicon-plus" style="color:#808080"></span></a>	
									</td>
									<td class="cell100 column2">
									<a href="novoProfessor"><span class="glyphicon glyphicon-plus" style="color:#808080"></span></a>
									</td>
									<td class="cell100 column3">
									<a href="novoProfessor"><span class="glyphicon glyphicon-plus" style="color:#808080"></span></a>
									</td>
									<td class="cell100 column4">
									<a href="novoProfessor"><span class="glyphicon glyphicon-plus" style="color:#808080"></span></a>
									</td>
									<td class="cell100 column5">
										<a href="novoProfessor"><span class="glyphicon glyphicon-plus" style="color:#808080"></span></a>
									</td>
									<td class="cell100 column6">
										<a href="novoProfessor"><span class="glyphicon glyphicon-plus" style="color:#808080"></span></a>
									</td>
								</tr>
							
								</tbody>
						</table>
					</div>
				</div>  
      </body>
      </html>