package dados;

import java.util.List;
import java.util.Objects;

import filmes.FilmePlataforma;
import generos.Genero;
import lombok.Data;
import usuarios.PessoaFisica;

@Data
public class GenerosMaisAssistidosUsuarios {

	int contAcao;
	int contAventura;
	int contCartoon;
	int contDocumentario;
	int contDrama;
	int contIndependentes;
	int contRomance;
	int contSuspense;
	int contOutros;

	public void generosMaisAssistidosUsuario(List<FilmePlataforma> filmes, List<PessoaFisica> pessoaFisica, int escolhaFilme,
			int secaoUsuario) {

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
}
