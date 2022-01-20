package generos;

public enum Genero {

	ACAO ("Ação"), 
	AVENTURA ("Aventura"), 
	ROMANCE ("Romance"), 
	DRAMA ("Drama"), 
	SUSPENSE ("Suspense"), 
	DOCUMENTARIO ("Documentário"),
	INDEPENDENTES ("Independentes"),
	CARTOON ("Cartoon"), 
	OUTROS ("Outros");

	private String descricao;
	
	Genero(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}	
}
