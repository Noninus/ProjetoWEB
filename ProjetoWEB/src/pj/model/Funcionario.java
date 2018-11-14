package pj.model;

import java.util.ArrayList;

public class Funcionario extends Pessoa {
	
	public int cod_funcionario;
	public String endereco;
	public String cargo;
	public String disc;
	public double salario;
	public double valeAlimentacao;
	public double valeRefeicao;
	public double valeTransporte;
	public ArrayList<Filho> listaFilhos;
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
		//falta arrumar
		salario = salario.replaceAll(".","");
		salario = salario.replaceAll(",","");
		salario = salario.replaceAll("R$ ","");
		System.out.println(Double.parseDouble(salario));
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
