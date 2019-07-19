package br.ed.blog.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * classe criada para criar um comentario
 * 
 * @author Alexandre Mikulim
 *
 */
@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCIA_COMENTARIO")
	@SequenceGenerator(name = "SEQUENCIA_COMENTARIO", sequenceName = "SEQ_NUN_COMENTARIO", allocationSize = 0)
	private Integer id;
	@NotBlank
	private String nome;
	@NotBlank
	@Size(min = 10, max = 140)
	private String comentario;
	@NotBlank
	private String tipoMensagem;
	@NotNull
	private Date dataHora;
	@NotNull
	private Integer curtidas;

	public Comentario() {

	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getComentario() {
		return comentario;
	}

	public String getTipoMensagem() {
		return tipoMensagem;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public void setTipoMensagem(String tipoMensagem) {
		this.tipoMensagem = tipoMensagem;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Integer getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(Integer curtidas) {
		this.curtidas = curtidas;
	}

}
