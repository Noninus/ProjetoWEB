	 package pj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.org.glassfish.gmbal.NameValue;

@Entity
public class Aluno extends Pessoa {
	
	public String endereco;
	public String curso;
	public String telefone;
	public String email;
	@Id
	@GeneratedValue
	@Column(name="matricula_id")
	public int matricula;
	
	public Aluno(String endereco){
		this.endereco = endereco;
	}
	
	public Aluno(){

	}
	
	
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
