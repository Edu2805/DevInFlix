package usuarios;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import filmes.FilmePlataforma;
import generos.Genero;
import interatividades.CurtirDescurtir;
import interatividades.EscolheFilme;
import interatividades.Recomendacao;

public class PessoaFisica extends Pessoa implements CurtirDescurtir, Recomendacao, EscolheFilme {

	public PessoaFisica(String nomeCompleto, String enderecoCompleto, String dataNascimento) {
		super(nomeCompleto, enderecoCompleto, dataNascimento);

	}
	
	@Override
	public void usuarioRecomenda() {
		Scanner sc = new Scanner(System.in);

		List<FilmePlataforma> listaFilmes = new ArrayList<>();

		final LocalDate start = LocalDate.now();
		//Quando houver banco de dados, usar plusdays...
		LocalDate end = LocalDate.now();
		long days = ChronoUnit.DAYS.between(start, end);
		LocalDate dataPosterior = start.plusDays(31);

		int qtdRecomendacoes = 0;
		if (days <= 30) {

			qtdRecomendacoes++;
			int escolhaGenero = 0;
			String nomeFilme = null;
			String sinopse = null;
			String generoRecomendado = null;

			boolean entraSaiRecomendacao = true;

			if (qtdRecomendacoes <= 1) {

				System.out.print("Agora digite o nome do filme que deseja recomendar: ");
				nomeFilme = sc.nextLine();
				System.out.println("----------------------------------------------------------------------------");

				System.out.print("Digite seu texto de recomendação: ");
				sinopse = sc.nextLine();
				System.out.println("----------------------------------------------------------------------------");

				while (entraSaiRecomendacao) {
					System.out.println("Na sua concepção, em qual gênero esse filme se encaixa?");
					System.out.println(
							"1- Ação\n2- Aventura\n3- Romamce\n4- Drama\n5- Independente\n6- Documentário\n7- Cartoon\n8- Outros");

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
						System.out.println("Digite uma opção válida!");
					}

					if (escolhaGenero >= 1 & escolhaGenero <= 8) {
						break;
					}
				}

			}

			System.out.println("----------------------------------------------------------------------------");

			System.out.print("Insira o link deste filme, caso não tenha digite somente um ponto: ");
			String link = sc.nextLine();
			System.out.println("----------------------------------------------------------------------------");

			FilmePlataforma filmes = new FilmePlataforma(nomeFilme, sinopse, generoRecomendado, link);

			listaFilmes.add(filmes);

		} else {

			System.out.println("Você já fez uma recomendação este mês, espere até " + dataPosterior
					+ " para fazer uma nova recomendação!");
			System.out.println("----------------------------------------------------------------------------");
		}
	}

	@Override
	public int escolhaDoFilme(List<FilmePlataforma> filmes, int escolha) {
		Scanner sc = new Scanner(System.in);

		int escolhaFilme = 0;
		String genreFilm = null;

		while (escolhaFilme == 0) {

			int stopWhile = 0;
			while (stopWhile == 0) {
				

				try {
					String name = filmes.get(escolha).getNome();
					String description = filmes.get(escolha).getSinopse();
					genreFilm = filmes.get(escolha).getGenero();
					String adress = filmes.get(escolha).getLink();

					System.out.println("Você escolheu " + name);
					System.out.println("Link para assistir o filme: " + adress + "\n");
					System.out.println("***\n****\n*****\n******\n*******\n**Filme Assistido**");

					stopWhile = 1;
					escolhaFilme = 1;
				} catch (Exception e) {
					System.out.println("\nPor gentileza, digite o número correspondente aos filmes listados.\n");

				}
			}
		}
		
		return escolha;
	}

	@Override
	public int likeDeslike() {
		Scanner sc = new Scanner(System.in);
		int escolha = 0;
		int contCurtidas = 0;
		int contDescurtidas = 0;
		int curtidasDescurtidas = 0;

		boolean entraCurtidas = true;
		while (entraCurtidas) {
			System.out.println();
			System.out.println("------------------------------------------------------------------");
			System.out.println("Olá " + nomeCompleto + ", deseja avaliar o filme?\n1 - Para Sim\n2 - Para Não");
			System.out.print("-->");
			escolha = sc.nextInt();

			if (escolha == 1) {

				contCurtidas = 0;
				contDescurtidas = 0;
				System.out.print("Digite 1 para curtir ou 2 para descurtir: ");
				curtidasDescurtidas = sc.nextInt();

				switch (curtidasDescurtidas) {

				case 1:
					contCurtidas++;
					System.out.println("Que bom que você curtiu :) ");
					break;

				case 2:
					contDescurtidas++;
					System.out.println("Eitaaa, que pena :( ");
					break;

				default:
					System.out.println("Por gentileza, digite uma das opções listadas.");
				}
			} else if (escolha == 2) {
				System.out.println(
						"Tudo bem, mas sempre que puder, avalie nossos filmes, é muito importante para a gente ;)");
				break;

			} else {
				System.out.println("Por gentileza, digite uma das opções listadas.");
			}

			if (curtidasDescurtidas == 1 || curtidasDescurtidas == 2) {
				break;
			}
		}
		return contCurtidas - contDescurtidas;
	}
}
