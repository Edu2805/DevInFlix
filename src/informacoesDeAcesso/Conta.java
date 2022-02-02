package informacoesDeAcesso;

import java.time.Period;

public class Conta {

	protected String nome;
	protected String endereco;
	protected Period idadeUsuario;
	protected String eMail;
	protected String senha;
	protected boolean statusPagamento;

	public Conta(String nome, String endereco, Period idadeUsuario, String eMail, String senha,
			boolean statusPagamento) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.idadeUsuario = idadeUsuario;
		this.eMail = eMail;
		this.senha = senha;
		this.statusPagamento = statusPagamento;
	}

	public Conta() {
		
	}
	
	public void perfilUsuario(int idadeUsuario, String eMail, String senha, boolean statusPagamento) {
			
	}


	public String geteMail() {
		return eMail;
	}


	public void seteMail(String eMail) {
		this.eMail = eMail;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public boolean isStatusPagamento() {
		return statusPagamento;
	}


	public void setStatusPagamento(boolean statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public Period getIdadeUsuario() {
		return idadeUsuario;
	}

	public void setIdadeUsuario(Period idadeUsuario) {
		this.idadeUsuario = idadeUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
