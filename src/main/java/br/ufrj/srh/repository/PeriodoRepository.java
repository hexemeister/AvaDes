package br.ufrj.srh.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ufrj.srh.entity.Periodo;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
	 

//	private Session session;
// 
//	public void incluir(Periodo periodo) {
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			session.save(periodo);
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
// 
//
//	@SuppressWarnings("unchecked")
	@Query(value = "SELECT * FROM public.periodo WHERE habilitado='true'", nativeQuery = true)
	public Periodo periodoVigente();
//	{
//		List<Periodo> lista = new ArrayList<Periodo>();
//		
//		try {
//			
//			
//			String sql = "SELECT *  FROM public.periodo WHERE habilitado='true'";
//			System.out.println(sql);
//			SQLQuery query =  (SQLQuery) session.createSQLQuery(sql);
//			query.addEntity(Periodo.class);		
//			//query.setParameter("sigepe", sigepe);
//			lista = (List<Periodo>) query.list();
//			
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return lista.get(0);
//	}
	
	
	
}
