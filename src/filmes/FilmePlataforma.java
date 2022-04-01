package filmes;

import generos.Genero;

public class FilmePlataforma extends Colecao{

	public FilmePlataforma(int id, String nome, String sinopse, String genero, String link, Long classificacao) {
		super(id, nome, sinopse, genero, link, classificacao);
		// TODO Auto-generated constructor stub
	}
	
	public FilmePlataforma(int id, String nome, String sinopse, String genero, String link) {
		super(id, nome, sinopse, genero, link);
		// TODO Auto-generated constructor stub
	}
	
}
