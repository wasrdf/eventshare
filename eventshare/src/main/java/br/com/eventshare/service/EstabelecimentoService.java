package br.com.eventshare.service;

import java.util.List;

import javax.inject.Inject;

import br.com.eventshare.dao.EstabelecimentoDAO;
import br.com.eventshare.model.Estabelecimento;

public class EstabelecimentoService {
	
	@Inject
	private EstabelecimentoDAO estabelecimentoDAO;
	
	public void salvar(Estabelecimento estabelecimento) {
		estabelecimentoDAO.salvarEstabelecimento(estabelecimento);
	}
	
	
	public Estabelecimento findOne(Estabelecimento estabelecimento) {
		return estabelecimentoDAO.findById(estabelecimento);
	}
	
	public List<Estabelecimento> findAll() {
		return estabelecimentoDAO.findAll();
	}
	
	public void deletarEstabelecimento(Estabelecimento estabelecimento) {
		estabelecimentoDAO.deletar(estabelecimento);
	}
	
}
