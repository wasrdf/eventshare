package br.com.eventshare.service;

import javax.inject.Inject;

import br.com.eventshare.dao.EstabelecimentoDAO;
import br.com.eventshare.model.Estabelecimento;

public class EstabelecimentoService {
	
	@Inject
	private EstabelecimentoDAO estabelecimentoDAO;
	
	public void salvar(Estabelecimento estabelecimento) {
		estabelecimentoDAO.salvarEstabelecimento(estabelecimento);
	}
	
}
