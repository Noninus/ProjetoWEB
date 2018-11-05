package pj.model;

import java.util.ArrayList;

public class Funcionario extends Pessoa {
	
	public int codigoCadastro;
	public String endereco;
	public String cargo;
	public String disc;
	public String salario;
	public String valeAlimentacao;
	public String valeRefeicao;
	public String valeTransporte;
	public int qtdFilhos;
	public ArrayList<Filho> listaFilhos;
	public String telefone;
	public String email;
	
	
	public int getCodigoCadastro() {
		return codigoCadastro;
	}
	public void setCodigoCadastro(int codigoCadastro) {
		this.codigoCadastro = codigoCadastro;
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
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	public String getValeAlimentacao() {
		return valeAlimentacao;
	}
	public void setValeAlimentacao(String valeAlimentacao) {
		this.valeAlimentacao = valeAlimentacao;
	}
	public String getValeRefeicao() {
		return valeRefeicao;
	}
	public void setValeRefeicao(String valeRefeicao) {
		this.valeRefeicao = valeRefeicao;
	}
	public String getValeTransporte() {
		return valeTransporte;
	}
	public void setValeTransporte(String valeTransporte) {
		this.valeTransporte = valeTransporte;
	}
	public int getQtdFilhos() {
		return qtdFilhos;
	}
	public void setQtdFilhos(int qtdFilhos) {
		this.qtdFilhos = qtdFilhos;
	}
	public ArrayList<Filho> getListaFilhos() {
		return listaFilhos;
	}
	public void setListaFilhos(ArrayList<Filho> listaFilhos) {
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
