package br.ufrj.srh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ufrj.srh.entity.Unidade;
import br.ufrj.srh.entity.UnidadeExtendida;


@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long>{
	 
//	private Session session;
// 
//	public void incluir(Unidade unidade) {
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			session.save(unidade);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//	}
// 
//	public void alterar(Unidade unidade) {
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			session.merge(unidade);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//	}
// 
//	public void excluir(Unidade unidade) {
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			session.delete(unidade);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//	}
// 
//	
//	public Unidade consultar(long codigo) {
//		Unidade retorno = new Unidade();
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			retorno = (Unidade) session.get(Unidade.class, codigo);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return retorno;
//	}
 
	
	
//	@SuppressWarnings("unchecked")
	@Query(value = "SELECT a.*, b.codigo as codigo_comissao,b.sigepe_representante_da_direcao, b.sigepe_integrante_da_area_de_pessoal, b.sigepe_tecnico_administrativo\r\n" + 
			"FROM public.unidade as a\r\n" + 
			"LEFT JOIN ( SELECT * FROM public.comissaosetorial as aa JOIN \r\n" + 
			"(SELECT max(codigo)as maximo_codigo FROM public.comissaosetorial group by codigo_da_unidade) as bb \r\n" + 
			"ON aa.codigo = bb.maximo_codigo  AND aa.periodo = '?1')  as b ON b.codigo_da_unidade = a.codigo;", nativeQuery= true)
	public List<UnidadeExtendida> listar_UnidadeExtendida(long periodo);
//	{
//		List<UnidadeExtendida> lista = new ArrayList<UnidadeExtendida>();
//		
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			
//			String sql = "SELECT a.*, b.codigo as codigo_comissao,b.sigepe_representante_da_direcao, b.sigepe_integrante_da_area_de_pessoal, b.sigepe_tecnico_administrativo\r\n" + 
//					"FROM public.unidade as a\r\n" + 
//					"LEFT JOIN ( SELECT * FROM public.comissaosetorial as aa JOIN \r\n" + 
//					"(SELECT max(codigo)as maximo_codigo FROM public.comissaosetorial group by codigo_da_unidade) as bb \r\n" + 
//					"ON aa.codigo = bb.maximo_codigo  AND aa.periodo = '" + periodo + "')  as b ON b.codigo_da_unidade = a.codigo;";
//			System.out.println(sql);
//			SQLQuery query =  (SQLQuery) session.createSQLQuery(sql);
//			query.addEntity(UnidadeExtendida.class);		
//			//query.setParameter("sigepe", sigepe);
//			lista = (List<UnidadeExtendida>) query.list();
//			
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return lista;
//	}
	
	
	@SuppressWarnings("unchecked")
	@Query(value = "SELECT a.*, b.codigo as codigo_comissao,b.sigepe_representante_da_direcao, b.sigepe_integrante_da_area_de_pessoal, b.sigepe_tecnico_administrativo\r\n" + 
			"FROM public.unidade as a\r\n" + 
			"LEFT JOIN ( SELECT * FROM public.comissaosetorial as aa JOIN \r\n" + 
			"(SELECT max(codigo)as maximo_codigo FROM public.comissaosetorial group by codigo_da_unidade) as bb \r\n" + 
			"ON aa.codigo = bb.maximo_codigo AND aa.periodo = ?1 )  as b ON b.codigo_da_unidade = a.codigo  WHERE a.nome like %?2%", nativeQuery=  true)
	public List<UnidadeExtendida> listar_UnidadeExtendidaComplete(String s,long periodo); 
//	{
//		List<UnidadeExtendida> lista = new ArrayList<UnidadeExtendida>();
//		
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			
//			String sql = "SELECT a.*, b.codigo as codigo_comissao,b.sigepe_representante_da_direcao, b.sigepe_integrante_da_area_de_pessoal, b.sigepe_tecnico_administrativo\r\n" + 
//					"FROM public.unidade as a\r\n" + 
//					"LEFT JOIN ( SELECT * FROM public.comissaosetorial as aa JOIN \r\n" + 
//					"(SELECT max(codigo)as maximo_codigo FROM public.comissaosetorial group by codigo_da_unidade) as bb \r\n" + 
//					"ON aa.codigo = bb.maximo_codigo AND aa.periodo = '" + periodo + "' )  as b ON b.codigo_da_unidade = a.codigo  WHERE a.nome like '%"+s+"%'";
//			System.out.println(sql);
//			SQLQuery query =  (SQLQuery) session.createSQLQuery(sql);
//			query.addEntity(UnidadeExtendida.class);		
//			//query.setParameter("sigepe", sigepe);
//			lista = (List<UnidadeExtendida>) query.list();
//			
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return lista;
//	}
	
	
	
	@SuppressWarnings("unchecked")
	@Query(value = "SELECT a.*, b.codigo as codigo_comissao,b.sigepe_representante_da_direcao, b.sigepe_integrante_da_area_de_pessoal, b.sigepe_tecnico_administrativo\r\n" + 
			"FROM public.unidade as a\r\n" + 
			"LEFT JOIN ( SELECT * FROM public.comissaosetorial as aa JOIN \r\n" + 
			"(SELECT max(codigo)as maximo_codigo FROM public.comissaosetorial group by codigo_da_unidade) as bb \r\n" + 
			"ON aa.codigo = bb.maximo_codigo AND aa.periodo = ?1 )  as b ON b.codigo_da_unidade = a.codigo  WHERE a.codigo = ?2", nativeQuery = true)
	public List<UnidadeExtendida> listar_UnidadeExtendidaFiltroUnidade(String codigo_unidade,long periodo); 
//	{
//		List<UnidadeExtendida> lista = new ArrayList<UnidadeExtendida>();
//		
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			
//			String sql = "SELECT a.*, b.codigo as codigo_comissao,b.sigepe_representante_da_direcao, b.sigepe_integrante_da_area_de_pessoal, b.sigepe_tecnico_administrativo\r\n" + 
//					"FROM public.unidade as a\r\n" + 
//					"LEFT JOIN ( SELECT * FROM public.comissaosetorial as aa JOIN \r\n" + 
//					"(SELECT max(codigo)as maximo_codigo FROM public.comissaosetorial group by codigo_da_unidade) as bb \r\n" + 
//					"ON aa.codigo = bb.maximo_codigo AND aa.periodo = '" + periodo + "' )  as b ON b.codigo_da_unidade = a.codigo  WHERE a.codigo = '" + codigo_unidade + "'";
//			System.out.println(sql);
//			SQLQuery query =  (SQLQuery) session.createSQLQuery(sql);
//			query.addEntity(UnidadeExtendida.class);		
//			//query.setParameter("sigepe", sigepe);
//			lista = (List<UnidadeExtendida>) query.list();
//			
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return lista;
//	}
	
	
//	@SuppressWarnings("unchecked")
//	public List<Unidade> listar_unidades() {
//		List<Unidade> lista = new ArrayList<Unidade>();
//		
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			
//			String sql = "SELECT * FROM public.unidade";
//			System.out.println(sql);
//			SQLQuery query =  (SQLQuery) session.createSQLQuery(sql);
//			query.addEntity(Unidade.class);		
//			//query.setParameter("sigepe", sigepe);
//			lista = (List<Unidade>) query.list();
//			
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return lista;
//	}
	
	
	@SuppressWarnings("unchecked")
	@Query(value = "SELECT * FROM public.unidade as u WHERE u.nome LIKE %?1% ORDER BY nome asc fetch first 6 rows only", nativeQuery = true)
	public List<Unidade> listar_unidadesFiltroLIKE(String s);
//	{
//		List<Unidade> lista = new ArrayList<Unidade>();
//		
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			
//			String sql = "SELECT * FROM public.unidade as u WHERE u.nome LIKE '%" + s + "%' ORDER BY nome asc fetch first 6 rows only";
//			
//			System.out.println(sql);
//			SQLQuery query =  (SQLQuery) session.createSQLQuery(sql);
//			query.addEntity(Unidade.class);		
//			//query.setParameter("sigepe", sigepe);
//			lista = (List<Unidade>) query.list();
//			
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return lista;
//	}
	
}
