package dados;

import java.util.List;

import filmes.FilmePlataforma;
import informacoesDeAcesso.ContaPerfis;
import lombok.AllArgsConstructor;
import lombok.Data;
import usuarios.ContaPessoaFisica;


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

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public int getEscolhaFilme() {
		return escolhaFilme;
	}

	public void setEscolhaFilme(int escolhaFilme) {
		this.escolhaFilme = escolhaFilme;
	}

	public int getIndexSecaoUsuario() {
		return indexSecaoUsuario;
	}

	public void setIndexSecaoUsuario(int indexSecaoUsuario) {
		this.indexSecaoUsuario = indexSecaoUsuario;
	}

	public int getIndexSecaoFilme() {
		return indexSecaoFilme;
	}

	public void setIndexSecaoFilme(int indexSecaoFilme) {
		this.indexSecaoFilme = indexSecaoFilme;
	}
	
}
