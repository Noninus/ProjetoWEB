package pj.controller;

import java.util.ArrayList;

import pj.dao.AlunoDAO;
import pj.model.Aluno;

public class AlunoController {
	
	public boolean inserirAluno(Aluno aluno){
//		VerAluno.adicionarNaLista(aluno);
		AlunoDAO aDAO = new AlunoDAO();
		aDAO.cadastrarAluno(aluno);
//		VerAluno.aparecerTela(true);
//		VerAluno.adicionarListaPrimeiraAbertura();
		
	
		return true;
	}
	
	public boolean atualizarAluno(Aluno aluno){
		AlunoDAO aDAO = new AlunoDAO();
		aDAO.alterarAluno(aluno);
//		VerAluno.aparecerTela(true);
//		VerAluno.adicionarListaPrimeiraAbertura();
		
			
		return false;
	}
	
	public ArrayList<Aluno> consultarTodosAlunos(){
		AlunoDAO aDAO = new AlunoDAO();
		
		return aDAO.listarAlunos();
	}
	
	public Aluno consultarAluno(String matricula){
		AlunoDAO aDAO = new AlunoDAO();
		
		return aDAO.consultarAluno(matricula);
	}
	
	
	public boolean deletarAluno(Aluno aluno){
		
		return false;
	}


}
