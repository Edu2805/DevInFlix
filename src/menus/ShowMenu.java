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
import financeiro.Financeiro;
import generos.Genero;
import informacoesDeAcesso.Conta;
import interatividades.Comentarios;
import interatividades.Interacao;
import usuarios.Pessoa;
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
		List<String> armazenaDadosCadastrosUsuario = new ArrayList<>();
		List<String> armazenaDadosCadastrosPerfil = new ArrayList<>();
		List<String> armazenaDadosLogin = new ArrayList<>();
		List<String> armazenaComentarios = new ArrayList<>();

		GenerosMaisAssistidosUsuarios generosMaisUsuarios = new GenerosMaisAssistidosUsuarios();
		GenerosMaisAssistidosPlataforma generosMaisPlataforma = new GenerosMaisAssistidosPlataforma();
		DadosCurtidasDescurtidas relatorioCurtidasDescurtidas = new DadosCurtidasDescurtidas();
		Interacao exibeCampoSugestaoUsuario = new Interacao();
		Financeiro financeiro = new Financeiro();
		Comentarios comentarios = new Comentarios();

		Conta contaUsuario = new Conta();
		PessoaFisica listaDeUsuarios = new PessoaFisica(null, null, null, null, null, null, false);

		int secaoUsuario = 0;
		int controlaListaUsuarios = 0;
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
		int controlaNumeroDePerfis = 1;

		String nome = null;
		String endereco = null;
		String enderecoDeEmail = null;
		String senha = null;
		String dataFormatada = null;
		String chaveCadastro = null;
		String chaveLogin = null;
		String comentarioUsuario = null;

		boolean pagamento = false;
		boolean checkLogin = false;

		LocalDate data = null;
		Period idadeUsuario = null;

		System.out.println("################ DEVINFLIX ################");

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

		while (true) {

			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("######## FILMES E SÉRIES EM CARTAZ ########");

			for (FilmePlataforma filme : listaDeFilmes) {
				System.out.println("      " + filme.getNome() + "            ");
			}

			System.out.println("###########################################");

			System.out.println("------------------------------------------------------------------\n");

			// INPUTs do usuário
			System.out.println("     Escolha uma das opções abaixo");
			System.out.println("###########################################");
			System.out.println("#                                         #");
			System.out.println("#                                         #");
			System.out.println("#           1- REALIZAR CADASTRO          #");
			System.out.println("#           2- FAZER LOGIN                #");
			System.out.println("#           3- SAIR                       #");
			System.out.println("#                                         #");
			System.out.println("#                                         #");
			System.out.print("###########################################\n");
			System.out.print("-->");

			int entrarMenu = sc.nextInt();
			sc.nextLine();
			System.out.println("------------------------------------------------------------------");

			if (entrarMenu == 1) {

					System.out.println(
							"\nNo DevInFlix você pode cadastrar até três perfis de usuários, aproveite essa facilidade!\n");

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

						if (senha.equals(verificaSenha)) {
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
					System.out.println("Nome: " + nome + "\nEndereço: " + endereco + "\nData de nascimento: "
							+ dataFormatada + "\nIdade: " + idadeUsuario.getYears() + " anos\nE-mail: "
							+ enderecoDeEmail + "\n");
					System.out.println("Seus dados estão corretos? Digite 1 para SIM ou 2 para NÃO\n1- SIM\n2- NÃO");
					System.out.print("-->");
					int confirmacao = sc.nextInt();

					if (confirmacao == 1) {

						chaveCadastro = enderecoDeEmail.concat(senha);
						// armazenaDadosCadastrosUsuario.add(chaveCadastro);

						listaDeUsuarios = new PessoaFisica(nome, endereco, idadeUsuario, enderecoDeEmail, senha,
								chaveCadastro, false);
						cadastroUsuarios.add(listaDeUsuarios);

					} else {
						System.out.println("\nDigite seus dados novamente.\n");
						sc.nextLine();
					}

					
					//Novo loop deseja cadastrar mais um usuário?
					System.out.print("\nDeseja cadastrar mais algum usuário para essa conta?\n1- Sim\n2- NÃO\n-->");
					int cadastroMaisUsuario = sc.nextInt();
					sc.nextLine();

					if (cadastroMaisUsuario == 1) {

						if (controlaNumeroDePerfis == 3) {
							System.out.println("\nVocê já atingiu o limite de dastros disponíveis por conta\n");

						} else {

							while (controlaNumeroDePerfis <= 3) {
								
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

									if (senha.equals(verificaSenha)) {
										System.out.println("\nSenha cadastrada com sucesso!");
										break;
									} else {
										System.out.println("\nA senha não confere, cadastre novamente!");
									}
								}

								status = true;
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
										System.out.println(
												"\nPor gentileza, digite sua data no formato que o sistema pede.\n");

									}
								}

								System.out.println(
										"\n--------------------------------------------------------------------------------------------------\n");
								System.out.println("\nConfirme os seus dados");
								System.out.println("Nome: " + nome + "\nEndereço: " + endereco
										+ "\nData de nascimento: " + dataFormatada + "\nIdade: "
										+ idadeUsuario.getYears() + " anos\nE-mail: " + enderecoDeEmail + "\n");
								System.out.println(
										"Seus dados estão corretos? Digite 1 para SIM ou 2 para NÃO\n1- SIM\n2- NÃO");
								System.out.print("-->");
								confirmacao = sc.nextInt();

								if (confirmacao == 1) {
									controlaNumeroDePerfis++;
									
									chaveCadastro = enderecoDeEmail.concat(senha);

									contaUsuario = new Conta(nome, endereco, idadeUsuario, enderecoDeEmail, senha,
											chaveCadastro, false);
									cadastroDeContas.add(contaUsuario);
									
								}
								
								System.out.println(
										"Deseja cadastrar mais um perfil?\n1- SIM\n2- NÃO");
								System.out.print("-->");
								confirmacao = sc.nextInt();
								
								
								if(confirmacao == 1) {
									
									sc.nextLine();
									
								} else {
									break;
								}

							}

						}

					} else {
						controlaNumeroDePerfis = 3;
						break;
					}
					
				System.out.println("\nEscolha a forma de pagamento\n1- Cartão de crédito\n2- PIX\n3- Boleto\n4- Sair");
				System.out.print("-->");
				int formaPagamento = sc.nextInt();

				financeiro.verificaMensalidade(formaPagamento);

				pagamento = financeiro.isPagamento();

			} else if (entrarMenu == 2) {

				while (true) {

					System.out.print("\nDigite o seu email: ");
					String emailLogin = sc.nextLine();

					System.out.print("\nDigite a sua senha: ");
					String senhaLogin = sc.nextLine();

					chaveLogin = emailLogin.concat(senhaLogin);

					// array de chaves
					// depois compara com as chaves de cadastro já inclusas no array

					for (int i = 0; i < cadastroUsuarios.size(); i++) {

						for (int j = 0; j < cadastroDeContas.size(); j++) {

							if (cadastroUsuarios.get(i).getChaveCadastro().equals(chaveLogin)) {

								System.out.println("Está com " + cadastroUsuarios.get(i).getNomeCompleto());

								
								//Jogar o programa aqui pra dentro e criar dois cenários?
								
								checkLogin = true;
								break;

							} else if (cadastroDeContas.get(j).getChaveCadastro().equals(chaveLogin)) {

								System.out.println("Está com " + cadastroDeContas.get(j).getNome());
								
								checkLogin = true;
								break;

							} else {
								System.out.println("\nDados de login incorretos, tente novamente!");
								checkLogin = false;

							}

						}
					}

					if (checkLogin == true) {
						break;
					}
				}

				// armazenar os logins em arrays, reorganizar o código e seguir roteiro

				System.out.println(
						"--------------------------------------------------------------------------------------------------");

				if (pagamento == true) {
					System.out.println(
							"\nSeja bem-vindo ao DevInFlix, abaixo você pode conferir nosso catálogo de filmes\n");

					int indiceFilme = 0;
					for (FilmePlataforma filme : listaDeFilmes) {
						String nomeFilme = filme.getNome();
						String sinopse = filme.getSinopse();
						String generoFilme = filme.getGenero();
						indiceFilme++;

						System.out.println("OPÇÃO " + (indiceFilme) + "- GENERO: " + generoFilme + ", FILME: "
								+ nomeFilme + ", SINÓPSE: " + sinopse);
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
										System.out.println(
												"Lembrando que você só pode fazer uma recomendação por mês :)");
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

					System.out.println(
							"\n----------------------------------------------------------------------------\n");

					System.out.println(
							"\nDeseja fazer um comentário do filme que você acabou de assisti?\n1- SIM\n2- Não\n-->");

					int fazerComentario = sc.nextInt();

					if (fazerComentario == 1) {

						System.out.print("Digite o seu comentário: ");

						comentarios.fazerComentarioFilme();
						comentarioUsuario = comentarios.getComentario();

					} else {

						System.out.println("\nMuito obrigado por usar o DevInFlix\n");
					}

					System.out.println(
							"\n----------------------------------------------------------------------------\n");

					// Sugestão de filme usuário

					exibeCampoSugestaoUsuario.sugestaoDoUsuario();
					String nomeSugestao = exibeCampoSugestaoUsuario.getNomeFilmeSugerido();

					FilmeSugestaoUsuario sugestoesDeUsuarios = new FilmeSugestaoUsuario(nomeSugestao);
					listaSugestoesDoUsuario.add(sugestoesDeUsuarios);
					System.out.println("Filmes sugeridos pelos nossos usuários\n");

					for (FilmeSugestaoUsuario filmePlataforma : listaSugestoesDoUsuario) {
						System.out.println(filmePlataforma.getNomeFilmeSugerido());

					}

					System.out.println(
							"\n----------------------------------------------------------------------------\n");

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

					SomaGenerosUsuarios comparaGenerosMaisUsuarios = new SomaGenerosUsuarios(acaoUsuario,
							aventuraUsuario, romanceUsuario, cartoonUsuario, dramaUsuario, documentarioUsuario,
							independentesUsuario, suspenseUsuario, outrosUsuario);
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

					System.out.println(
							"\n----------------------------------------------------------------------------\n");

					System.out.println("\nComentários dos usuários\n");

					// Comentários dos usuários
					armazenaComentarios.add(comentarioUsuario);
					comentarios.filmesComentados(escolhaFilmesDaLista, cadastroUsuarios, armazenaComentarios,
							escolhaFilme);

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

					secaoUsuario++;

					// Verificar....
					controlaNumeroDePerfis = 0;
				} else {
					System.out.println(
							"Parece que houve um problema com o pagamento da mensalidade, retorne ao sistema e realize o pagamento.");
					break;
				}
			} else if (entrarMenu == 3) {

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
