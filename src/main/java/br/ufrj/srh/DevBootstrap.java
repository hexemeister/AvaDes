package br.ufrj.srh;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.method.annotation.InitBinderDataBinderFactory;

import br.ufrj.srh.entity.Periodo;
import br.ufrj.srh.repository.ComissaoSetorialRepository;
import br.ufrj.srh.repository.PeriodoRepository;
import br.ufrj.srh.repository.ServidorRepository;
import br.ufrj.srh.repository.UnidadeRepository;

@Component
public class DevBootstrap implements ApplicationListener<ApplicationEvent> {

	private PeriodoRepository periodoRepository;
//	private UnidadeRepository unidadeRepository;
//	private ServidorRepository servidorRepository;
//	private ComissaoSetorialRepository comissaoSetorialRepository;
	
	
	DevBootstrap() {
		this.periodoRepository = periodoRepository;
//		this.unidadeRepository = unidadeRepository;
//		this.servidorRepository= servidorRepository;
//		this.comissaoSetorialRepository = comissaoSetorialRepository;
	}
	
	@Override
	public void onApplicationEvent(ApplicationEvent event) {

		initData();
		
	}

	private void initData() {
		
	Periodo periodo = new Periodo();
	periodo.setNome("1999");
	periodo.setHabilitado(false);
	periodoRepository.saveAndFlush(periodo);
	
		
		long t = periodoRepository.count();
		System.out.println(periodoRepository.findById(1L));
		System.out.println("---------> " + t);
		
	}

}
