package dados;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

import generos.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;

public class SomaGenerosUsuarios {

	private int acao;
	private int aventura;
	private int romance;
	private int cartoon;
	private int drama;
	private int documentario;
	private int independentes;
	private int suspense;
	private int outros;

	
	
	public SomaGenerosUsuarios(int acao, int aventura, int romance, int cartoon, int drama, int documentario,
			int independentes, int suspense, int outros) {
		super();
		this.acao = acao;
		this.aventura = aventura;
		this.romance = romance;
		this.cartoon = cartoon;
		this.drama = drama;
		this.documentario = documentario;
		this.independentes = independentes;
		this.suspense = suspense;
		this.outros = outros;
	}

	public int generoMaisUsuario() {
		ArrayList<Integer> listaDeGeneros = new ArrayList<>();

		listaDeGeneros.add(acao);
		listaDeGeneros.add(aventura);
		listaDeGeneros.add(romance);
		listaDeGeneros.add(cartoon);
		listaDeGeneros.add(drama);
		listaDeGeneros.add(documentario);
		listaDeGeneros.add(independentes);
		listaDeGeneros.add(suspense);
		listaDeGeneros.add(outros);

		IntSummaryStatistics sumario = listaDeGeneros.stream().collect(Collectors.summarizingInt(Integer::intValue));

		int maiorNumeroUsuarios = sumario.getMax();

		System.out.println(Genero.ACAO.getDescricao() + ": " + listaDeGeneros.get(0).intValue());
		System.out.println(Genero.AVENTURA.getDescricao() + ": " + listaDeGeneros.get(1).intValue());
		System.out.println(Genero.ROMANCE.getDescricao() + ": " + listaDeGeneros.get(2).intValue());
		System.out.println(Genero.CARTOON.getDescricao() + ": " + listaDeGeneros.get(3).intValue());
		System.out.println(Genero.DRAMA.getDescricao() + ": " + listaDeGeneros.get(4).intValue());
		System.out.println(Genero.DOCUMENTARIO.getDescricao() + ": " + listaDeGeneros.get(5).intValue());
		System.out.println(Genero.INDEPENDENTES.getDescricao() + ": " + listaDeGeneros.get(6).intValue());
		System.out.println(Genero.SUSPENSE.getDescricao() + ": " + listaDeGeneros.get(7).intValue());
		System.out.println(Genero.OUTROS.getDescricao() + ": " + listaDeGeneros.get(8).intValue());

		return maiorNumeroUsuarios;
	}

	public int getAcao() {
		return acao;
	}

	public void setAcao(int acao) {
		this.acao = acao;
	}

	public int getAventura() {
		return aventura;
	}

	public void setAventura(int aventura) {
		this.aventura = aventura;
	}

	public int getRomance() {
		return romance;
	}

	public void setRomance(int romance) {
		this.romance = romance;
	}

	public int getCartoon() {
		return cartoon;
	}

	public void setCartoon(int cartoon) {
		this.cartoon = cartoon;
	}

	public int getDrama() {
		return drama;
	}

	public void setDrama(int drama) {
		this.drama = drama;
	}

	public int getDocumentario() {
		return documentario;
	}

	public void setDocumentario(int documentario) {
		this.documentario = documentario;
	}

	public int getIndependentes() {
		return independentes;
	}

	public void setIndependentes(int independentes) {
		this.independentes = independentes;
	}

	public int getSuspense() {
		return suspense;
	}

	public void setSuspense(int suspense) {
		this.suspense = suspense;
	}

	public int getOutros() {
		return outros;
	}

	public void setOutros(int outros) {
		this.outros = outros;
	}
	
}
