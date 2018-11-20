package pj.controller;

import pj.dao.AlunoDAO;
import pj.dao.FuncionarioDAO;
import pj.dao.UsuarioDAO;
import pj.model.Aluno;
import pj.model.Filho;
import pj.model.Funcionario;
import pj.model.Usuario;
import pj.utils.Cpf;
import pj.utils.Utils;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaginaController {
	

	
	 
	 
	 @RequestMapping("Menu")
	 public String teste() {
	  return "menu";
	 }
	 
	 

	
	public boolean existeUsuario(Usuario usuario) {
		UsuarioDAO uDAO = new UsuarioDAO();
		Usuario verificacao = uDAO.consultarUsuario(usuario.getLogin());
		
		if(usuario.getSenha().isEmpty() || usuario.getLogin().isEmpty()){
			return false;
		}
		
		if(verificacao.getSenha().equals(usuario.getSenha())){
			return true;
		}
		return false;
	}
 

 
}