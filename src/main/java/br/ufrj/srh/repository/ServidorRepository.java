package br.ufrj.srh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ufrj.srh.entity.Servidor;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor, Long>{
	 
//	private Session session;
// 
//	public void incluir(Servidor servidor) {
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			session.save(servidor);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//	}
// 
//	public void alterar(Servidor servidor) {
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			session.merge(servidor);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//	}
// 
//	public void excluir(Servidor servidor) {
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			session.delete(servidor);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//	}
// 
//	public Servidor consultar(String sigepe) {
//		Servidor retorno = new Servidor();
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			retorno = (Servidor) session.get(Servidor.class, sigepe);
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
//	public List<Servidor> listar() {
//		List<Servidor> lista = new ArrayList<Servidor>();
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			lista = (List<Servidor>) session.createCriteria(Servidor.class).list();
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
	@Query(value = "SELECT s.*,'0' as funcao FROM public.servidor as s WHERE sigepe LIKE %?1 ORDER BY nome asc fetch first 6 rows only", nativeQuery= true)
	public List<Servidor> listar_tp10_like(String siape); 
//	{
//		List<Servidor> lista = new ArrayList<Servidor>();
//		
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			
//			String sql = "SELECT s.*,'0' as funcao FROM public.servidor as s WHERE sigepe LIKE '" + siape + "%' ORDER BY nome asc fetch first 6 rows only";
//			System.out.println(sql);
//			SQLQuery query =  (SQLQuery) session.createSQLQuery(sql);
//			query.addEntity(Servidor.class);		
//			//query.setParameter("sigepe", sigepe);
//			lista = (List<Servidor>) query.list();
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
	@Query(value = "SELECT s.*, '0' as funcao  FROM public.servidor as s WHERE s.sigepe = ?1", nativeQuery = true)
	public List<Servidor> consultarSQL(String sigepe);
//	{
//		List<Servidor> lista = new ArrayList<Servidor>();
//		
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			
//			session.beginTransaction();
//			
//			String sql = "SELECT s.*, '0' as funcao  FROM public.servidor as s WHERE s.sigepe = '" + sigepe + "'";
//			System.out.println(sql);
//			SQLQuery query =  (SQLQuery) session.createSQLQuery(sql);
//			query.addEntity(Servidor.class);		
//			//query.setParameter("sigepe", sigepe);
//			lista = (List<Servidor>) query.list();
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
	
	
	
	/*
	public List<Servidor> consultarSQL(String sigepe) {
		List<Servidor> result = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			Query query = session.createSQLQuery("SELECT s.*, '0' as funcao  FROM servidor as s WHERE s.sigepe = '" + sigepe + "'");
			System.out.println(query);
			result = (List<Servidor>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
 */
 
	/*
	@SuppressWarnings("unchecked")
	public List<Aluno> listar() {
		List<Aluno> lista = new ArrayList<Aluno>();
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			lista = (List<Aluno>) session.createCriteria(Aluno.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lista;
	}
 
	@SuppressWarnings("unchecked")
	public List<Aluno> listar(Aluno aluno) {
		Criteria c = session.createCriteria(Aluno.class);
		if (aluno.getNome().length() > 0) {
			c.add(Restrictions.like("nome", aluno.getNome() + "%"));
		}
		c.addOrder(Order.asc("nome"));
		return (List<Aluno>) c.list();
	}
	*/
}
