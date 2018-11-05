<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="br">
<head>
<meta charset="utf-8"/>

  <title>Cadastro Aluno</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
	<script>
	    $(document).ready(function () { 
	    	  $('#cpf').mask('000.000.000-00', {reverse: true});
	    	  $('#telefone').mask('(00) 0 0000-0000');
	    });
	</script>
</head>
<body>

<div class="container">
  <h2>Cadastro de Alunos</h2>
  <form class="form-horizontal" action="adicionaAluno" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="nome">Nome:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="email" placeholder="Digite seu e-mail" name="nome">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="cpf">CPF:</label>
      <div class="col-sm-10">    
        <input type="text" class="form-control" id="cpf" placeholder="Digite seu CPF" name="cpf">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="dataNascimentoString">Data Nascimento:</label>
      <div class="col-sm-10">
        <input type="date" class="form-control" id="dataNascimentoString" name="dataNascimentoString">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="sexo">Sexo:</label>
      <div class="col-sm-10">
	  	<label class="radio-inline"><input type="radio" name="sexo" value="M">Masculino</label>
		<label class="radio-inline"><input type="radio" name="sexo" value="F">Feminino</label>
	  	
      </div>
    </div>
    
    

    <div class="form-group">
      <label class="control-label col-sm-2" for="endereco">Endereço:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" placeholder="Digite seu Endereço" id="endereco" name="endereco">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="dataNascimentoString">Curso:</label>
      <div class="col-sm-10">
         <select name="curso" class="form-control"> 
		    <option value="suc">Selecione um Curso...</option> 
		    <option value="Java">Java</option> 
		    <option value=".NET">.NET</option> 
		    <option value="Spring Boot">Spring Boot</option> 
		    <option value="Front-End">Front-End</option> 
		    <option value="Back-End">Back-End</option> 
		   </select>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="telefone">Telefone:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" placeholder="Digite seu Telefone" id="telefone" name="telefone">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="endereco">E-mail:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" placeholder="Digite seu E-mail" id="email" name="email">
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-6">
        <a class="btn btn-primary" href="listaAlunos" role="button">Voltar</a>
        <input type="reset" class="btn btn-secondary"  value="Limpar">
      </div>
        <div class="col-sm-offset1 col-sm-4">
        <button style="float: right;"  type="submit" class="btn btn-success">Cadastrar!</button>
      </div>
    </div>
    

    
   
    
    
    
  </form>
      <form action=listaAlunos>
		 <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
     	
      </div>
    </div>
  </form>
</div>

</body>
</html>
