package br.com.eventshare.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import br.com.eventshare.model.Estabelecimento;
import br.com.eventshare.service.EstabelecimentoService;

@SuppressWarnings("deprecation")
@SessionScoped
@ManagedBean(name="estabController")
public class EstabelecimentoController {

	@Inject
	private EstabelecimentoService estabelecimentoService;
	
	
	public void testar() {
		Estabelecimento estabelecimento = new Estabelecimento();
		estabelecimento.setCnpjCpf("122345454");
		
		estabelecimentoService.salvar(estabelecimento);
				
	}
	
}
