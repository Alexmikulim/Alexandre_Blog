package br.ed.blog.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.ed.blog.entidade.Comentario;
import br.ed.blog.servico.ComentarioServico;

@Named
@RequestScoped
public class ComentarioBean {
	
	@EJB
	private ComentarioServico comentarioServico;
	
	private Comentario comentario;
	
	public ComentarioBean() {
		this.comentario = new Comentario();
	
	}

	public void cadastrar() {
		this.comentarioServico.cadastrar(comentario);
		this.comentario = new Comentario();
		JSFUtils.enviarMensagemDeInformacao("Comentario Cadastrado");
	}
	
	public void excluir(Comentario comentario) {
		try {
		this.comentarioServico.excluir(comentario);
		JSFUtils.enviarMensagemDeInformacao("Comentario Excluido");
		}catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}
	}
		
	
	public List<Comentario> listar(){
		return this.comentarioServico.listar();
	}
	
	public void curtir(Comentario comentario) {
		this.comentarioServico.curtir(comentario);
	}
	
	
	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	public ComentarioServico getComentarioServico() {
		return comentarioServico;
	}

	public void setComentarioServico(ComentarioServico comentarioServico) {
		this.comentarioServico = comentarioServico;
	}

}
