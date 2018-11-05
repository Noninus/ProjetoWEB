package pj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import pj.db.BancoDados;
import pj.model.Usuario;

public class UsuarioDAO {
	
	public Usuario consultarUsuario(String login){
		BancoDados db = null;
		
		try {
			db = new BancoDados("sistemacadastro");// LOCALHOST
		} catch (NamingException e) {
			System.out.println("Erro ao instanciar o Banco de Dados: " + e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario usuario = null;
		try {
			
			conn = db.obterConexao();

			String sql = "SELECT * FROM usuarios WHERE login = '"+login+"' ;";
			
			

			stmt = conn.prepareStatement(sql);
			
			if(login.isEmpty()){
				return new Usuario();
			}

			rs = stmt.executeQuery();

			int i = 1;
				rs.first();
				usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));


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
		return usuario;
	}

}
