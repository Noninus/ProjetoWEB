<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 	<head>
 	<link rel="stylesheet" type="text/css" href="css/carinho.css">
 	</head>
          <body>
              <h2>Página inicial</h2> 	<a	href="logout">Sair	do	sistema</a>
              <p>Olá, ${usuarioLogado.login}!</p>
              
            <button class="myButton" onclick="window.location.href='listaAlunos'">Alunos</button>
			<button class="myButton" onclick="window.location.href='listaProfessor'">Professores</button>
		     <button class="myButton" onclick="window.location.href='bemvindo.jsp'">Funcionários</button>
             
          </body>
      </html>