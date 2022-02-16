package interatividades;

import java.util.List;
import java.util.Scanner;

import filmes.FilmePlataforma;
import informacoesDeAcesso.ContaPerfis;
import usuarios.ContaPessoaFisica;

public class Comentarios {

	private String nomeUsuario;
	private String nomeFilme;
	private String comentario;
	private int indexSecaoUsuario;
	private int indexSecaoFilme;

	public Comentarios() {

	}

	public String fazerComentarioFilme() {
		Scanner sc = new Scanner(System.in);

		String comentario = sc.nextLine();

		return this.comentario = comentario;
	}

	public void filmesComentadosConta(List<FilmePlataforma> filmes, List<ContaPessoaFisica> pessoaFisica,
			String comentario, int escolhaFilme, int secaoUsuario) {

		for (int i = secaoUsuario; i < pessoaFisica.size(); i++) {

			System.out.print(pessoaFisica.get(i).getNomeConta() + " comentou sobre o filme "
					+ filmes.get(escolhaFilme).getNome() + ": ");
			System.out.println(comentario);

		}
	}

	public void filmesComentadosPerfil(List<FilmePlataforma> filmes, List<ContaPerfis> pessoaFisica, String comentario,
			int escolhaFilme, int secaoUsuario) {

		for (int i = secaoUsuario; i < pessoaFisica.size(); i++) {

			System.out.print(pessoaFisica.get(i).getNomePerfil() + " comentou sobre o filme "
					+ filmes.get(escolhaFilme).getNome() + ": ");
			System.out.println(comentario);

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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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
