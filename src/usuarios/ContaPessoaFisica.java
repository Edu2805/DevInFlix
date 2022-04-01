package usuarios;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import filmes.FilmePlataforma;
import generos.Genero;
import informacoesDeAcesso.ContaPerfis;
import interatividades.CurtirDescurtir;
import interatividades.EscolheFilme;
import interatividades.Recomendacao;

public class ContaPessoaFisica extends Pessoa implements Recomendacao, EscolheFilme {

	public ContaPessoaFisica(String nomeCompleto, String enderecoCompleto, Period idade, String eMail, String senha,
			String chaveCadastroConta, boolean statusPagamento, List<ContaPerfis> contaSecundaria) {
		super(nomeCompleto, enderecoCompleto, idade, eMail, senha, chaveCadastroConta, statusPagamento,
				contaSecundaria);
		// TODO Auto-generated constructor stub
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

			FilmePlataforma filmes = new FilmePlataforma(id, nomeFilme, sinopse, generoRecomendado, link);

			listaFilmes.add(filmes);

		} else {

			System.out.println("Você já fez uma recomendação este mês, espere até " + dataPosterior
					+ " para fazer uma nova recomendação!");
			System.out.println("----------------------------------------------------------------------------");
		}
	}

	@Override
	public int escolhaDoFilme(List<FilmePlataforma> filmes, int escolha, Period idade) {
		Scanner sc = new Scanner(System.in);

		int escolhaFilme = 0;
		String genreFilm = null;

		while (escolhaFilme == 0) {

//			if(filmes.get(escolhaFilme).getClassificacao()) {
//				
//			}

			int stopWhile = 0;
			while (stopWhile == 0) {
				

				if (idade.getYears() < filmes.get(escolha).getClassificacao()) {
					
					System.out.println("\nEste filme não é recomendado para a sua idade, escolha outro filme!\n");
					
					stopWhile = 1;
					return escolha = 0;
					
				} else {

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
		}

		return escolha;
	}

	@Override
	public String toString() {
		return "PessoaFisica [nomeCompleto=" + nomeConta + ", enderecoCompleto=" + enderecoConta + ", idade="
				+ idadeConta + ", eMail=" + eMailConta + ", senha=" + senhaConta + ", chaveCadastro="
				+ chaveCadastroConta + ", statusPagamento=" + statusPagamento + ", contaSecundaria=" + contaSecundaria
				+ ", numeroPefisConta=" + numeroPefisConta + "]";
	}

}
