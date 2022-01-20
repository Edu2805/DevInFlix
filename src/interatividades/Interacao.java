package interatividades;

import java.util.Scanner;

public class Interacao implements SugestaoUsuarios {

	@Override
	public String sugestaoDoUuario() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"\nPara tornar o DevInFlix ainda mais incrível, você gostaria de nos informar um filme que gostaria de ver em nossa plataforma?\n1- Para SIM\n2- Para NÃO");
		
		int entraMenuIndicacao = 0;
		System.out.println("-->");
		entraMenuIndicacao = sc.nextInt();
		String nomeFilmeSuherido = "";
		
		sc.nextLine();
		while(entraMenuIndicacao != 2) {
			
			System.out.print("\nDigite o nome do filme: ");
			nomeFilmeSuherido = sc.nextLine();
			break;
		}
		System.out.println("----------------------------------------------------------------------------");
		return nomeFilmeSuherido;
	}
}
