package pj.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.naming.NamingException;

import pj.db.BancoDados;
import pj.model.Aluno;
import pj.model.Professor;
import pj.model.Professor;

public class ProfessorDAO {
	
	private BancoDados db = null;
	
	public ProfessorDAO() {
		try {
			db = new BancoDados("sistemacadastro");
		} catch (NamingException e) {
			System.out.println("Erro ao instanciar o Banco de Dados: " + e);
		}
	}
	
	public void cadastrarProfessor(Professor professor) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO professor ");
			sql.append("VALUES(?,?,?,?,?,?,?,?)");

			stmt = conn.prepareStatement(sql.toString());

			stmt.setString(1, String.valueOf(professor.getNome()));
			stmt.setString(2, String.valueOf(professor.getCpf()));
			stmt.setDate(3, Date.valueOf(format.format(professor.getDataNascimento())));
			
			stmt.setString(4, String.valueOf(professor.getSexo()));
			stmt.setString(5, String.valueOf(professor.getEndereco()));
			stmt.setString(6, String.valueOf(professor.getDisciplina()));
			stmt.setString(7, String.valueOf(professor.getTelefone()));
			stmt.setString(8, String.valueOf(professor.getEmail()));


			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no método cadastrarProfessor - rollback");
				}
			}
			System.out.println("Erro no método cadastrarProfessor");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		
		System.out.println("Professor " + professor.getNome() + " da disciplina " + professor.getDisciplina() + " cadastrado com sucesso!");
	}
	
	
	public Professor consultarProfessor(String cpf){
		BancoDados db = null;
		
		try {
			db = new BancoDados("sistemacadastro");// LOCALHOST
		} catch (NamingException e) {
			System.out.println("Erro ao instanciar o Banco de Dados: " + e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Professor professor = null;
		try {
			
			conn = db.obterConexao();

			String sql = "SELECT * FROM professor WHERE cpf = '"+cpf+"' ;";

			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			int i = 1;
				rs.first();
				professor = new Professor();
				professor.setNome(rs.getString("nome"));
				professor.setCpf(rs.getString("cpf"));
				professor.setDataNascimento(rs.getDate("data_nascimento"));
				professor.setSexo(rs.getString("sexo"));
				professor.setEndereco(rs.getString("endereco"));
				professor.setDisciplina(rs.getString("disciplina"));
				professor.setTelefone(rs.getString("telefone"));
				professor.setEmail(rs.getString("email"));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		return professor;
	}
	
	public void alterarProfessor(Professor professor) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			sql.append("UPDATE professor SET nome = ?, data_nascimento = ?, sexo = ?, endereco = ?, disciplina = ?, telefone = ?,"
					+ "email = ?");
			sql.append(" WHERE cpf = ?;");

			stmt = conn.prepareStatement(sql.toString());
			
			stmt.setString(1, String.valueOf(professor.getNome()));
			

			java.util.Date dt = professor.getDataNascimento();
			Calendar c = Calendar.getInstance(); 
			c.setTime(dt); 
			c.add(Calendar.DATE, 1);
			dt = c.getTime();
			
			stmt.setDate(2, Date.valueOf(format.format(dt)));
			
			stmt.setString(3, String.valueOf(professor.getSexo()));
			stmt.setString(4, String.valueOf(professor.getEndereco()));
			stmt.setString(5, String.valueOf(professor.getDisciplina()));
			stmt.setString(6, String.valueOf(professor.getTelefone()));
			stmt.setString(7, String.valueOf(professor.getEmail()));
			stmt.setString(8, String.valueOf(professor.getCpf()));
			
			
			//stmt.setInt(1, professor.getId());

			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no método alterarProfessor - rollback");
				}
			}
			System.out.println("Erro no método alterarProfessor");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
	}	
	
	public ArrayList<Professor> listarProfessor(){
		BancoDados db = null;
		ArrayList<Professor> listProfessor = new ArrayList();
		
		try {
			db = new BancoDados("sistemacadastro");// LOCALHOST
		} catch (NamingException e) {
			System.out.println("Erro ao instanciar o Banco de Dados: " + e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {

			conn = db.obterConexao();

			String sql = "SELECT * FROM professor;";

			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			int i = 1;
			while (rs.next()) {
				// stmt.executeUpdate();
				// conn.commit();
				Professor professor = new Professor();
				professor.setNome(rs.getString("nome"));
				professor.setCpf(rs.getString("cpf"));
				professor.setDataNascimento(rs.getDate("data_nascimento"));
				professor.setSexo(rs.getString("sexo"));
				professor.setEndereco(rs.getString("endereco"));
				professor.setDisciplina(rs.getString("disciplina"));
				professor.setTelefone(rs.getString("telefone"));
				professor.setEmail(rs.getString("email"));
				listProfessor.add(professor);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
		return listProfessor;
		
	}
	
	public void removerProfessor(Professor professor) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			sql.append("DELETE FROM professor ");
			sql.append("WHERE cpf = ?;");
			
			

			stmt = conn.prepareStatement(sql.toString());
			
			stmt.setString(1, professor.getCpf());
		
			
			//stmt.setInt(1, professor.getId());

			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no método removeProfessor - rollback");
				}
			}
			System.out.println("Erro no método removeAluno");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
	}
	
}
