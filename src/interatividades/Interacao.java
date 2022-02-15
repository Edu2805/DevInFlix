package interatividades;

import java.util.LinkedHashSet;
import java.util.Scanner;

import filmes.FilmeSugestaoUsuario;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import usuarios.PessoaFisica;


public class Interacao implements SugestaoUsuarios, CurtirDescurtir {

	private String nomeFilmeSugerido;
	private String nomeCompleto;
	private int curtidasDescurtidas;

	@Override
	public String sugestaoDoUsuario() {

		Scanner sc = new Scanner(System.in);
		System.out.println(
				"\nPara tornar o DevInFlix ainda mais incrível, você gostaria de nos informar um filme que gostaria de ver em nossa plataforma?\n1- Para SIM\n2- Para NÃO");

		int entraMenuIndicacao = 0;
		System.out.println("-->");
		entraMenuIndicacao = sc.nextInt();

		sc.nextLine();
		while (entraMenuIndicacao != 2) {

			System.out.print("\nDigite o nome do filme: ");
			nomeFilmeSugerido = sc.nextLine();

			break;
		}
		System.out.println("----------------------------------------------------------------------------");

		return nomeFilmeSugerido;
	}

	@Override
	public int likeDeslike(String nomeCompleto) {
		Scanner sc = new Scanner(System.in);

		int escolha = 0;
		int contCurtidas = 0;
		int contDescurtidas = 0;

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
				curtidasDescurtidas = 0;
				break;

			} else {
				System.out.println("Por gentileza, digite uma das opções listadas.");
			}

			if (curtidasDescurtidas == 1 || curtidasDescurtidas == 2) {
				break;
			}
		}
		return curtidasDescurtidas;
	}

	public String getNomeFilmeSugerido() {
		return nomeFilmeSugerido;
	}

	public void setNomeFilmeSugerido(String nomeFilmeSugerido) {
		this.nomeFilmeSugerido = nomeFilmeSugerido;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public int getCurtidasDescurtidas() {
		return curtidasDescurtidas;
	}

	public void setCurtidasDescurtidas(int curtidasDescurtidas) {
		this.curtidasDescurtidas = curtidasDescurtidas;
	}
	
	
	
}
