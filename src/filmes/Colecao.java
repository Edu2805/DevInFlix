package filmes;

import generos.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;


public abstract class Colecao {

	private int id;
	private String nome;
	private String sinopse;
	private String genero;
	private String Link;
	private Long classificacao;
	
	
	
	
	
	public Colecao(int id, String nome, String sinopse, String genero, String link, Long classificacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.sinopse = sinopse;
		this.genero = genero;
		Link = link;
		this.classificacao = classificacao;
	}
	
	
	
	public Colecao(int id, String nome, String sinopse, String genero, String link) {
		super();
		this.id = id;
		this.nome = nome;
		this.sinopse = sinopse;
		this.genero = genero;
		Link = link;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}

	public Long getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Long classificacao) {
		this.classificacao = classificacao;
	}

	
}
