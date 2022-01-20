package interatividades;

import java.util.LinkedHashSet;
import java.util.Scanner;

import filmes.FilmeSugestaoUsuario;
import lombok.Data;

@Data
public class Interacao implements SugestaoUsuarios {

	String nomeFilmeSugerido;
	@Override
	public String sugestaoDoUsuario() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"\nPara tornar o DevInFlix ainda mais incrível, você gostaria de nos informar um filme que gostaria de ver em nossa plataforma?\n1- Para SIM\n2- Para NÃO");
		
		int entraMenuIndicacao = 0;
		System.out.println("-->");
		entraMenuIndicacao = sc.nextInt();
		
		sc.nextLine();
		while(entraMenuIndicacao != 2) {
			
			System.out.print("\nDigite o nome do filme: ");
			nomeFilmeSugerido = sc.nextLine();
			
			break;
		}
		System.out.println("----------------------------------------------------------------------------");
		
		return nomeFilmeSugerido;
	}
}
