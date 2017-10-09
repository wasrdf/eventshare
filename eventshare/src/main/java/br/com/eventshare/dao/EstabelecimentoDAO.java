package br.com.eventshare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
		} finally {
			
		}
	}
	
	public Estabelecimento findById(Estabelecimento estabelecimento) {
		//return estabelecimentoRepository.findOne(estabelecimento.getCodigo());
		return estabelecimento;
	}
	
	public List<Estabelecimento> findAll() {
		//return estabelecimentoRepository.findAll();
		return null;
	}
	
}
