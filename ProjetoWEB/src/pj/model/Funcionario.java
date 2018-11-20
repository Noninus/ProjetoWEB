package pj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="funcionario")
public class Funcionario extends Pessoa {
	
	@Id
	@GeneratedValue
	public int cod_funcionario;
	public String endereco;
	public String cargo;
	@Column(name= "disciplina")
	public String disc;
	public double salario;
	
	@Column(name= "vale_alimentacao")
	public double valeAlimentacao;
	
	@Column(name= "vale_refeicao")
	public double valeRefeicao;
	
	@Column(name= "vale_transporte")
	public double valeTransporte;
	
	@OneToMany(mappedBy="funcionario", targetEntity=Filho.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public List<Filho> listaFilhos;
	public String telefone;
	public String email;
	
	

	public int getCod_funcionario() {
		return cod_funcionario;
	}
	public void setCod_funcionario(int cod_funcionario) {
		this.cod_funcionario = cod_funcionario;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
//		salario.replace(",", ".");
//		salario.replace("R", "");
//		salario.replace("$", "");
//		salario.replace(" ", "");
		System.out.println("aaaaaa" + salario);
		this.salario = Double.parseDouble(salario);
	}
	public double getValeAlimentacao() {
		return valeAlimentacao;
	}
	public void setValeAlimentacao(double valeAlimentacao) {
		this.valeAlimentacao = valeAlimentacao;
	}
	public double getValeRefeicao() {
		return valeRefeicao;
	}
	public void setValeRefeicao(double valeRefeicao) {
		this.valeRefeicao = valeRefeicao;
	}
	public double getValeTransporte() {
		return valeTransporte;
	}
	public void setValeTransporte(double valeTransporte) {
		this.valeTransporte = valeTransporte;
	}
	public List<Filho> getListaFilhos() {
		return listaFilhos;
	}
	public void setListaFilhos(List<Filho> listaFilhos) {
		this.listaFilhos = listaFilhos;
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
	
	public String getDisc() {
		return disc;
	}
	public void setDisc(String disc) {
		this.disc = disc;
	}
}
