package dados;

import java.util.List;

import filmes.FilmePlataforma;
import informacoesDeAcesso.ContaPerfis;
import lombok.AllArgsConstructor;
import lombok.Data;
import usuarios.ContaPessoaFisica;

@Data

public class DadosCurtidasDescurtidas {

	private String nomeUsuario;
	private String nomeFilme;
	private int escolhaFilme;
	private int indexSecaoUsuario;
	private int indexSecaoFilme;

	public void relatorioCurtidasConta(List<FilmePlataforma> filmes, List<ContaPessoaFisica> pessoaFisica, int escolhaFilme,
			int indexSecaoUsuario, int indexSecaoFilme) {

		for (int i = indexSecaoUsuario; i < pessoaFisica.size(); i++) {

			nomeUsuario = pessoaFisica.get(i).getNomeConta();
			for (int j = 0; j < filmes.size(); j++) {

				if ((escolhaFilme + 1) == filmes.get(j).getId()) {

					nomeFilme = filmes.get(j).getNome();
					break;
				}
			}
		}
	}
	
	public void relatorioCurtidasPerfil(List<FilmePlataforma> filmes, List<ContaPerfis> pessoaFisica, int escolhaFilme,
			int indexSecaoUsuario, int indexSecaoFilme) {

		for (int i = indexSecaoUsuario; i < pessoaFisica.size(); i++) {

			nomeUsuario = pessoaFisica.get(i).getNomePerfil();
			for (int j = 0; j < filmes.size(); j++) {

				if ((escolhaFilme + 1) == filmes.get(j).getId()) {

					nomeFilme = filmes.get(j).getNome();
					break;
				}
			}
		}
	}
}
