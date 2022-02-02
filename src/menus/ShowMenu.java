package menus;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import dados.DadosCurtidasDescurtidas;
import dados.GenerosMaisAssistidosPlataforma;
import dados.GenerosMaisAssistidosUsuarios;
import dados.SomaGenerosPlataforma;
import dados.SomaGenerosUsuarios;
import filmes.FilmePlataforma;
import filmes.FilmeSugestaoUsuario;
import generos.Genero;
import informacoesDeAcesso.Conta;
import interatividades.Interacao;
import usuarios.PessoaFisica;

public class ShowMenu implements FuncoesDoMenu {

	@Override
	public void menuUsuario() {
		Scanner sc = new Scanner(System.in);

		List<PessoaFisica> cadastroUsuarios = new ArrayList<>();
		List<Conta> cadastroDeContas = new ArrayList<>();
		Set<FilmeSugestaoUsuario> listaSugestoesDoUsuario = new LinkedHashSet<FilmeSugestaoUsuario>();
		List<String> armazenaNomeUsuario = new ArrayList<>();
		List<String> armazenaNomeFilme = new ArrayList<>();
		List<Integer> curtidasEDescurtidas = new ArrayList<>();
		GenerosMaisAssistidosUsuarios generosMaisUsuarios = new GenerosMaisAssistidosUsuarios();
		GenerosMaisAssistidosPlataforma generosMaisPlataforma = new GenerosMaisAssistidosPlataforma();
		DadosCurtidasDescurtidas relatorioCurtidasDescurtidas = new DadosCurtidasDescurtidas();
		Interacao exibeCampoSugestaoUsuario = new Interacao();

		Conta contaUsuario = new Conta();
		PessoaFisica listaDeUsuarios = new PessoaFisica(null, null, null);
		
		System.out.println("########################## DEVINFLIX ##########################");
		System.out.println("\n################## FILMES E SÉRIES EM CARTAZ ##################\n");

		Set<FilmePlataforma> listaDeFilmes = new LinkedHashSet<FilmePlataforma>();

		FilmePlataforma exterminadorDoFuturo = new FilmePlataforma(1, "O Exterminador do Futuro",
				"Robô disfarçado de humano ", Genero.ACAO.getDescricao(), "https://youtu.be/OFCE1ppomCg");

		FilmePlataforma clubeDaLuta = new FilmePlataforma(2, "Clube da luta", "Carinha que se revolta com o sistema ",
				Genero.AVENTURA.getDescricao(), "https://youtu.be/Fs0-4NLSO2Y");

		FilmePlataforma oLoboDeWallStreet = new FilmePlataforma(3, "O Lobo de Wall Street",
				"Vendedor vendendo coisas que não existem ", Genero.ACAO.getDescricao(),
				"https://youtu.be/PoSCUsNQVtw");

		FilmePlataforma ameliePoulain = new FilmePlataforma(4, "Amelie Poulain", "Filme francês fofinho ",
				Genero.ROMANCE.getDescricao(), "https://youtu.be/HUECWi5pX7o");

		FilmePlataforma crepusculo = new FilmePlataforma(5, "Crepúsculo", "Bela, o Lobo quente e o Vampiro gelado ",
				Genero.ROMANCE.getDescricao(), "https://youtu.be/Ru8THEGdcEU");

		FilmePlataforma harryPotter = new FilmePlataforma(6, "Harry Potter", "Pequeno bruxo que só se ferra ",
				Genero.AVENTURA.getDescricao(), "https://youtu.be/VyHV0BRtdxo");

		listaDeFilmes.add(exterminadorDoFuturo);
		listaDeFilmes.add(clubeDaLuta);
		listaDeFilmes.add(oLoboDeWallStreet);
		listaDeFilmes.add(ameliePoulain);
		listaDeFilmes.add(crepusculo);
		listaDeFilmes.add(harryPotter);

		for (FilmePlataforma filme : listaDeFilmes) {
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
		int dia, mes, ano;
		int escolhaFilme = 0;
		int quantidadeVezesEscolhaFilme = 0;
		int controlaNumeroDeContas = 1;

		boolean pagamento = false;
		
		Period idadeUsuario = null;
		
		while (entrarMenu != 2) {

			String nome = "";
			String endereco;
			String enderecoDeEmail;
			String senha;
			LocalDate data = null;
			String dataFormatada = "";

			// Área de insercao e validacao de dados do cliente
			while (controlaNumeroDeContas <= 3) {
				
				System.out.println("\nNo DevInFlix você pode cadastrar até três contas incluindo a sua, aproveite essa facilidade!\n");
				
				System.out.print("Digite o seu nome: ");
				nome = sc.nextLine();

				System.out.print("\nDigite o seu endereço: ");
				endereco = sc.nextLine();

				System.out.print("\nInsira o seu endereço de e-mail: ");
				enderecoDeEmail = sc.nextLine();

				while (true) {
					
					System.out.print("\nCadastre uma senha: ");
					senha = sc.nextLine();
					
					System.out.print("\nConfirme a sua senha: ");
					String verificaSenha = sc.nextLine();
					
					if(senha.equals(verificaSenha)) {
						System.out.println("\nSenha cadastrada com sucesso!");
						break;
					} else {
						System.out.println("\nA senha não confere, cadastre novamente!");
					}
				}

				boolean status = true;
				while (status) {
					System.out.print("\nEntre com a data do seu nascimento: (dd/mm/aaaa): ");
					String str = sc.nextLine();
					String[] teste = str.split("[/]");
					dia = Integer.parseInt(teste[0]);
					mes = Integer.parseInt(teste[1]);
					ano = Integer.parseInt(teste[2]);
					
					LocalDate nascimento = LocalDate.of(ano, mes, dia);
					LocalDate hoje = LocalDate.now();
					
					idadeUsuario = Period.between(nascimento, hoje);
				    
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
				System.out.println("\nConfirme os seus dados");
				System.out.println(
						"Nome: " + nome + "\nEndereço: " + endereco + "\nData de nascimento: " + dataFormatada + "\nIdade: " + idadeUsuario.getYears() + " anos\nE-mail: " + enderecoDeEmail + "\n");
				System.out.println("Seus dados estão corretos? Digite 1 para SIM ou 2 para NÃO\n1- SIM\n2- NÃO");
				System.out.print("-->");
				int confirmacao = sc.nextInt();

				if (confirmacao == 1) {
					
					System.out.print("\nDeseja cadastrar mais algum usuário para essa conta?\n1- Sim\n2- NÃO\n-->");
					int cadastroMaisUsuario = sc.nextInt();
					sc.nextLine();
					
					
					if(cadastroMaisUsuario == 1) {
						
						if(controlaNumeroDeContas == 3) {
							System.out.println("\nVocê já atingiu o limite de dastros disponíveis por conta\n");
							
						}
						
					} else {
						controlaNumeroDeContas = 3;
					}
					
					listaDeUsuarios = new PessoaFisica(nome, endereco, dataFormatada);
					
					contaUsuario = new Conta(nome, endereco, idadeUsuario, enderecoDeEmail, senha, false);
					
					cadastroUsuarios.add(listaDeUsuarios);
					cadastroDeContas.add(contaUsuario);
					controlaNumeroDeContas++;
					
				} else {
					System.out.println("\nDigite seus dados novamente.\n");
					sc.nextLine();
				}
			}
			
			//Teste
			
			for (Conta contas : cadastroDeContas) {
				System.out.println("Nome: " + contas.getNome() + ", E-mail: " + contas.geteMail() + ", Idade: " + contas.getIdadeUsuario().getYears());
			}
			
			boolean stopWhileMenuPagamento = true;
			while (stopWhileMenuPagamento) {
				System.out.println("\nEscolha a forma de pagamento\n1- Cartão de crédito\n2- PIX\n3- Boleto\n4- Sair");
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
				for (FilmePlataforma filme : listaDeFilmes) {
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
				List<FilmePlataforma> escolhaFilmesDaLista = new ArrayList<>();

				escolhaFilmesDaLista.add(exterminadorDoFuturo);
				escolhaFilmesDaLista.add(clubeDaLuta);
				escolhaFilmesDaLista.add(oLoboDeWallStreet);
				escolhaFilmesDaLista.add(ameliePoulain);
				escolhaFilmesDaLista.add(crepusculo);
				escolhaFilmesDaLista.add(harryPotter);

				boolean stopWhileNovoFilme = false;
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

					quantidadeVezesEscolhaFilme++;
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

				// listaDeUsuarios.likeDeslike();
				exibeCampoSugestaoUsuario.likeDeslike(listaDeUsuarios.getNomeCompleto());

				// Exibe a lista de usuários, para que o usuário da secao possa escolher outros
				// usuários para indicar filmes
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
								 * Impede que o usuário vizualize ele mesmo para recomendar filmes, permite que
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

				exibeCampoSugestaoUsuario.sugestaoDoUsuario();
				String nomeSugestao = exibeCampoSugestaoUsuario.getNomeFilmeSugerido();

				FilmeSugestaoUsuario sugestoesDeUsuarios = new FilmeSugestaoUsuario(nomeSugestao);
				listaSugestoesDoUsuario.add(sugestoesDeUsuarios);
				System.out.println("Filmes sugeridos pelos nossos usuários\n");

				for (FilmeSugestaoUsuario filmePlataforma : listaSugestoesDoUsuario) {
					System.out.println(filmePlataforma.getNomeFilmeSugerido());

				}

				System.out.println("\n----------------------------------------------------------------------------\n");

				// Trata os generos mais assistidos pelos usuários
				acaoUsuario = generosMaisUsuarios.getContAcao();
				aventuraUsuario = generosMaisUsuarios.getContAventura();
				romanceUsuario = generosMaisUsuarios.getContRomance();
				cartoonUsuario = generosMaisUsuarios.getContCartoon();
				dramaUsuario = generosMaisUsuarios.getContDrama();
				documentarioUsuario = generosMaisUsuarios.getContDocumentario();
				independentesUsuario = generosMaisUsuarios.getContIndependentes();
				suspenseUsuario = generosMaisUsuarios.getContSuspense();
				outrosUsuario = generosMaisUsuarios.getContOutros();

				// Trata os generos mais assistidos da plataforma
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

				System.out.println("\nFilmes curtidos e descurtidos pelos usuários\n");

				// Relatório de filmes curtidos
				relatorioCurtidasDescurtidas.relatorioCurtidas(escolhaFilmesDaLista, cadastroUsuarios, escolhaFilme,
						secaoUsuario, secaoUsuario);

				armazenaNomeUsuario.add(relatorioCurtidasDescurtidas.getNomeUsuario());
				armazenaNomeFilme.add(relatorioCurtidasDescurtidas.getNomeFilme());
				curtidasEDescurtidas.add(exibeCampoSugestaoUsuario.getCurtidasDescurtidas());

				// Testes
//				System.out.println(armazenaNomeUsuario);
//				System.out.println(armazenaNomeFilme);
//				System.out.println(curtidasEDescurtidas);

				for (int i = 0; i < armazenaNomeUsuario.size(); i++) {

					if (curtidasEDescurtidas.get(i) == 1) {
						System.out.print(armazenaNomeUsuario.get(i) + " deu like no ");
					} else if (curtidasEDescurtidas.get(i) == 2) {
						System.out.print(armazenaNomeUsuario.get(i) + " deu deslike no ");
					} else {
						// não exibe o usuário que não curtiu e nem descurtiu o filme

					}

					for (int j = i; j < armazenaNomeFilme.size(); j++) {

						if (curtidasEDescurtidas.get(i) >= 1 && curtidasEDescurtidas.get(i) <= 2) {
							System.out.println("filme " + armazenaNomeFilme.get(j));
							break;

						} else {
							break;
						}
					}
					continue;
				}

				boolean saidaPrograma = true;
				while (saidaPrograma) {
					boolean stopWhile = true;
					while (stopWhile) {
						System.out.println(
								"\n---------------------------------------------------------------------------\n");
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
