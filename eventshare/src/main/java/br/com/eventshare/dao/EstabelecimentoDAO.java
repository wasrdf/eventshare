package br.com.eventshare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.eventshare.model.Estabelecimento;


public class EstabelecimentoDAO {
	
	@PersistenceContext(unitName = "poseidonPU")
	private EntityManager em;
	
	@Transactional
	public void salvarEstabelecimento(Estabelecimento estabelecimento) {
		try {
			em.merge(estabelecimento);		
		} catch (Exception e) {
			em.getTransaction().rollback();
		} 
	}
	
	public Estabelecimento findById(Estabelecimento estabelecimento) {
		try {
			return em.find(Estabelecimento.class, estabelecimento);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	public List<Estabelecimento> findAll() {	
		try {
			StringBuilder sb = new StringBuilder("");
			sb.append("SELECT e FROM Estabelecimento e");		
			TypedQuery<Estabelecimento> q = em.createNamedQuery(sb.toString(), Estabelecimento.class);
			return q.getResultList(); 
		} catch (NoResultException ex) {
			return null;						
		} catch (Exception e) {
			new RuntimeException(e.getMessage());
		}
		return null; 
	}
	
	
	public void deletar(Estabelecimento estabelecimento) {
		try {
			em.remove(estabelecimento);
		} catch (Exception e) {
			new RuntimeException(e.getMessage());
		}
	}
	
}
