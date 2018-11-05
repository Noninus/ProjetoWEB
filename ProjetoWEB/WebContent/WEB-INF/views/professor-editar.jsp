<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="br">
<head>
<meta charset="utf-8"/>

  <title>Editar ${tf.nome}</title>
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
  <h2>Editar Alunos</h2>
  <form class="form-horizontal" action="editaProfessor" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="nome">Nome:</label>
      <div class="col-sm-10">
        <input value ="${tf.nome}" type="text" class="form-control" id="email" placeholder="Digite seu e-mail" name="nome">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="cpf">CPF:</label>
      <div class="col-sm-10">    
        <input value ="${tf.cpf}" type="text" class="form-control" id="cpf" placeholder="Digite seu CPF" name="cpf">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="dataNascimentoString">Data Nascimento:</label>
      <div class="col-sm-10">
        <input value ="${tf.dataNascimento}" type="date" class="form-control" id="dataNascimentoString" name="dataNascimentoString">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="sexo">Sexo:</label>
      <div class="col-sm-10">
	  	<label class="radio-inline"><input type="radio" name="sexo" value="M" id="M">Masculino</label>
		<label class="radio-inline"><input type="radio" name="sexo" value="F" id="F">Feminino</label>
	  	
      </div>
    </div>
    
    

    <div class="form-group">
      <label class="control-label col-sm-2" for="endereco">Endereço:</label>
      <div class="col-sm-10">
        <input value ="${tf.endereco}" type="text" class="form-control" placeholder="Digite seu Endereço" id="endereco" name="endereco">
      </div>
    </div>
    <div class="form-group">
      <label  class="control-label col-sm-2" for="curso">Disciplina:</label>
      <div class="col-sm-10">
         <select id="disciplina" name="disciplina" class="form-control"> 
		    <option value="suc">Selecione uma Disciplina...</option> 
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
        <input value ="${tf.telefone}" type="text" class="form-control" placeholder="Digite seu Telefone" id="telefone" name="telefone">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="endereco">E-mail:</label>
      <div class="col-sm-10">
        <input value ="${tf.email}" type="text" class="form-control" placeholder="Digite seu E-mail" id="email" name="email">
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-6">
        <a class="btn btn-primary" href="listaProfessor" role="button">Voltar</a>
      </div>
        <div class="col-sm-offset1 col-sm-4">
        <button style="float: right;"  type="submit" class="btn btn-success">Alterar!</button>
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
<script>
document.getElementById('disciplina').value = '${tf.disciplina}';

if('${tf.sexo}' == 'M'){
	document.getElementById("M").checked = true;
}else{
	document.getElementById("F").checked = true;	
}
</script>
</html>
