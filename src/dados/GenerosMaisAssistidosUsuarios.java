package dados;

import java.util.List;
import java.util.Objects;

import filmes.FilmePlataforma;
import generos.Genero;
import lombok.Data;
import usuarios.ContaPessoaFisica;


public class GenerosMaisAssistidosUsuarios {

	private int contAcao;
	private int contAventura;
	private int contCartoon;
	private int contDocumentario;
	private int contDrama;
	private int contIndependentes;
	private int contRomance;
	private int contSuspense;
	private int contOutros;

	public void generosMaisAssistidosUsuario(List<FilmePlataforma> filmes, int escolhaFilme, int secaoUsuario) {

		if (filmes.get(escolhaFilme).getGenero() == Genero.ACAO.getDescricao()) {
			contAcao++;

		} else if (filmes.get(escolhaFilme).getGenero() == Genero.AVENTURA.getDescricao()) {
			contAventura++;

		} else if (filmes.get(escolhaFilme).getGenero() == Genero.CARTOON.getDescricao()) {
			contCartoon++;

		} else if (filmes.get(escolhaFilme).getGenero() == Genero.DOCUMENTARIO.getDescricao()) {
			contDocumentario++;

		} else if (filmes.get(escolhaFilme).getGenero() == Genero.DRAMA.getDescricao()) {
			contDrama++;

		} else if (filmes.get(escolhaFilme).getGenero() == Genero.INDEPENDENTES.getDescricao()) {
			contIndependentes++;

		} else if (filmes.get(escolhaFilme).getGenero() == Genero.ROMANCE.getDescricao()) {
			contRomance++;

		} else if (filmes.get(escolhaFilme).getGenero() == Genero.SUSPENSE.getDescricao()) {
			contSuspense++;

		} else {
			contOutros++;

		}
	}

	public int getContAcao() {
		return contAcao;
	}

	public void setContAcao(int contAcao) {
		this.contAcao = contAcao;
	}

	public int getContAventura() {
		return contAventura;
	}

	public void setContAventura(int contAventura) {
		this.contAventura = contAventura;
	}

	public int getContCartoon() {
		return contCartoon;
	}

	public void setContCartoon(int contCartoon) {
		this.contCartoon = contCartoon;
	}

	public int getContDocumentario() {
		return contDocumentario;
	}

	public void setContDocumentario(int contDocumentario) {
		this.contDocumentario = contDocumentario;
	}

	public int getContDrama() {
		return contDrama;
	}

	public void setContDrama(int contDrama) {
		this.contDrama = contDrama;
	}

	public int getContIndependentes() {
		return contIndependentes;
	}

	public void setContIndependentes(int contIndependentes) {
		this.contIndependentes = contIndependentes;
	}

	public int getContRomance() {
		return contRomance;
	}

	public void setContRomance(int contRomance) {
		this.contRomance = contRomance;
	}

	public int getContSuspense() {
		return contSuspense;
	}

	public void setContSuspense(int contSuspense) {
		this.contSuspense = contSuspense;
	}

	public int getContOutros() {
		return contOutros;
	}

	public void setContOutros(int contOutros) {
		this.contOutros = contOutros;
	}
	
	
}
