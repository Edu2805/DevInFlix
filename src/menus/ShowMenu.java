package menus;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
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
import informacoesDeAcesso.ContaPerfis;
import interatividades.Comentarios;
import interatividades.Interacao;
import usuarios.Pessoa;
import usuarios.ContaPessoaFisica;

public class ShowMenu implements FuncoesDoMenu {

	@Override
	public void menuUsuario() {
		Scanner sc = new Scanner(System.in);

		List<ContaPessoaFisica> cadastroContas = new ArrayList<>();
		List<ContaPerfis> cadastroPerfis = new ArrayList<>();
		Set<FilmeSugestaoUsuario> listaSugestoesDoUsuario = new LinkedHashSet<FilmeSugestaoUsuario>();
		List<FilmePlataforma> escolhaFilmesDaListaUsuario = new ArrayList<>();
		List<FilmePlataforma> escolhaFilmesDaListaPerfil = new ArrayList<>();
		List<String> armazenaNomeUsuario = new ArrayList<>();
		List<String> armazenaNomePerfil = new ArrayList<>();
		List<String> armazenaNomeFilmeUsuario = new ArrayList<>();
		List<String> armazenaNomeFilmePerfil = new ArrayList<>();
		List<Integer> curtidasEDescurtidasUsuario = new ArrayList<>();
		List<Integer> curtidasEDescurtidasPerfil = new ArrayList<>();
		List<String> armazenaComentariosUsuario = new ArrayList<String>();
		List<String> armazenaComentariosPerfil = new ArrayList<String>();
		List<String> armazenaDadosCadastrosUsuario = new ArrayList<>();
		List<String> armazenaDadosCadastrosPerfil = new ArrayList<>();
		List<String> armazenaDadosLogin = new ArrayList<>();

		GenerosMaisAssistidosUsuarios generosMaisUsuarios = new GenerosMaisAssistidosUsuarios();
		GenerosMaisAssistidosPlataforma generosMaisPlataforma = new GenerosMaisAssistidosPlataforma();
		DadosCurtidasDescurtidas relatorioCurtidasDescurtidas = new DadosCurtidasDescurtidas();
		Interacao exibeCampoSugestaoUsuario = new Interacao();
		Financeiro financeiro = new Financeiro();
		Comentarios comentarios = new Comentarios();

		ContaPerfis contaSecundaria = new ContaPerfis();
		ContaPessoaFisica contaPrincipal = new ContaPessoaFisica(null, null, null, null, null, null, false, null);

		int secaoUsuario = 0;
		int secaoPerfil = 0;
		int controlaListaUsuarios = 0;
		int dia, mes, ano;
		int escolhaFilme = 0;
		int quantidadeVezesEscolhaFilme = 0;
		int confirmacao = 0;
		int acaoUsuario = 0;
		int aventuraUsuario = 0;
		int romanceUsuario = 0;
		int cartoonUsuario = 0;
		int dramaUsuario = 0;
		int documentarioUsuario = 0;
		int independentesUsuario = 0;
		int suspenseUsuario = 0;
		int outrosUsuario = 0;
		int acaoPlataforma = 0;
		int aventuraPlataforma = 0;
		int romancePlataforma = 0;
		int cartoonPlataforma = 0;
		int dramaPlataforma = 0;
		int documentarioPlataforma = 0;
		int independentesPlataforma = 0;
		int suspensePlataforma = 0;
		int outrosPlataforma = 0;
		int ativaRelatorio = 0;

		String nomeConta = null;
		String enderecoConta = null;
		String enderecoDeEmailConta = null;
		String senhaConta = null;
		String dataFormatadaConta = null;
		String nomePerfil = null;
		String enderecoPerfil = null;
		String enderecoDeEmailPerfil = null;
		String senhaPerfil = null;
		String dataFormatadaPerfil = null;
		String chaveCadastroConta = null;
		String chaveCadastroPerfil = null;
		String chaveLogin = null;
		String comentarioUsuario = null;
		String comentarioPerfil = null;
		String nomeUsuarioLista = null;
		String usuarioComentario = null;
		String perfilComentario = null;
		String filmeComentario = null;

		boolean pagamento = false;
		boolean menuGeral = false;
		boolean status = true;

		LocalDate data = null;
		Period idadeUsuarioConta = null;
		Period idadeUsuarioPerfil = null;

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

		while (!menuGeral) {

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

			switch (entrarMenu) {

			case 1:
				boolean statusCadastroConta = false;
				boolean statusCadastroPerfil = false;
				int controlaNumeroDePerfis = 1;

				System.out.println(
						"\nNo DevInFlix você pode cadastrar até três perfis de usuários, aproveite essa facilidade!\n");

				while (!statusCadastroConta) {

					status = true;
					System.out.print("Digite o seu nome: ");
					nomeConta = sc.nextLine();

					System.out.print("\nDigite o seu endereço: ");
					enderecoConta = sc.nextLine();

					System.out.print("\nInsira o seu endereço de e-mail: ");
					enderecoDeEmailConta = sc.nextLine();

					while (true) {

						System.out.print("\nCadastre uma senha: ");
						senhaConta = sc.nextLine();

						System.out.print("\nConfirme a sua senha: ");
						String verificaSenha = sc.nextLine();

						if (senhaConta.equals(verificaSenha)) {
							System.out.println("\nSenha cadastrada com sucesso!");
							break;
						} else {
							System.out.println("\nA senha não confere, cadastre novamente!");
						}
					}

					// verificar se usuário já existe.....

					while (status) {
						System.out.print("\nEntre com a data do seu nascimento: (dd/mm/aaaa): ");
						String str = sc.nextLine();

						String[] teste = str.split("[/]");
						dia = Integer.parseInt(teste[0]);
						mes = Integer.parseInt(teste[1]);
						ano = Integer.parseInt(teste[2]);

						LocalDate nascimento = LocalDate.of(ano, mes, dia);
						LocalDate hoje = LocalDate.now();

						idadeUsuarioConta = Period.between(nascimento, hoje);

						try {
							DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							data = LocalDate.parse(str, fmt);
							dataFormatadaConta = data.format(fmt);

							status = false;
						} catch (Exception e) {
							System.out.println("\nPor gentileza, digite sua data no formato que o sistema pede.\n");

						}
					}

					System.out.println(
							"\n--------------------------------------------------------------------------------------------------\n");
					System.out.println("\nConfirme os seus dados");
					System.out.println("Nome: " + nomeConta + "\nEndereço: " + enderecoConta + "\nData de nascimento: "
							+ dataFormatadaConta + "\nIdade: " + idadeUsuarioConta.getYears() + " anos\nE-mail: "
							+ enderecoDeEmailConta + "\n");
					System.out.println("Seus dados estão corretos? Digite 1 para SIM ou 2 para NÃO\n1- SIM\n2- NÃO");
					System.out.print("-->");
					confirmacao = sc.nextInt();

					if (confirmacao == 1) {

						chaveCadastroConta = enderecoDeEmailConta.concat(senhaConta);

						System.out.println(
								"\nEscolha a forma de pagamento\n1- Cartão de crédito\n2- PIX\n3- Boleto\n4- Sair");
						System.out.print("-->");
						int formaPagamento = sc.nextInt();

						financeiro.verificaMensalidade(formaPagamento);

						pagamento = financeiro.isPagamento();

						statusCadastroConta = true;

					} else {
						System.out.println("\nDigite seus dados novamente.\n");

						sc.nextLine();
					}
				}

				System.out.print(
						"\nDeseja cadastrar perfis para essa conta? Você pode cadastrar até três perfis\n1- Sim\n2- NÃO\n-->");
				int cadastroMaisUsuario = sc.nextInt();
				sc.nextLine();

				while (!statusCadastroPerfil) {
					if (cadastroMaisUsuario == 1) {

						if (controlaNumeroDePerfis >= contaPrincipal.getNumeroPefisConta()) {
							System.out.println("\nVocê já atingiu o limite de dastros disponíveis por conta\n");

							// caso ultrapasse o numero máximo de cadastro de perfis, garante a instancia da
							// conta e os perfis associados
							contaPrincipal = new ContaPessoaFisica(nomeConta, enderecoConta, idadeUsuarioConta,
									enderecoDeEmailConta, senhaConta, chaveCadastroConta, pagamento, cadastroPerfis);

							cadastroContas.add(contaPrincipal);

							break;

						} else {

							while (controlaNumeroDePerfis <= contaPrincipal.getNumeroPefisConta()) {

								System.out.print("Digite o seu nome: ");
								nomePerfil = sc.nextLine();

								System.out.print("\nDigite o seu endereço: ");
								enderecoPerfil = sc.nextLine();

								System.out.print("\nInsira o seu endereço de e-mail: ");
								enderecoDeEmailPerfil = sc.nextLine();

								while (true) {

									System.out.print("\nCadastre uma senha: ");
									senhaPerfil = sc.nextLine();

									System.out.print("\nConfirme a sua senha: ");
									String verificaSenha = sc.nextLine();

									if (senhaPerfil.equals(verificaSenha)) {
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

									idadeUsuarioPerfil = Period.between(nascimento, hoje);

									try {
										DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
										data = LocalDate.parse(str, fmt);
										dataFormatadaPerfil = data.format(fmt);

										status = false;
									} catch (Exception e) {
										System.out.println(
												"\nPor gentileza, digite sua data no formato que o sistema pede.\n");

									}
								}

								System.out.println(
										"\n--------------------------------------------------------------------------------------------------\n");
								System.out.println("\nConfirme os seus dados");
								System.out.println("Nome: " + nomePerfil + "\nEndereço: " + enderecoPerfil
										+ "\nData de nascimento: " + dataFormatadaPerfil + "\nIdade: "
										+ idadeUsuarioPerfil.getYears() + " anos\nE-mail: " + enderecoDeEmailPerfil
										+ "\n");
								System.out.println(
										"Seus dados estão corretos? Digite 1 para SIM ou 2 para NÃO\n1- SIM\n2- NÃO");
								System.out.print("-->");
								confirmacao = sc.nextInt();

								if (confirmacao == 1) {

									controlaNumeroDePerfis++;

									chaveCadastroPerfil = enderecoDeEmailPerfil.concat(senhaPerfil);

									contaSecundaria = new ContaPerfis(nomePerfil, enderecoPerfil, idadeUsuarioPerfil,
											enderecoDeEmailPerfil, senhaPerfil, chaveCadastroPerfil, pagamento);
									cadastroPerfis.add(contaSecundaria);

									System.out.println("Deseja cadastrar mais um perfil?\n1- SIM\n2- NÃO");
									System.out.print("-->");
									cadastroMaisUsuario = sc.nextInt();

									if (cadastroMaisUsuario == 1) {

										statusCadastroPerfil = false;
										sc.nextLine();

									} else {

										// instancia a conta e associa o perfil a esta conta...
										contaPrincipal = new ContaPessoaFisica(nomeConta, enderecoConta,
												idadeUsuarioConta, enderecoDeEmailConta, senhaConta, chaveCadastroConta,
												pagamento, cadastroPerfis);

										cadastroContas.add(contaPrincipal);

										statusCadastroPerfil = true;
										break;
									}

								} else {
									sc.nextLine();
									// retorna para realizar o cadastro novamente...

								}
							}

						}

					} else {

						// Caso não deseja cadastrar nenhum perfil
						contaPrincipal = new ContaPessoaFisica(nomeConta, enderecoConta, idadeUsuarioConta,
								enderecoDeEmailConta, senhaConta, chaveCadastroConta, pagamento, null);

						cadastroContas.add(contaPrincipal);
						statusCadastroPerfil = true;

					}
				}

				// Testes
//				for (ContaPessoaFisica conta : cadastroContas) {
//					
//					for (ContaPerfis perfil : cadastroPerfis) {
//						
//						
//						System.out.println("Senhas das contas: " + conta.getChaveCadastroConta());
//						System.out.println("Senhas dos perfis: " + perfil.getChaveCadastroPerfil());
//						
//					}
//					
//				}

				break;

//#####################################################################################################################################################

			case 2:
				boolean checkLoginConta = false;
				boolean checkLoginPerfil = false;

				while (true) {

					System.out.print("\nDigite o seu email: ");
					String emailLogin = sc.nextLine();

					System.out.print("\nDigite a sua senha: ");
					String senhaLogin = sc.nextLine();

					chaveLogin = emailLogin.concat(senhaLogin);

					for (int i = 0; i < cadastroContas.size(); i++) {

						// verificar outra maneira de exibir menssagem de login incorrero...
						if (cadastroContas.get(i).getChaveCadastroConta().equals(chaveLogin)) {

							secaoUsuario = i;
							checkLoginPerfil = false;
							checkLoginConta = true;
							armazenaNomeUsuario.add(cadastroContas.get(i).getNomeConta());

							break;

						} else {

							checkLoginConta = false;
						}

					}

					for (int j = 0; j < cadastroPerfis.size(); j++) {

						if (cadastroPerfis.get(j).getChaveCadastroPerfil().equals(chaveLogin)) {

							secaoPerfil = j;
							checkLoginConta = false;
							checkLoginPerfil = true;
							armazenaNomePerfil.add(cadastroPerfis.get(j).getNomePerfil());

							break;

						} else {

							checkLoginPerfil = false;

						}

					}

					if (checkLoginConta == true || checkLoginPerfil == true) {
						break;
					}

				}

				if (checkLoginConta == true) {

					for (int i = 0; i < cadastroContas.size(); i++) {

						if (cadastroContas.get(i).getChaveCadastroConta().equals(chaveLogin)) {

							System.out.println(
									"--------------------------------------------------------------------------------------------------");

							int controleLista = 0;

							if (pagamento == true) {
								System.out.println(
										"\nSeja bem-vindo ao DevInFlix, abaixo você pode conferir nosso catálogo de filmes\n");

								int indiceFilme = 0;
								for (FilmePlataforma filme : listaDeFilmes) {
									String nomeFilme = filme.getNome();
									String sinopse = filme.getSinopse();
									String generoFilme = filme.getGenero();
									indiceFilme++;

									System.out.println("OPÇÃO " + (indiceFilme) + "- GENERO: " + generoFilme
											+ ", FILME: " + nomeFilme + ", SINÓPSE: " + sinopse);
								}
								System.out.println(
										"--------------------------------------------------------------------------------------------------");

								// Abre lista para escolha do filme

								escolhaFilmesDaListaUsuario.add(exterminadorDoFuturo);
								escolhaFilmesDaListaUsuario.add(clubeDaLuta);
								escolhaFilmesDaListaUsuario.add(oLoboDeWallStreet);
								escolhaFilmesDaListaUsuario.add(ameliePoulain);
								escolhaFilmesDaListaUsuario.add(crepusculo);
								escolhaFilmesDaListaUsuario.add(harryPotter);

								boolean stopWhileNovoFilme = false;
								// while (!stopWhileNovoFilme) {

								for (int k = secaoUsuario; k < cadastroContas.size(); k++) {

									System.out.print("Olá " + cadastroContas.get(k).getNomeConta()
											+ ", escolha um dos filmes para você assistir: ");
									escolhaFilme = sc.nextInt() - 1;
									sc.nextLine();

									contaPrincipal.escolhaDoFilme(escolhaFilmesDaListaUsuario, escolhaFilme);
									generosMaisUsuarios.generosMaisAssistidosUsuario(escolhaFilmesDaListaUsuario,
											escolhaFilme, secaoUsuario);
									generosMaisPlataforma.generosMaisAssistidosPlataforma(escolhaFilmesDaListaUsuario,
											escolhaFilme, secaoUsuario);

									String filmeEscolhidoUsuario = escolhaFilmesDaListaUsuario.get(escolhaFilme)
											.getNome();
									armazenaNomeFilmeUsuario.add(filmeEscolhidoUsuario);
									quantidadeVezesEscolhaFilme++;

//										System.out.println("\nDeseja escolher mais algum filme?1- SIM, 2- NÃO");
//										System.out.print("-->");
//										int maisFilmes = sc.nextInt();
//
//										if (maisFilmes == 1) {
//											stopWhileNovoFilme = false;
//										} else if (maisFilmes == 2) {
//											stopWhileNovoFilme = true;
//											
//
//										} else {
//											System.out.println("\nPor gentileza, digite uma opção válida.\n");
//										}
									break;
								}

								for (int k = secaoUsuario; k < cadastroContas.size(); k++) {

									exibeCampoSugestaoUsuario.likeDeslike(cadastroContas.get(k).getNomeConta());

									break;
								}

								// Exibe a lista de usuários, para que o usuário da secao possa escolher outros
								// usuários para indicar filmes
								int escolha = 0;
								boolean usuarioRecomenda = true;
								boolean stopWhileRecomenda = true;
								int controleEnunciado = secaoUsuario;

								while (usuarioRecomenda) {

									if (cadastroContas.size() > 1) {

										for (int k = controlaListaUsuarios; k < cadastroContas.size(); k++) {
											if (secaoUsuario == k) {
												/**
												 * Impede que o usuário vizualize ele mesmo para recomendar filmes,
												 * permite que o indice dele nao seja exibido enquanto usa o sistema
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

												for (int l = k; l < cadastroContas.size();) {

													nomeUsuarioLista = cadastroContas.get(l).getNomeConta();

													System.out.println((l + 1) + "- " + nomeUsuarioLista);
													controleLista = 2;
													usuarioRecomenda = false;
													break;

												}

											}
										}

									} else {
										break;
									}

								}

								if (controleLista == 2) {
									System.out.print("-->");
									escolha = sc.nextInt();

									for (int l = 0; l < cadastroContas.size(); l++) {
										if (escolha <= cadastroContas.size()) {
											System.out.println(
													"Você escolheu " + cadastroContas.get(escolha - 1).getNomeConta());
											System.out.println(
													"----------------------------------------------------------------------------");

											contaPrincipal.usuarioRecomenda();

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

								// }

								System.out.println(
										"\nDeseja fazer um comentário do filme que você acabou de assisti?\n1- SIM\n2- Não\n-->");

								int fazerComentario = sc.nextInt();

								if (fazerComentario == 1) {

									for (int k = secaoUsuario; k < cadastroContas.size(); k++) {

										System.out.print("Digite o seu comentário: ");

										comentarios.fazerComentarioFilme();
										comentarioUsuario = comentarios.getComentario();
										armazenaComentariosUsuario.add(cadastroContas.get(k).getNomeConta() + " fez um comentário sobre o filme " + escolhaFilmesDaListaUsuario.get(escolhaFilme).getNome() + ": " + fazerComentario);

										break;
									}

								} else {

									System.out.println("\nMuito obrigado por usar o DevInFlix\n");
								}

								System.out.println(
										"\n----------------------------------------------------------------------------\n");

								// secaoUsuario = i;
								checkLoginConta = true;
								break;
							} else {
								System.out.println(
										"Parece que houve um problema com o pagamento da mensalidade, retorne ao cadastro e verifique o pagamento.");

								checkLoginConta = false;
								checkLoginPerfil = false;
							}

						} else {

							checkLoginConta = false;

						}

					}

					checkLoginPerfil = false;
					chaveLogin = null;

					ativaRelatorio = 0;
				}

				// Perfil
				if (checkLoginPerfil == true) {
					for (int i = 0; i < cadastroPerfis.size(); i++) {

						if (cadastroPerfis.get(i).getChaveCadastroPerfil().equals(chaveLogin)) {

							System.out.println("Está com " + cadastroPerfis.get(i).getNomePerfil());

							System.out.println(
									"--------------------------------------------------------------------------------------------------");

							int controleLista = 0;

							if (pagamento == true) {
								System.out.println(
										"\nSeja bem-vindo ao DevInFlix, abaixo você pode conferir nosso catálogo de filmes\n");

								int indiceFilme = 0;
								for (FilmePlataforma filme : listaDeFilmes) {
									String nomeFilme = filme.getNome();
									String sinopse = filme.getSinopse();
									String generoFilme = filme.getGenero();
									indiceFilme++;

									System.out.println("OPÇÃO " + (indiceFilme) + "- GENERO: " + generoFilme
											+ ", FILME: " + nomeFilme + ", SINÓPSE: " + sinopse);
								}
								System.out.println(
										"--------------------------------------------------------------------------------------------------");

								// Abre lista para escolha do filme

								escolhaFilmesDaListaPerfil.add(exterminadorDoFuturo);
								escolhaFilmesDaListaPerfil.add(clubeDaLuta);
								escolhaFilmesDaListaPerfil.add(oLoboDeWallStreet);
								escolhaFilmesDaListaPerfil.add(ameliePoulain);
								escolhaFilmesDaListaPerfil.add(crepusculo);
								escolhaFilmesDaListaPerfil.add(harryPotter);

								boolean stopWhileNovoFilme = false;
								// while (!stopWhileNovoFilme) {

								for (int k = secaoPerfil; k < cadastroPerfis.size(); k++) {

									System.out.print("Olá " + cadastroPerfis.get(k).getNomePerfil()
											+ ", escolha um dos filmes para você assistir: ");
									escolhaFilme = sc.nextInt() - 1;
									sc.nextLine();

									// metodo escolha filme

									//escolhaFilmePerfil.add(escolhaFilme);
									contaSecundaria.escolhaDoFilme(escolhaFilmesDaListaPerfil, escolhaFilme);
									generosMaisUsuarios.generosMaisAssistidosUsuario(escolhaFilmesDaListaPerfil,
											escolhaFilme, secaoPerfil);
									generosMaisPlataforma.generosMaisAssistidosPlataforma(escolhaFilmesDaListaPerfil,
											escolhaFilme, secaoPerfil);

									String filmeEscolhidoPerfil = escolhaFilmesDaListaPerfil.get(escolhaFilme).getNome();
									armazenaNomeFilmePerfil.add(filmeEscolhidoPerfil);

									quantidadeVezesEscolhaFilme++;

//										System.out.println("\nDeseja escolher mais algum filme?1- SIM, 2- NÃO");
//										System.out.print("-->");
//										int maisFilmes = sc.nextInt();
//
//										if (maisFilmes == 1) {
//											stopWhileNovoFilme = false;
//										} else if (maisFilmes == 2) {
//											stopWhileNovoFilme = true;
//											
//
//										} else {
//											System.out.println("\nPor gentileza, digite uma opção válida.\n");
//										}
									break;
								}

								for (int k = secaoPerfil; k < cadastroPerfis.size(); k++) {

									exibeCampoSugestaoUsuario.likeDeslike(cadastroPerfis.get(k).getNomePerfil());

									break;
								}

								// Exibe a lista de usuários, para que o usuário da secao possa escolher outros
								// usuários para indicar filmes
								int escolha = 0;
								boolean usuarioRecomenda = true;
								boolean stopWhileRecomenda = true;
								int controleEnunciado = secaoPerfil;

								while (usuarioRecomenda) {

									if (cadastroPerfis.size() > 1) {

										for (int k = controlaListaUsuarios; k < cadastroPerfis.size(); k++) {
											if (secaoPerfil == k) {
												/**
												 * Impede que o usuário vizualize ele mesmo para recomendar filmes,
												 * permite que o indice dele nao seja exibido enquanto usa o sistema
												 */

											} else {

												if (controleEnunciado == secaoPerfil) {

													System.out.println(
															"----------------------------------------------------------------------------\n");
													System.out.println(
															"Agora precisamos que você selecione um dos usuários listados abaixo e faça uma recomendação de filme\n");
													System.out.println(
															"Lembrando que você só pode fazer uma recomendação por mês :)");
												}
												controleEnunciado++;

												for (int l = k; l < cadastroPerfis.size();) {

													nomeUsuarioLista = cadastroPerfis.get(l).getNomePerfil();

													System.out.println((l + 1) + "- " + nomeUsuarioLista);
													controleLista = 2;
													usuarioRecomenda = false;
													break;

												}

											}
										}

									} else {
										break;
									}

								}

								if (controleLista == 2) {
									System.out.print("-->");
									escolha = sc.nextInt();

									for (int l = 0; l < cadastroPerfis.size(); l++) {
										if (escolha <= cadastroPerfis.size()) {
											System.out.println(
													"Você escolheu " + cadastroPerfis.get(escolha - 1).getNomePerfil());
											System.out.println(
													"----------------------------------------------------------------------------");

											contaSecundaria.usuarioRecomenda();

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

								System.out.println(
										"\nDeseja fazer um comentário do filme que você acabou de assisti?\n1- SIM\n2- Não\n-->");

								int fazerComentario = sc.nextInt();

								if (fazerComentario == 1) {

									for (int k = secaoPerfil; k < cadastroPerfis.size(); k++) {

										System.out.print("Digite o seu comentário: ");

										comentarios.fazerComentarioFilme();
										armazenaComentariosPerfil.add(cadastroPerfis.get(k).getNomePerfil() + " fez um comentário sobre o filme " + escolhaFilmesDaListaPerfil.get(escolhaFilme).getNome() + ": " + fazerComentario);

										break;
									}

								} else {

									System.out.println("\nMuito obrigado por usar o DevInFlix\n");
								}

								System.out.println(
										"\n----------------------------------------------------------------------------\n");

								// secaoUsuario = i;
								checkLoginPerfil = true;
								break;

							} else {
								System.out.println(
										"Parece que houve um problema com o pagamento da mensalidade, retorne ao cadastro e verifique o pagamento.");

								checkLoginConta = false;
								checkLoginPerfil = false;
							}

						} else {

							checkLoginPerfil = false;

						}

					}

					checkLoginConta = false;
					chaveLogin = null;
					ativaRelatorio = 1;

				}

				// ######### Relatórios##########

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

				// verificar

				if (ativaRelatorio == 0) {
					for (int i = secaoUsuario; i < cadastroContas.size(); i++) {

						// if (cadastroContas.get(i).getChaveCadastroConta().equals(chaveLogin)) {

						System.out.println(
								"Os generos mais assistidos por " + cadastroContas.get(i).getNomeConta() + " são:");
						comparaGenerosMaisUsuarios.generoMaisUsuario();

						break;

						// }

					}

				} else {
					for (int j = secaoPerfil; j < cadastroPerfis.size(); j++) {
						// if (cadastroPerfis.get(j).getChaveCadastroPerfil().equals(chaveLogin)) {

						System.out.println(
								"Os generos mais assistidos por " + cadastroPerfis.get(j).getNomePerfil() + " são:");
						comparaGenerosMaisUsuarios.generoMaisUsuario();

						break;
						// }

					}
				}

				System.out.println("\nOs generos mais assistidos do DevInFlix são:");
				comparaGenerosMaisPlataforma.generoMaisPlataforma();

				System.out.println("\nFilmes curtidos e descurtidos pelos usuários\n");

				for (int i = 0; i < armazenaNomeUsuario.size(); i++) {

					curtidasEDescurtidasUsuario.add(exibeCampoSugestaoUsuario.getCurtidasDescurtidas());

					if (curtidasEDescurtidasUsuario.get(i) == 1) {
						System.out.print(armazenaNomeUsuario.get(i) + " deu like no ");
					} else if (curtidasEDescurtidasUsuario.get(i) == 2) {
						System.out.print(armazenaNomeUsuario.get(i) + " deu deslike no ");
					} else {
						// não exibe o usuário que não curtiu e nem descurtiu o filme

					}

					for (int j = i; j < armazenaNomeFilmeUsuario.size(); j++) {

						if (curtidasEDescurtidasUsuario.get(i) >= 1 && curtidasEDescurtidasUsuario.get(i) <= 2) {
							System.out.println("filme " + armazenaNomeFilmeUsuario.get(j));
							break;

						} else {
							break;
						}
					}
					continue;
				}

				for (int i = 0; i < armazenaNomePerfil.size(); i++) {

					curtidasEDescurtidasPerfil.add(exibeCampoSugestaoUsuario.getCurtidasDescurtidas());

					if (curtidasEDescurtidasPerfil.get(i) == 1) {
						System.out.print(armazenaNomePerfil.get(i) + " deu like no ");
					} else if (curtidasEDescurtidasPerfil.get(i) == 2) {
						System.out.print(armazenaNomePerfil.get(i) + " deu deslike no ");
					} else {
						// não exibe o usuário que não curtiu e nem descurtiu o filme

					}

					for (int j = i; j < armazenaNomeFilmePerfil.size(); j++) {

						if (curtidasEDescurtidasPerfil.get(i) >= 1 && curtidasEDescurtidasPerfil.get(i) <= 2) {
							System.out.println("filme " + armazenaNomeFilmePerfil.get(j));
							break;

						} else {
							break;
						}
					}
					continue;
				}

				System.out.println("\n----------------------------------------------------------------------------\n");

				System.out.println("\nComentários dos usuários\n");
				
			
				
				//comentarios.armazenaComentarios(cadastroContas.get(secaoUsuario).getNomeConta(), escolhaFilmesDaListaUsuario.get(escolhaFilme).getNome(), filmeComentario);
				
				for (String comentariosUsuarios : armazenaComentariosUsuario) {
					
					System.out.println(comentariosUsuarios);
				}
				
				for (String comentariosPerfis : armazenaComentariosPerfil) {
					
					System.out.println(comentariosPerfis);
				}

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

				// secaoUsuario++;

				// Verificar....
				controlaNumeroDePerfis = 0;

				break;

//#####################################################################################################################################################

			case 3:

				System.out.println("\nMuito obrigado por usar o DevInFlix");
				menuGeral = true;

				break;
//#####################################################################################################################################################

			default:

				System.out.println("\nDigite uma opção válida!\n");
			}

		}
	}

	// Futuro menu para impressao de relatórios
	@Override
	public void menuAdministrador() {
		// TODO Auto-generated method stub

	}

}
