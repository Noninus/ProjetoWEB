package pj.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Filho {
	
	public Filho(String nome, Date dataNascimento, int cod_funcionario){
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cod_funcionario = cod_funcionario;
	}
	
	public Filho(){}
	

	public String nome;
	public Date dataNascimento;
	public String dataNascimentoStr;
	public int cod_funcionario;

	public int getCod_funcionario() {
		return cod_funcionario;
	}
	public void setCod_funcionario(int cod_funcionario) {
		this.cod_funcionario = cod_funcionario;
	}
	public String getDataNascimentoStr() {
		return dataNascimentoStr;
	}
	public void setDataNascimentoStr(String dataNascimentoStr) {
		this.dataNascimentoStr = dataNascimentoStr;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		if(getDataNascimentoStr() != null){
			return converterData(getDataNascimentoStr());
		}else{
			return dataNascimento;
		}
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Date converterData(String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		try {
			return sdf.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	

}
