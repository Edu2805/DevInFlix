package informacoesDeAcesso;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import filmes.FilmePlataforma;
import generos.Genero;
import interatividades.EscolheFilme;
import interatividades.Recomendacao;

public class ContaPerfis implements Recomendacao, EscolheFilme {

	protected String nomePerfil;
	protected String enderecoPerfil;
	protected Period idadePerfil;
	protected String eMailPerfil;
	protected String senhaPerfil;
	protected String chaveCadastroPerfil;
	protected boolean statusPagamento;

	public ContaPerfis(String nome, String endereco, Period idadeUsuario, String eMail, String senha,
			String chaveCadastro, boolean statusPagamento) {
		super();
		this.nomePerfil = nome;
		this.enderecoPerfil = endereco;
		this.idadePerfil = idadeUsuario;
		this.eMailPerfil = eMail;
		this.senhaPerfil = senha;
		this.chaveCadastroPerfil = chaveCadastro;
		this.statusPagamento = statusPagamento;
	}

	public ContaPerfis() {

	}

	public void perfilUsuario(int idadeUsuario, String eMail, String senha, boolean statusPagamento) {

	}

	public boolean verificaLogin() {

		return statusPagamento;
	}

	@Override
	public void usuarioRecomenda() {
		Scanner sc = new Scanner(System.in);

		List<FilmePlataforma> listaFilmes = new ArrayList<>();

		final LocalDate start = LocalDate.now();
		// Quando houver banco de dados, usar plusdays...
		LocalDate end = LocalDate.now();
		long days = ChronoUnit.DAYS.between(start, end);
		LocalDate dataPosterior = start.plusDays(31);

		int qtdRecomendacoes = 0;
		if (days <= 30) {

			qtdRecomendacoes++;
			int escolhaGenero = 0;
			int id = 0;
			String nomeFilme = null;
			String sinopse = null;
			String generoRecomendado = null;

			boolean entraSaiRecomendacao = true;

			if (qtdRecomendacoes <= 1) {

				System.out.print("Agora digite o nome do filme que deseja recomendar: ");
				nomeFilme = sc.nextLine();
				System.out.println("----------------------------------------------------------------------------");

				System.out.print("Digite seu texto de recomenda????o: ");
				sinopse = sc.nextLine();
				System.out.println("----------------------------------------------------------------------------");

				while (entraSaiRecomendacao) {
					System.out.println("Na sua concep????o, em qual g??nero esse filme se encaixa?");
					System.out.println(
							"1- A????o\n2- Aventura\n3- Romamce\n4- Drama\n5- Independente\n6- Document??rio\n7- Cartoon\n8- Outros");

					System.out.print("-->");
					escolhaGenero = sc.nextInt();
					sc.nextLine();

					switch (escolhaGenero) {
					case 1:
						String acao = Genero.ACAO.getDescricao();
						generoRecomendado = acao;
						break;

					case 2:
						String aventura = Genero.AVENTURA.getDescricao();
						generoRecomendado = aventura;
						break;

					case 3:
						String romance = Genero.ROMANCE.getDescricao();
						generoRecomendado = romance;
						break;

					case 4:
						String drama = Genero.DRAMA.getDescricao();
						generoRecomendado = drama;
						break;

					case 5:
						String independente = Genero.INDEPENDENTES.getDescricao();
						generoRecomendado = independente;
						break;

					case 6:
						String documentario = Genero.DOCUMENTARIO.getDescricao();
						generoRecomendado = documentario;
						break;

					case 7:
						String cartoon = Genero.CARTOON.getDescricao();
						generoRecomendado = cartoon;
						break;

					case 8:
						String outros = Genero.OUTROS.getDescricao();
						generoRecomendado = outros;
						break;

					default:
						System.out.println("Digite uma op????o v??lida!");
					}

					if (escolhaGenero >= 1 & escolhaGenero <= 8) {
						break;
					}
				}

			}

			System.out.println("----------------------------------------------------------------------------");

			System.out.print("Insira o link deste filme, caso n??o tenha digite somente um ponto: ");
			String link = sc.nextLine();
			System.out.println("----------------------------------------------------------------------------");

			FilmePlataforma filmes = new FilmePlataforma(id, nomeFilme, sinopse, generoRecomendado, link);

			listaFilmes.add(filmes);

		} else {

			System.out.println("Voc?? j?? fez uma recomenda????o este m??s, espere at?? " + dataPosterior
					+ " para fazer uma nova recomenda????o!");
			System.out.println("----------------------------------------------------------------------------");
		}

	}

	@Override
	public int escolhaDoFilme(List<FilmePlataforma> filmes, int escolha, Period idade) {
		Scanner sc = new Scanner(System.in);

		int escolhaFilme = 0;
		String genreFilm = null;

		while (escolhaFilme == 0) {

			int stopWhile = 0;
			while (stopWhile == 0) {

				if (idade.getYears() < filmes.get(escolha).getClassificacao()) {

					System.out.println("\nEste filme n??o ?? recomendado para a sua idade, escolha outro filme!\n");

					stopWhile = 1;
					return escolha = 0;

				} else {

					try {
						String name = filmes.get(escolha).getNome();
						String description = filmes.get(escolha).getSinopse();
						genreFilm = filmes.get(escolha).getGenero();
						String adress = filmes.get(escolha).getLink();

						System.out.println("Voc?? escolheu " + name);
						System.out.println("Link para assistir o filme: " + adress + "\n");
						System.out.println("***\n****\n*****\n******\n*******\n**Filme Assistido**");

						stopWhile = 1;
						escolhaFilme = 1;
					} catch (Exception e) {
						System.out.println("\nPor gentileza, digite o n??mero correspondente aos filmes listados.\n");

					}
				}
			}
		}

		return escolha;
	}

	public String geteMailPerfil() {
		return eMailPerfil;
	}

	public void seteMailPerfil(String eMail) {
		this.eMailPerfil = eMail;
	}

	public String getSenhaPerfil() {
		return senhaPerfil;
	}

	public void setSenhaPerfil(String senha) {
		this.senhaPerfil = senha;
	}

	public boolean isStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(boolean statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public Period getIdadePerfil() {
		return idadePerfil;
	}

	public void setIdadePerfil(Period idadeUsuario) {
		this.idadePerfil = idadeUsuario;
	}

	public String getNomePerfil() {
		return nomePerfil;
	}

	public void setNomePerfil(String nome) {
		this.nomePerfil = nome;
	}

	public String getEnderecoPerfil() {
		return enderecoPerfil;
	}

	public void setEnderecoPerfil(String endereco) {
		this.enderecoPerfil = endereco;
	}

	public String getChaveCadastroPerfil() {
		return chaveCadastroPerfil;
	}

	public void setChaveCadastroPerfil(String chaveCadastro) {
		this.chaveCadastroPerfil = chaveCadastro;
	}

}
