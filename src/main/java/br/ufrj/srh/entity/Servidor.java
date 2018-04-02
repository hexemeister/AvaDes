package br.ufrj.srh.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Servidor {
	private String nome;
	@Id
	private String sigepe;
	private String cargo;
	private String localizacao;
	private int carga_horaria;
	private Date data_de_admissao;
	private String pcc_tae;
	private String titulacao;
	private String regime;
	private String funcao;

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigepe() {
		return sigepe;
	}

	public void setSigepe(String sigepe) {
		this.sigepe = sigepe;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public int getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(int carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	public String getData_de_admissao() {
		String date;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		date = formatter.format(this.data_de_admissao);
		return date;

	}

	public void setData_de_admissao(String data_de_admissao) {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = formatter.parse(data_de_admissao);
			this.data_de_admissao = date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// this.data_de_inicio = null;
		}

	}

	public String getPcc_tae() {
		return pcc_tae;
	}

	public void setPcc_tae(String pcc_tae) {
		this.pcc_tae = pcc_tae;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public String getRegime() {
		return regime;
	}

	public void setRegime(String regime) {
		this.regime = regime;
	}
}
