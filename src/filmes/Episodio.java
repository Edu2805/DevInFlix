package filmes;

import java.time.LocalDate;

public class Episodio {
	
	private String nome;
	private int numero;
	private String url;
	LocalDate dataLancamento;
	
	public Episodio(String nome, int numero, String url, LocalDate dataLancamento) {
		this.nome = nome;
		this.numero = numero;
		this.url = url;
		this.dataLancamento = dataLancamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
}
