package br.ufrj.srh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UnidadeExtendida {

	@Id
	@GeneratedValue
	private Long codigo;
	private String nome;

	private Long codigo_comissao;
	private String sigepe_representante_da_direcao;
	private String sigepe_integrante_da_area_de_pessoal;
	private String sigepe_tecnico_administrativo;

	public Long getCodigo() {
		return codigo;
	}

	public Long getCodigo_comissao() {
		return codigo_comissao;
	}

	public void setCodigo_comissao(Long codigo_comissao) {
		this.codigo_comissao = codigo_comissao;
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

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
