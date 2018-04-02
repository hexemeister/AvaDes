package br.ufrj.srh.beans;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.ufrj.srh.repository.ComissaoSetorialRepository;
import br.ufrj.srh.repository.PeriodoRepository;
import br.ufrj.srh.repository.ServidorRepository;
import br.ufrj.srh.repository.UnidadeRepository;
import br.ufrj.srh.entity.ComissaoSetorial;
import br.ufrj.srh.entity.ComissaoSetorialCadastrada;
import br.ufrj.srh.entity.Periodo;
import br.ufrj.srh.entity.Servidor;
import br.ufrj.srh.entity.UnidadeCadastradaX;
import br.ufrj.srh.entity.UnidadeExtendida;


@ViewScoped
@ManagedBean(name = "comissaosetorial")
public class ComissaoSetorialBean {
    
	
    //Perfil
	/* Existem dois tipos de perfils para acessar essa página. Membros da comissão central e outros.
	 * 
	 * Válido pr ao mesmo período;
	 * 
	 * - Membros da comissão central: podem editar 
	 * - Outros: podem apenas visualizar.
	 * 
	 * 
	 */
	
	
	@Autowired
	private Periodo periodoVigente;
	
	
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	private ComissaoSetorialCadastrada comissao_cadastrada;
	private List<ComissaoSetorialCadastrada> lista_de_comissoes_cadastrada;
	
	private UnidadeCadastradaX unidade_cadastrada;
	private List<UnidadeCadastradaX> lista_de_unidade_cadastrada;
	
	private String teste;
	private List<String> lista_de_teste;
	private List<String> lista_de_cargos;
	
	
	 private List<Servidor> servidores;
	 private List<Servidor> lista_de_servidores_da_unidade;
	 private Servidor servidor;    
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	
	 private Integer unidadeCompleta;
	 private Integer unidadeIncompleta;
	 private Integer unidadePendente;
		
	private String permissao;
	
	@Autowired
	private PeriodoRepository periodoRepository;
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@Autowired
	private ServidorRepository servidorRepository;
	
	@Autowired
	private ComissaoSetorialRepository comissaoSetorialRepository;
	
	public ComissaoSetorialBean() {
		this.periodoRepository = periodoRepository;
		this.unidadeRepository = unidadeRepository;
		this.servidorRepository= servidorRepository;
		this.comissaoSetorialRepository = comissaoSetorialRepository;
		inicializacao();
		
	}

	public void inicializacao() {
		
		//Tratamento de permissão.
		//Verificar se a pessoa logada é um mebro da comissão central.
		
		//this.permissao = ""
		
		lista_de_comissoes_cadastrada = new ArrayList<ComissaoSetorialCadastrada>();
		lista_de_unidade_cadastrada = new ArrayList<UnidadeCadastradaX>();
		lista_de_teste = new ArrayList<String>();
		lista_de_cargos = new ArrayList<String>();
		
		lista_de_cargos.add("Representante da direcão");
		lista_de_cargos.add("Integrante da área de pessoal");
		lista_de_cargos.add("Técnico administrativo");
		
		
		//Recupera da base de dados o periodo vigente.
//		PeriodoRepository daoP = new PeriodoRepository();
		System.out.println(periodoRepository.count());
		periodoVigente = periodoRepository.periodoVigente();
		System.out.println("-------------- "  + periodoVigente.getNome() );
			
		
//		UnidadeRepository daoU = new UnidadeRepository();
	//	ComissaoSetorialDAO daoCS = new ComissaoSetorialDAO();
	//	UnidadeExtendida  ue = new UnidadeExtendida();
	
		List<UnidadeExtendida> lista_de_UnidadeExtendida;
	//	List<UnidadeCadastrada> lista_de_UnidadeCadastrada;
		
		//Busca na base de dados todas as unidades cadastradas, tendo o retorno em um padrão extendido de unidade.
		lista_de_UnidadeExtendida = unidadeRepository.listar_UnidadeExtendida(this.periodoVigente.getCodigo());
		System.out.println("SIZE de unidades: " + lista_de_UnidadeExtendida.size());
		
		this.unidadeCompleta = 0;
		this.unidadeIncompleta = 0;
		this.unidadePendente = 0;
		
		//Tratando as informacoes sobre as comissoes cadastradas. Verificando se as comições estão completas, pendentes ou incompletas.
		for(int i=0;i<lista_de_UnidadeExtendida.size();i++) {
			int contatador_de_membros = 3;
			
			UnidadeCadastradaX cc = new UnidadeCadastradaX();
			
			cc.setCodigo((long) lista_de_UnidadeExtendida.get(i).getCodigo());
			cc.setNome(lista_de_UnidadeExtendida.get(i).getNome());
			
			if(lista_de_UnidadeExtendida.get(i).getCodigo_comissao() == null) {
				cc.setSituacao("Pendente");
				unidadePendente = unidadePendente +1;
			}else {
				if(lista_de_UnidadeExtendida.get(i).getSigepe_integrante_da_area_de_pessoal() == null) {contatador_de_membros=contatador_de_membros-1;}
				if(lista_de_UnidadeExtendida.get(i).getSigepe_representante_da_direcao() == null) {contatador_de_membros=contatador_de_membros-1;}
				if(lista_de_UnidadeExtendida.get(i).getSigepe_tecnico_administrativo() == null) {contatador_de_membros=contatador_de_membros-1;}
				
				if(contatador_de_membros == 3) {cc.setSituacao("Completa"); unidadeCompleta = unidadeCompleta +1;}
					else {cc.setSituacao("Incompleta"); unidadeIncompleta = unidadeIncompleta+1;}
				
			}
			
			//Acompanhamento de console.
			System.out.println("contatador: " + i);
			System.out.println("contatador_de_membros: " + contatador_de_membros);
			System.out.println("Situacao: " + cc.getSituacao());
			
			lista_de_unidade_cadastrada.add(cc);
			
			System.out.println("Situacao:unidadePendente " + unidadePendente);
		}
		
		
		this.teste = "inicio";
		
		
		 servidores = new ArrayList<Servidor>();
		 
		 
		
	}
	
	public Periodo getPeriodoVigente() {
		return periodoVigente;
	}


	public void setPeriodoVigente(Periodo periodoVigente) {
		periodoVigente = periodoVigente;
	}
	
	 public List<String> getLista_de_cargos() {
		return lista_de_cargos;
	}


	public void setLista_de_cargos(List<String> lista_de_cargos) {
		this.lista_de_cargos = lista_de_cargos;
	}


	public List<String> completeText(String query) {
	       
	        return this.lista_de_teste;
	    }
	
	 
	 public void onItemSelectServidor(SelectEvent event) {
		// Servidor s;
		// s = (Servidor) event.getObject();
		 
	   //     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", s.getNome()));
	    }
	
	
	 
	 
	 public List<Servidor> completeServidor(String query) {
		 lista_de_servidores_da_unidade = new ArrayList<Servidor>();
		 
//		 ServidorRepository daoS= new ServidorRepository();  
		 lista_de_servidores_da_unidade = servidorRepository.listar_tp10_like(query);
		 
		 return lista_de_servidores_da_unidade;
	  }
	 
	 
	 
		public List<Servidor> getLista_de_servidores_da_unidade() {
			return lista_de_servidores_da_unidade;
		}


		public void setLista_de_servidores_da_unidade(List<Servidor> lista_de_servidores_da_unidade) {
			this.lista_de_servidores_da_unidade = lista_de_servidores_da_unidade;
		}

	 
	 public List<Servidor> getServidores() {
		return servidores;
	}


	public void setServidores(List<Servidor> servidores) {
		this.servidores = servidores;
	}


	public Servidor getServidor() {
		return servidor;
	}


	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	
	public void cancelarComissao() {
		unidade_cadastrada = new UnidadeCadastradaX();
		 servidores.clear();
	}
	
	
	public void keyup_siape(int i){
		 System.out.println("Key Up " +i);
		///this.servidor_diretor = new Servidor();
	}
	
	
	public void salvarComissao() {

		System.out.println("Serviores size:" + this.servidores.size());	
		
		if(this.servidores.get(0).getSigepe()==null && this.servidores.get(1).getSigepe()==null  && this.servidores.get(2).getSigepe()==null) {
			
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Cadastro de comiss�o setorial", "Pelo menos uma das cadeiras da comissao deve ser preenchida para que possa ser salva."));

			return;
		
		}	
		
	
		//Verificar se os membros nao sao os mesmos.
		int servidor_repetido = 0;
		
		if(this.servidores.get(0).getSigepe()!=null && this.servidores.get(1).getSigepe()!=null ) {
			if(this.servidores.get(0).getSigepe().equals(this.servidores.get(1).getSigepe())) {
				servidor_repetido = servidor_repetido +1;
			}
		}
		
		if(this.servidores.get(0).getSigepe()!=null && this.servidores.get(2).getSigepe()!=null ) {
			if(this.servidores.get(0).getSigepe().equals(this.servidores.get(2).getSigepe())) {
				servidor_repetido = servidor_repetido +1;
			}
		}
		
	
		if(this.servidores.get(2).getSigepe()!=null && this.servidores.get(1).getSigepe()!=null ) {
			if(this.servidores.get(2).getSigepe().equals(this.servidores.get(1).getSigepe())) {
				servidor_repetido = servidor_repetido +1;
			}
		}
		
		
		if(servidor_repetido>0) {
			
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Cadastro de comiss�o setorial", " Um servidor nao pode ocupar duas cadeiras na comissao"));

			
			return;
		}
	
		
		
		LocalDate hoje = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = (Date) Date.from(hoje.atStartOfDay(defaultZoneId).toInstant());
		
		
//		ComissaoSetorialRepository dao = new ComissaoSetorialRepository();
		ComissaoSetorial cs = new ComissaoSetorial();
		
		System.out.println("unidade" + this.unidade_cadastrada.getCodigo());
		
		cs.setCodigo_da_unidade(this.unidade_cadastrada.getCodigo());
		cs.setData_de_criacao(date);
		cs.setPeriodo(this.periodoVigente.getCodigo());
		cs.setSiape_responsavel("1234567");
		
		System.out.println("-"+this.servidores.get(1).getSigepe()+"-");
		
		if(this.servidores.get(0).getSigepe()!=null) {
			cs.setSigepe_integrante_da_area_de_pessoal(this.servidores.get(0).getSigepe());
		}
		
		if(this.servidores.get(1).getSigepe()!="") {
			cs.setSigepe_representante_da_direcao(this.servidores.get(1).getSigepe());
		}
	
		if(this.servidores.get(2).getSigepe()!="" ) {
			System.out.println("entrou" +this.servidores.get(2).getSigepe() + "xxx" );
			
			
			
			cs.setSigepe_tecnico_administrativo(this.servidores.get(2).getSigepe());
		}
		
		comissaoSetorialRepository.save(cs);
		
		 FacesContext context = FacesContext.getCurrentInstance();
		 context.addMessage(null, new FacesMessage("Cadastro de comiss�o setorial", " Os dados foram salvos com suceso!"));

	
		 inicializacao();
		
	}	

	public List<UnidadeCadastradaX> completeUnidade(String query) {
		
		
//		UnidadeRepository daoU = new UnidadeRepository();
	//	UnidadeExtendida  ue = new UnidadeExtendida();
		List<UnidadeExtendida> lista_de_UnidadeExtendida;
//		List<UnidadeCadastrada> lista_de_UnidadeCadastrada;
		
		lista_de_UnidadeExtendida = unidadeRepository.listar_UnidadeExtendidaComplete(query,this.periodoVigente.getCodigo());
		System.out.println("SIZE de unidades: " + lista_de_UnidadeExtendida.size());
		
		//this.unidadeCompleta = 0;
		///this.unidadeIncompleta = 0;
		//this.unidadePendente = 0;
		
		
		
		lista_de_unidade_cadastrada.clear();
		//Tratando as informacoes sobre as comissoes cadastradas.
		for(int i=0;i<lista_de_UnidadeExtendida.size();i++) {
			int contatador_de_membros = 3;
			
			UnidadeCadastradaX cc = new UnidadeCadastradaX();
			
			cc.setCodigo((long) lista_de_UnidadeExtendida.get(i).getCodigo());
			cc.setNome(lista_de_UnidadeExtendida.get(i).getNome());
			
			if(lista_de_UnidadeExtendida.get(i).getCodigo_comissao() == null) {
				cc.setSituacao("Pendente");
				//unidadePendente = unidadePendente +1;
			}else {
				if(lista_de_UnidadeExtendida.get(i).getSigepe_integrante_da_area_de_pessoal() == null) {contatador_de_membros=contatador_de_membros-1;}
				if(lista_de_UnidadeExtendida.get(i).getSigepe_representante_da_direcao() == null) {contatador_de_membros=contatador_de_membros-1;}
				if(lista_de_UnidadeExtendida.get(i).getSigepe_tecnico_administrativo() == null) {contatador_de_membros=contatador_de_membros-1;}
				
				if(contatador_de_membros == 3) {cc.setSituacao("Completa"); 
				//unidadeCompleta = unidadeCompleta +1;
				}
				else {cc.setSituacao("Incompleta"); 
				//unidadeIncompleta = unidadeIncompleta +1;
				}
				
			}
			//ARRUMAR
			
			System.out.println("contatador: " + i);
			System.out.println("contatador_de_membros: " + contatador_de_membros);
			System.out.println("Situacao: " + cc.getSituacao());
			
			lista_de_unidade_cadastrada.add(cc);
		
		}
		
		return lista_de_unidade_cadastrada;
		
	    } 
	 
	 
	 
	public Integer getUnidadeCompleta() {
		return unidadeCompleta;
	}


	public void setUnidadeCompleta(Integer unidadeCompleta) {
		this.unidadeCompleta = unidadeCompleta;
	}


	public Integer getUnidadeIncompleta() {
		return unidadeIncompleta;
	}


	public void setUnidadeIncompleta(Integer unidadeIncompleta) {
		this.unidadeIncompleta = unidadeIncompleta;
	}


	public Integer getUnidadePendente() {
		return unidadePendente;
	}


	public void setUnidadePendente(Integer unidadePendente) {
		this.unidadePendente = unidadePendente;
	}


	public List<String> getLista_de_teste() {
		return lista_de_teste;
	}


	public void setLista_de_teste(List<String> lista_de_teste) {
		this.lista_de_teste = lista_de_teste;
	}


	public void unidadeSelecionada() {
		
		System.out.println("unidade selecionada: " + this.unidade_cadastrada.getCodigo());
//		UnidadeRepository daoU = new UnidadeRepository();
//		ServidorRepository daoS = new ServidorRepository();
		
		UnidadeExtendida ue = new UnidadeExtendida();
		ue= unidadeRepository.listar_UnidadeExtendidaFiltroUnidade(String.valueOf( this.unidade_cadastrada.getCodigo()),this.periodoVigente.getCodigo() ).get(0);
		
		
		servidores.clear();
		
		Servidor s = new Servidor();
		if(ue.getSigepe_integrante_da_area_de_pessoal()==null) {
			servidores.add(s);
		}
		else {
			s = servidorRepository.getOne(Long.parseLong(ue.getSigepe_integrante_da_area_de_pessoal()));
			servidores.add(s);	
		}
		
		
		
		s = new Servidor();
		if(ue.getSigepe_representante_da_direcao()==null) {
			servidores.add(s);
		}
		else {
			s = servidorRepository.getOne(Long.parseLong(ue.getSigepe_representante_da_direcao()));
			servidores.add(s);	
		}
		
		
		s = new Servidor();
		if(ue.getSigepe_tecnico_administrativo()==null) {
			servidores.add(s);
		}
		else {
			s = servidorRepository.getOne(Long.parseLong(ue.getSigepe_tecnico_administrativo()));
			servidores.add(s);	
		}
		
		
		
	}

	public String getTeste() {
		return teste;
	}


	public void setTeste(String teste) {
		this.teste = teste;
	}


	public UnidadeCadastradaX getUnidade_cadastrada() {
		return unidade_cadastrada;
	}

	public void setUnidade_cadastrada(UnidadeCadastradaX unidade_cadastrada) {
		this.unidade_cadastrada = unidade_cadastrada;
	}

	public List<UnidadeCadastradaX> getLista_de_unidade_cadastrada() {
		return lista_de_unidade_cadastrada;
	}

	public void setLista_de_unidade_cadastrada(List<UnidadeCadastradaX> lista_de_unidade_cadastrada) {
		this.lista_de_unidade_cadastrada = lista_de_unidade_cadastrada;
	}

	public ComissaoSetorialCadastrada getComissao_cadastrada() {
		return comissao_cadastrada;
	}

	public void setComissao_cadastrada(ComissaoSetorialCadastrada comissao_cadastrada) {
		this.comissao_cadastrada = comissao_cadastrada;
	}

	public List<ComissaoSetorialCadastrada> getLista_de_comissoes_cadastrada() {
		return lista_de_comissoes_cadastrada;
	}

	public void setLista_de_comissoes_cadastrada(List<ComissaoSetorialCadastrada> lista_de_comissoes_cadastrada) {
		this.lista_de_comissoes_cadastrada = lista_de_comissoes_cadastrada;
	}
	
}
