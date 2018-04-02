package br.ufrj.srh.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ComissaoSetorial", schema = "public")
public class ComissaoSetorial {
	@Id
	@SequenceGenerator(name = "Sequencia_CC", sequenceName = "seq_cc", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Sequencia_CC")
	private Long codigo;
	private String sigepe_representante_da_direcao;
	private String sigepe_integrante_da_area_de_pessoal;
	private String sigepe_tecnico_administrativo;
	private long codigo_da_unidade;
	private long periodo;
	private Date data_de_criacao;
	private String siape_responsavel;

	public Date getData_de_criacao() {
		return data_de_criacao;
	}

	public void setData_de_criacao(Date data_de_criacao) {
		this.data_de_criacao = data_de_criacao;
	}

	public String getSiape_responsavel() {
		return siape_responsavel;
	}

	public void setSiape_responsavel(String siape_responsavel) {
		this.siape_responsavel = siape_responsavel;
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

	public Long getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Long periodo) {
		this.periodo = periodo;
	}

}
