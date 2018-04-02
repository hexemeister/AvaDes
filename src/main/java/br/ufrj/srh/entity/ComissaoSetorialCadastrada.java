package br.ufrj.srh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ComissaoSetorialCadastrada {
	@Id
	@GeneratedValue
	private Long codigo;
	private String sigepe_representante_da_direcao;
	private String sigepe_integrante_da_area_de_pessoal;
	private String sigepe_tecnico_administrativo;
	private long codigo_da_unidade;
	private String periodo;

	private String situacao;

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getSigepe_representante_da_direcao() {
		return sigepe_representante_da_direcao;
	}

	public void setSigepe_representante_da_direcao(String sigepe_representante_da_direcao) {
		this.sigepe_representante_da_direcao = sigepe_representante_da_direcao;
	}

	public String getSigepe_integrante_da_area_de_pessoal() {
		return sigepe_integrante_da_area_de_pessoal;
	}

	public void setSigepe_integrante_da_area_de_pessoal(String sigepe_integrante_da_area_de_pessoal) {
		this.sigepe_integrante_da_area_de_pessoal = sigepe_integrante_da_area_de_pessoal;
	}

	public String getSigepe_tecnico_administrativo() {
		return sigepe_tecnico_administrativo;
	}

	public void setSigepe_tecnico_administrativo(String sigepe_tecnico_administrativo) {
		this.sigepe_tecnico_administrativo = sigepe_tecnico_administrativo;
	}

	public long getCodigo_da_unidade() {
		return codigo_da_unidade;
	}

	public void setCodigo_da_unidade(long codigo_da_unidade) {
		this.codigo_da_unidade = codigo_da_unidade;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

}
