package dados;

import java.util.List;

import filmes.FilmePlataforma;
import lombok.AllArgsConstructor;
import lombok.Data;
import usuarios.PessoaFisica;

@Data

public class DadosCurtidasDescurtidas {

	private String nomeUsuario;
	private String nomeFilme;
	private int escolhaFilme;
	private int indexSecaoUsuario;
	private int indexSecaoFilme;

	public void relatorioCurtidas(List<FilmePlataforma> filmes, List<PessoaFisica> pessoaFisica, int escolhaFilme,
			int indexSecaoUsuario, int indexSecaoFilme) {

		for (int i = indexSecaoUsuario; i < pessoaFisica.size(); i++) {

			nomeUsuario = pessoaFisica.get(i).getNomeCompleto();
			for (int j = 0; j < filmes.size(); j++) {

				if ((escolhaFilme + 1) == filmes.get(j).getId()) {

					nomeFilme = filmes.get(j).getNome();
					break;
				}
			}
		}
	}
}