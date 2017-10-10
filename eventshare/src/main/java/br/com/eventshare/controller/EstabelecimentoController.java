package br.com.eventshare.controller;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import br.com.eventshare.enums.Situacao;
import br.com.eventshare.model.Endereco;
import br.com.eventshare.model.Estabelecimento;
import br.com.eventshare.service.EstabelecimentoService;
import br.com.eventshare.util.Util;

@SuppressWarnings("deprecation")
@SessionScoped
@ManagedBean(name = "estabController")
public class EstabelecimentoController {

	@Inject
	private EstabelecimentoService estabelecimentoService;

	@Inject
	private Endereco endereco;
	
	@Inject
	private Estabelecimento estabelecimento;

	@PostConstruct
	public void init() {
		this.estabelecimento = new Estabelecimento();
		this.endereco = new Endereco();
	}
	
	
	public void salvarEndereco() {
		estabelecimento.setEndereco(endereco);
	}
	

	public String salvar() {		
		try {	
			estabelecimento.setSituacao(Situacao.ATIVO);
			estabelecimento.setNivel(1L);
			estabelecimento.setDataCadastro(Calendar.getInstance().getTime());
			estabelecimentoService.salvar(estabelecimento);
			Util.sendMessage("", "Estabelecimento Salvo com sucesso!");
			limparCampos();
			return "/estab/cadastro-estab.jsf";
		} catch (Exception e) {
			Util.sendMessage("", "Ocorreu um erro inesperado ao salvar estem estabelecimento");
			return null;
		}
			
	}

	public void limparCampos() {
		this.estabelecimento = new Estabelecimento();
		this.endereco = new Endereco();
	}
	

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}




	public Endereco getEndereco() {
		return endereco;
	}




	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	

}
