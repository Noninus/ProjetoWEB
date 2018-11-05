package pj.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.naming.NamingException;

import pj.db.BancoDados;
import pj.model.Aluno;

public class AlunoDAO {
	
	private BancoDados db = null;
	
	public AlunoDAO() {
		try {
			db = new BancoDados("sistemacadastro");
		} catch (NamingException e) {
			System.out.println("Erro ao instanciar o Banco de Dados: " + e);
		}
	}
	
	public void cadastrarAluno(Aluno aluno) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			sql.append("INSERT INTO aluno ");
			sql.append("VALUES(?,?,?,?,?,?,?,?,?)");

			stmt = conn.prepareStatement(sql.toString());

			stmt.setString(1, String.valueOf(aluno.getNome()));
			stmt.setString(2, String.valueOf(aluno.getCpf()));
			
			java.util.Date dt = aluno.getDataNascimento();
			Calendar c = Calendar.getInstance(); 
			c.setTime(dt); 
			c.add(Calendar.DATE, 1);
			dt = c.getTime();
			
			stmt.setDate(3, Date.valueOf(format.format(dt)));
			
			stmt.setString(4, String.valueOf(aluno.getSexo()));
			stmt.setString(5, String.valueOf(aluno.getEndereco()));
			stmt.setString(6, String.valueOf(aluno.getCurso()));
			stmt.setString(7, String.valueOf(aluno.getTelefone()));
			stmt.setString(8, String.valueOf(aluno.getEmail()));
			stmt.setString(9, String.valueOf(aluno.getMatricula()));	
			
			
			System.out.println(stmt);
			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no método cadastrarAluno - rollback");
				}
			}
			System.out.println("Erro no método cadastrarProfessor");
			e.printStackTrace();
		} finally {
			System.out.println(""+rs + stmt + conn + "");
			db.finalizaObjetos(rs, stmt, conn);
		}
		
		System.out.println("Professor " + aluno.getNome() + " da disciplina " + aluno.getCurso() + " cadastrado com sucesso!");
	}
	
	
	public void alterarAluno(Aluno aluno) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			sql.append("UPDATE aluno SET nome = ?, cpf = ?, data_nascimento = ?, sexo = ?, endereco = ?, curso = ?, telefone = ?,"
					+ "email = ?");
			sql.append(" WHERE matricula_id = ?;");
			
			

			stmt = conn.prepareStatement(sql.toString());
			
			stmt.setString(1, String.valueOf(aluno.getNome()));
			stmt.setString(2, String.valueOf(aluno.getCpf()));
			

			java.util.Date dt = aluno.getDataNascimento();
			Calendar c = Calendar.getInstance(); 
			c.setTime(dt); 
			c.add(Calendar.DATE, 1);
			dt = c.getTime();
			
			stmt.setDate(3, Date.valueOf(format.format(dt)));
			
			stmt.setString(4, String.valueOf(aluno.getSexo()));
			stmt.setString(5, String.valueOf(aluno.getEndereco()));
			stmt.setString(6, String.valueOf(aluno.getCurso()));
			stmt.setString(7, String.valueOf(aluno.getTelefone()));
			stmt.setString(8, String.valueOf(aluno.getEmail()));
			stmt.setString(9, String.valueOf(aluno.getMatricula()));
			
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
	
	public void removeAluno(Aluno aluno) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = db.obterConexao();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();
			
			sql.append("DELETE FROM aluno ");
			sql.append("WHERE matricula_id = ?;");
			
			

			stmt = conn.prepareStatement(sql.toString());
			
			stmt.setLong(1, aluno.getMatricula());
		
			
			//stmt.setInt(1, professor.getId());

			stmt.execute();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Erro no método removeAluno - rollback");
				}
			}
			System.out.println("Erro no método removeAluno");
			e.printStackTrace();
		} finally {
			db.finalizaObjetos(rs, stmt, conn);
		}
	}
	
	public Aluno consultarAluno(String matricula){
		BancoDados db = null;
		
		try {
			db = new BancoDados("sistemacadastro");// LOCALHOST
		} catch (NamingException e) {
			System.out.println("Erro ao instanciar o Banco de Dados: " + e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Aluno aluno = null;
		try {
			
			conn = db.obterConexao();

			String sql = "SELECT * FROM aluno WHERE matricula_id = "+matricula+" ;";

			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			int i = 1;
				rs.first();
				aluno = new Aluno();
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setDataNascimento(rs.getDate("data_nascimento"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setCurso(rs.getString("curso"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.setEmail(rs.getString("email"));
				aluno.setMatricula(rs.getInt("matricula_id"));


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
		return aluno;
	}
	
	public ArrayList<Aluno> listarAlunos(){
		BancoDados db = null;
		ArrayList<Aluno> listAluno = new ArrayList();
		
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

			String sql = "SELECT * FROM aluno;";

			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			int i = 1;
			while (rs.next()) {
				// stmt.executeUpdate();
				// conn.commit();
				Aluno aluno = new Aluno();
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setDataNascimento(rs.getDate("data_nascimento"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setCurso(rs.getString("curso"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.setEmail(rs.getString("email"));
				aluno.setMatricula(rs.getInt("matricula_id"));
				listAluno.add(aluno);
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
		return listAluno;
		
	}
}
