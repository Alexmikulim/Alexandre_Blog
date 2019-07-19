package br.ed.blog.servico;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.ed.blog.entidade.Comentario;

/**
 * classe criada para gerenciar os comentarios.
 * @author Alexandre Mikulim
 *
 */
@Stateless
public class ComentarioServico {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void cadastrar(Comentario comentario) {
		comentario.setDataHora(new Date());
		comentario.setCurtidas(0);
		this.em.persist(comentario);
	}
	

	public void excluir(Comentario comentario) throws Exception {
		if (!comentario.getTipoMensagem().contains("Normal")) {
			throw new Exception("Não é possivel excluir, pois o comentario náo é normal");
		}
		if (comentario.getCurtidas()!=0) {
			throw new Exception("Não é possivel excluir pois o comentario já tem curtidas");
		}
		this.em.remove(this.em.merge(comentario));
	}
	
	
	
	public List<Comentario> listar(){
	Query query = this.em.createQuery("SELECT c FROM Comentario c", Comentario.class);
	return query.getResultList();
		
//		return this.em.createQuery("SELECT c FROM Comentario c", Comentario.class).getResultList();
	}
	
	public void curtir(Comentario comentario) {
		Integer curtidas = comentario.getCurtidas()+1;
		comentario.setCurtidas(curtidas);
		this.em.merge(comentario);
	}
}
