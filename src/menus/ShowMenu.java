package menus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import dados.GenerosMaisAssistidosPlataforma;
import dados.GenerosMaisAssistidosUsuarios;
import dados.SomaGenerosPlataforma;
import dados.SomaGenerosUsuarios;
import filmes.Filme;
import generos.Genero;
import interatividades.Interacao;
import usuarios.PessoaFisica;

public class ShowMenu implements FuncoesDoMenu {

	@Override
	public void menuUsuario() {
		Scanner sc = new Scanner(System.in);

		List<PessoaFisica> cadastroUsuarios = new ArrayList<>();
		GenerosMaisAssistidosUsuarios generosMaisUsuarios = new GenerosMaisAssistidosUsuarios();
		GenerosMaisAssistidosPlataforma generosMaisPlataforma = new GenerosMaisAssistidosPlataforma();

		System.out.println("########################## DEVINFLIX ##########################");
		System.out.println("\n################## FILMES E SÉRIES EM CARTAZ ##################\n");

		Set<Filme> listaDeFilmes = new LinkedHashSet<Filme>();

		Filme exterminadorDoFuturo = new Filme("O Exterminador do Futuro", "Robô disfarçado de humano ",
				Genero.ACAO.getDescricao(), "https://youtu.be/OFCE1ppomCg");

		Filme clubeDaLuta = new Filme("Clube da luta", "Carinha que se revolta com o sistema ",
				Genero.AVENTURA.getDescricao(), "https://youtu.be/Fs0-4NLSO2Y");

		Filme oLoboDeWallStreet = new Filme("O Lobo de Wall Street", "Vendedor vendendo coisas que não existem ",
				Genero.ACAO.getDescricao(), "https://youtu.be/PoSCUsNQVtw");

		Filme ameliePoulain = new Filme("Amelie Poulain", "Filme francês fofinho ", Genero.ROMANCE.getDescricao(),
				"https://youtu.be/HUECWi5pX7o");

		Filme crepusculo = new Filme("Crepúsculo", "Bela, o Lobo quente e o Vampiro gelado ",
				Genero.ROMANCE.getDescricao(), "https://youtu.be/Ru8THEGdcEU");

		Filme harryPotter = new Filme("Harry Potter", "Pequeno bruxo que só se ferra ", Genero.AVENTURA.getDescricao(),
				"https://youtu.be/VyHV0BRtdxo");

		listaDeFilmes.add(exterminadorDoFuturo);
		listaDeFilmes.add(clubeDaLuta);
		listaDeFilmes.add(oLoboDeWallStreet);
		listaDeFilmes.add(ameliePoulain);
		listaDeFilmes.add(crepusculo);
		listaDeFilmes.add(harryPotter);

		for (Filme filme : listaDeFilmes) {
			System.out.println(filme.getNome());
		}

		System.out.println("------------------------------------------------------------------\n");

		// INPUTs do usuário
		System.out.println("Deseja se cadastrar?\n1- Para SIM\n2- Para NÃO");
		System.out.print("-->");
		int entrarMenu = sc.nextInt();
		sc.nextLine();
		System.out.println("------------------------------------------------------------------");

		// Armazena a secao de cada usuário quando está em tempo de execução
		int secaoUsuario = 0;
		int controlaListaUsuarios = 0;

		// Variáveis de controle dos generos mais assistidos
		int acaoUsuario;
		int aventuraUsuario;
		int romanceUsuario;
		int cartoonUsuario;
		int dramaUsuario;
		int documentarioUsuario;
		int independentesUsuario;
		int suspenseUsuario;
		int outrosUsuario;

		int acaoPlataforma;
		int aventuraPlataforma;
		int romancePlataforma;
		int cartoonPlataforma;
		int dramaPlataforma;
		int documentarioPlataforma;
		int independentesPlataforma;
		int suspensePlataforma;
		int outrosPlataforma;

		boolean pagamento = false;

		while (entrarMenu != 2) {

			String nome;
			String endereco;
			String idade = "";
			LocalDate data = null;
			String dataFormatada = "";

			// Área de insercao e validacao de dados do cliente
			while (true) {

				System.out.print("Digite o seu nome: ");
				nome = sc.nextLine();

				System.out.print("Digite o seu endereço: ");
				endereco = sc.nextLine();

				boolean status = true;
				while (status) {
					System.out.print("Entre com a data do seu nascimento: (dd/mm/aaaa): ");
					String str = sc.nextLine();
					try {
						DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						data = LocalDate.parse(str, fmt);
						dataFormatada = data.format(fmt);

						status = false;
					} catch (Exception e) {
						System.out.println("\nPor gentileza, digite sua data no formato que o sistema pede.\n");

					}
				}

				System.out.println(
						"\n--------------------------------------------------------------------------------------------------\n");
				System.out.println("Confirme os seus dados");
				System.out.println(
						"Nome: " + nome + "\nEndereço: " + endereco + "\nData de nascimento: " + dataFormatada + "\n");
				System.out.println("Seus dados estão corretos? Digite 1 para SIM ou 2 para NÃO\n1- SIM\n2- NÃO");
				System.out.print("-->");
				int confirmacao = sc.nextInt();

				if (confirmacao == 1) {
					break;
				} else {
					System.out.println("Digite seus dados novamente.\n");
					sc.nextLine();
				}
			}

			PessoaFisica listaDeUsuarios = new PessoaFisica(nome, endereco, dataFormatada);

			cadastroUsuarios.add(listaDeUsuarios);

			boolean stopWhileMenuPagamento = true;
			while (stopWhileMenuPagamento) {
				System.out.println("Escolha a forma de pagamento\n1- Cartão de crédito\n2- PIX\n3- Boleto\n4- Sair");
				System.out.print("-->");
				int formaPagamento = sc.nextInt();

				switch (formaPagamento) {
				case 1:
					System.out.println("Você irá pagar com cartão de crédito");
					pagamento = true;
					stopWhileMenuPagamento = false;
					break;

				case 2:
					System.out.println("Você irá pagar com PIX");
					pagamento = true;
					stopWhileMenuPagamento = false;
					break;

				case 3:
					System.out.println("Você irá pagar com Boleto");
					pagamento = true;
					stopWhileMenuPagamento = false;
					break;
					
				case 4:
					pagamento = false;
					stopWhileMenuPagamento = false;
					break;

				default:
					System.out.println("\nForma de pagamento inválida\n");
					pagamento = false;
					break;
				}
			}

			if (pagamento == true) {

				System.out.println("Seja bem-vindo ao DevInFlix, abaixo você pode conferir nosso catálogo de filmes\n");

				int indiceFilme = 0;
				for (Filme filme : listaDeFilmes) {
					String nomeFilme = filme.getNome();
					String sinopse = filme.getSinopse();
					String generoFilme = filme.getGenero();
					indiceFilme++;

					System.out.println("OPÇÃO " + (indiceFilme) + "- GENERO: " + generoFilme + ", FILME: " + nomeFilme
							+ ", SINÓPSE: " + sinopse);
				}
				System.out.println(
						"--------------------------------------------------------------------------------------------------");

				// Abre lista para escolha do filme
				List<Filme> escolhaFilmesDaLista = new ArrayList<>();

				escolhaFilmesDaLista.add(exterminadorDoFuturo);
				escolhaFilmesDaLista.add(clubeDaLuta);
				escolhaFilmesDaLista.add(oLoboDeWallStreet);
				escolhaFilmesDaLista.add(ameliePoulain);
				escolhaFilmesDaLista.add(crepusculo);
				escolhaFilmesDaLista.add(harryPotter);

				boolean stopWhileNovoFilme = false;
				int escolhaFilme = 0;
				while (!stopWhileNovoFilme) {
					System.out.print("Olá " + listaDeUsuarios.getNomeCompleto()
							+ ", escolha um dos filmes para você assistir: ");
					escolhaFilme = sc.nextInt() - 1;
					sc.nextLine();
					listaDeUsuarios.escolhaDoFilme(escolhaFilmesDaLista, escolhaFilme);
					generosMaisUsuarios.generosMaisAssistidosUsuario(escolhaFilmesDaLista, cadastroUsuarios,
							escolhaFilme, secaoUsuario);
					generosMaisPlataforma.generosMaisAssistidosPlataforma(escolhaFilmesDaLista, cadastroUsuarios,
							escolhaFilme, secaoUsuario);

					System.out.println("\nDeseja escolher mais algum filme?1- SIM, 2- NÃO");
					System.out.print("-->");
					int maisFilmes = sc.nextInt();

					if (maisFilmes == 1) {
						stopWhileNovoFilme = false;
					} else if (maisFilmes == 2) {
						stopWhileNovoFilme = true;
						;
					} else {
						System.out.println("\nPor gentileza, digite uma opção válida.\n");
					}
				}

				listaDeUsuarios.likeDeslike();

				// Exibe a lista de usuários, para que o usuário da secao possa escoher outros
				// usuário para indicar filmes
				int escolha = 0;
				boolean usuarioRecomenda = true;
				boolean stopWhileRecomenda = true;
				int controleEnunciado = secaoUsuario;

				int sair = 0;

				while (usuarioRecomenda) {
					while (stopWhileRecomenda) {
						int controleLista = 0;

						for (int i = controlaListaUsuarios; i < cadastroUsuarios.size(); i++) {
							if (secaoUsuario == i) {
								/**
								 * Impede que o usuário selecione ele mesmo para recomendar filmes, permite que
								 * o indice dele nao seja exibido enquanto usa o sistema
								 */

							} else {

								if (controleEnunciado == secaoUsuario) {

									System.out.println(
											"----------------------------------------------------------------------------\n");
									System.out.println(
											"Agora precisamos que você selecione um dos usuários listados abaixo e faça uma recomendação de filme\n");
									System.out.println("Lembrando que você só pode fazer uma recomendação por mês :)");
								}
								controleEnunciado++;

								String nomeUsuarioLista = cadastroUsuarios.get(i).getNomeCompleto();
								System.out.println((i + 1) + "- " + nomeUsuarioLista);
								controleLista = 2;
							}
						}

						// Fazer um loop com excecoes
						if (controleLista == 2) {
							System.out.print("-->");
							escolha = sc.nextInt();

							for (int h = 0; h < cadastroUsuarios.size(); h++) {
								if (escolha <= cadastroUsuarios.size()) {
									System.out.println(
											"Você escolheu " + cadastroUsuarios.get(escolha - 1).getNomeCompleto());
									System.out.println(
											"----------------------------------------------------------------------------");

									listaDeUsuarios.usuarioRecomenda();

									stopWhileRecomenda = false;
									break;
								} else {
									System.out.println(
											"\nPor gentileza, digite um número correspondente a lista de usuários.\n");
								}
								break;
							}
						}
						stopWhileRecomenda = false;
					}
					sair++;
					if (sair == cadastroUsuarios.size()) {
						break;
					}
				}

				// Sugestão de filme usuário
				Interacao sugestaoFilmeUsuarios = new Interacao();
				sugestaoFilmeUsuarios.sugestaoDoUuario();

				// Criar um método para armazenar a recomendacao

				acaoUsuario = generosMaisUsuarios.getContAcao();
				aventuraUsuario = generosMaisUsuarios.getContAventura();
				romanceUsuario = generosMaisUsuarios.getContRomance();
				cartoonUsuario = generosMaisUsuarios.getContCartoon();
				dramaUsuario = generosMaisUsuarios.getContDrama();
				documentarioUsuario = generosMaisUsuarios.getContDocumentario();
				independentesUsuario = generosMaisUsuarios.getContIndependentes();
				suspenseUsuario = generosMaisUsuarios.getContSuspense();
				outrosUsuario = generosMaisUsuarios.getContOutros();

				acaoPlataforma = generosMaisPlataforma.getContAcao();
				aventuraPlataforma = generosMaisPlataforma.getContAventura();
				romancePlataforma = generosMaisPlataforma.getContRomance();
				cartoonPlataforma = generosMaisPlataforma.getContCartoon();
				dramaPlataforma = generosMaisPlataforma.getContDrama();
				documentarioPlataforma = generosMaisPlataforma.getContDocumentario();
				independentesPlataforma = generosMaisPlataforma.getContIndependentes();
				suspensePlataforma = generosMaisPlataforma.getContSuspense();
				outrosPlataforma = generosMaisPlataforma.getContOutros();

				SomaGenerosUsuarios comparaGenerosMaisUsuarios = new SomaGenerosUsuarios(acaoUsuario, aventuraUsuario,
						romanceUsuario, cartoonUsuario, dramaUsuario, documentarioUsuario, independentesUsuario,
						suspenseUsuario, outrosUsuario);
				SomaGenerosPlataforma comparaGenerosMaisPlataforma = new SomaGenerosPlataforma(acaoPlataforma,
						aventuraPlataforma, romancePlataforma, cartoonPlataforma, dramaPlataforma,
						documentarioPlataforma, independentesPlataforma, suspensePlataforma, outrosPlataforma);

				System.out.println("Os generos mais assistidos por " + listaDeUsuarios.getNomeCompleto() + " são:");
				comparaGenerosMaisUsuarios.generoMaisUsuario();

				System.out.println("\nOs generos mais assistidos do DevInFlix são:");
				comparaGenerosMaisPlataforma.generoMaisPlataforma();

				boolean saidaPrograma = true;
				while (saidaPrograma) {
					boolean stopWhile = true;
					while (stopWhile) {
						System.out.println("\nDeseja sair do sistema?\n1- Para NÃO\n2- Para SIM");
						entrarMenu = sc.nextInt();
						sc.nextLine();

						if (entrarMenu == 2) {
							break;
						} else if (entrarMenu == 1) {

							// Zera os contadores da seção do usuário
							generosMaisUsuarios.setContAcao(0);
							generosMaisUsuarios.setContAventura(0);
							generosMaisUsuarios.setContCartoon(0);
							generosMaisUsuarios.setContDocumentario(0);
							generosMaisUsuarios.setContDrama(0);
							generosMaisUsuarios.setContIndependentes(0);
							generosMaisUsuarios.setContRomance(0);
							generosMaisUsuarios.setContSuspense(0);
							generosMaisUsuarios.setContOutros(0);

							break;
						} else {
							System.out.println("\nPor gentileza, digite uma das opções listadas\n");
						}
					}

					if (entrarMenu == 1 || entrarMenu == 2) {
						break;
					}
				}

				secaoUsuario++;
			} else {
				System.out.println(
						"Parece que houve um problema com o pagamento da mensalidade, retorne ao sistema e realize o pagamento.");
				break;
			}
		}
	}

	// Futuro menu para impressao de relatórios
	@Override
	public void menuAdministrador() {
		// TODO Auto-generated method stub

	}

}
