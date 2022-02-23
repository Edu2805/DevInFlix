package interatividades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import filmes.FilmePlataforma;
import informacoesDeAcesso.ContaPerfis;
import usuarios.ContaPessoaFisica;

public class Comentarios {

	private String comentario;
	private String improprio;

	public Comentarios() {

	}

	public String fazerComentarioFilme() {
		Scanner sc = new Scanner(System.in);

		String comentario = sc.nextLine();

		return this.comentario = comentario;
	}

	public String armazenaComentarios(String nome, String filme, String comentario){
		
		String dadosComentarios = null;
		
		List<String> comentarios = new ArrayList<String>();
		
		comentarios.add(nome + " fez um comentário sobre o filme " + filme + ": " + comentario);
		
		for (String comentariosUsuarios : comentarios) {
			
			dadosComentarios = comentariosUsuarios;
		}
		
		return dadosComentarios;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getImproprio() {
		return improprio;
	}

	public void setImproprio(String improprio) {
		this.improprio = improprio;
	}
	
	
	
}
