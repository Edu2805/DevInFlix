package filmes;

import lombok.AllArgsConstructor;
import lombok.Data;


public class FilmeSugestaoUsuario {

	private String nomeFilmeSugerido;

	public FilmeSugestaoUsuario(String nomeFilmeSugerido) {
		super();
		this.nomeFilmeSugerido = nomeFilmeSugerido;
	}

	public String getNomeFilmeSugerido() {
		return nomeFilmeSugerido;
	}

	public void setNomeFilmeSugerido(String nomeFilmeSugerido) {
		this.nomeFilmeSugerido = nomeFilmeSugerido;
	}
	
	
}
