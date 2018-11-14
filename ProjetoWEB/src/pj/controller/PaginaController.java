package pj.controller;

import pj.dao.AlunoDAO;
import pj.dao.FuncionarioDAO;
import pj.dao.ProfessorDAO;
import pj.dao.UsuarioDAO;
import pj.model.Aluno;
import pj.model.Filho;
import pj.model.Funcionario;
import pj.model.Professor;
import pj.model.Usuario;
import pj.utils.Cpf;
import pj.utils.Utils;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaginaController {
 
 @RequestMapping("removeAluno")
 public String remove(Aluno aluno) {
  AlunoDAO dao = new AlunoDAO();
  
  dao.removeAluno(aluno);
  return "redirect:listaAlunos";
 }

 
 @RequestMapping("novoAluno")
 public String form() {
  return "alunos-cadastro";
 }
 
 @RequestMapping("editarAluno")
 public String editar(String id, Model model) {
  AlunoDAO dao = new AlunoDAO();
  model.addAttribute("id", id);
  Aluno tf = dao.consultarAluno(id);
  model.addAttribute("tf", tf);
  return "alunos-editar";
 }
 
 
 @RequestMapping("Menu")
 public String teste() {
  return "menu";
 }
 
 @RequestMapping("adicionaAluno")
 public String adiciona(Aluno aluno) {
  Cpf cpf = new Cpf();
  
  
  
  if (!cpf.isValid(aluno.getCpf())){
	  System.out.println("Erro CPF");
   return "redirect:novoAluno";
  }
  
  AlunoDAO dao = new AlunoDAO();
  try {
   dao.cadastrarAluno(aluno);   
  } catch (Exception e) {
   System.out.println(e);

  }
  return "redirect:listaAlunos";
 }
 
 
 @RequestMapping("editaAluno")
 public String edita(Aluno aluno) throws Exception {
  AlunoDAO dao = new AlunoDAO();
  dao.alterarAluno(aluno);
  return "redirect:listaAlunos";
 }
 
 
 @RequestMapping("listaAlunos")
 public String lista(Model model) {
  AlunoDAO dao = new AlunoDAO();
  model.addAttribute("alunos", dao.listarAlunos());
  return "alunos-list";
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

@RequestMapping("removeProfessor")
public String removeProfessor(Professor professor) {
 ProfessorDAO dao = new ProfessorDAO();
 
 dao.removerProfessor(professor);
 return "redirect:listaProfessor";
}


@RequestMapping("novoProfessor")
public String novoProfessor() {
 return "professor-cadastro";
}

@RequestMapping("editarProfessor")
public String editarProfessor(String cpf, Model model) {
 ProfessorDAO dao = new ProfessorDAO();
 model.addAttribute("cpf", cpf);
 Professor tf = dao.consultarProfessor(cpf);
 model.addAttribute("tf", tf);
 return "professor-editar";
}


@RequestMapping("adicionaProfessor")
public String adicionaProfessor(Professor professor) {
 Cpf cpf = new Cpf();
System.out.println("passeiporaq");
 
 if (!cpf.isValid(professor.getCpf())){
  return "redirect:novoProfessor";
 }
 
 ProfessorDAO dao = new ProfessorDAO();
 try {
  dao.cadastrarProfessor(professor);   
 } catch (Exception e) {
  System.out.println(e);

 }
 return "redirect:listaProfessor";
}


@RequestMapping("editaProfessor")
public String editaAluno(Professor professor) throws Exception {
	ProfessorDAO dao = new ProfessorDAO();
	dao.alterarProfessor(professor);
 return "redirect:listaProfessor";
}


@RequestMapping("listaProfessor")
public String listaProfessor(Model model) {
 ProfessorDAO dao = new ProfessorDAO();
 model.addAttribute("professor", dao.listarProfessor());
 return "professor-list";
}








@RequestMapping("removeFuncionario")
public String removeFuncionario(Professor professor) {
 ProfessorDAO dao = new ProfessorDAO();
 
 dao.removerProfessor(professor);
 return "redirect:listaProfessor";
}


@RequestMapping("novoFuncionario")
public String novoFuncionario() {
 return "funcionario-cadastro";
}

@RequestMapping("editarFuncionario")
public String editarFuncionario(String cpf, Model model) {
 ProfessorDAO dao = new ProfessorDAO();
 model.addAttribute("cpf", cpf);
 Professor tf = dao.consultarProfessor(cpf);
 model.addAttribute("tf", tf);
 return "professor-editar";
}


@RequestMapping("adicionaFuncionario")
public String adicionaFuncionario(Funcionario funcionario, String[] nomesFilhos, String[] datasFilhos) {
 Cpf cpf = new Cpf();
 Utils util = new Utils();
 
 
 
 System.out.println(nomesFilhos.length);
 
 ArrayList<Filho> listFilhos = new ArrayList<Filho>();
for(int i = 0; i < nomesFilhos.length; i++){
	listFilhos.add(new Filho(nomesFilhos[i], util.formatarStringParaDate(datasFilhos[i]), funcionario.getCod_funcionario()));
}

if(!listFilhos.isEmpty()){
	funcionario.setListaFilhos(listFilhos);
}
 
 
 if (!cpf.isValid(funcionario.getCpf())){
  return "redirect:novoFuncionario";
 }
 
 FuncionarioDAO dao = new FuncionarioDAO();
 try {
  dao.cadastrarFuncionario(funcionario);   
 } catch (Exception e) {
  System.out.println(e);

 }
 return "redirect:listaFuncionario";
}


@RequestMapping("editaFuncionario")
public String editaFuncionario(Professor professor) throws Exception {
	ProfessorDAO dao = new ProfessorDAO();
	dao.alterarProfessor(professor);
 return "redirect:listaProfessor";
}


@RequestMapping("listaFuncionario")
public String listaFuncionario(Model model) {
 ProfessorDAO dao = new ProfessorDAO();
 model.addAttribute("professor", dao.listarProfessor());
 return "funcionario-list";
}

 
 
}