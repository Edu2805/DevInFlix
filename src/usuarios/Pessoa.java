package usuarios;

import java.time.Period;
import java.util.List;

import informacoesDeAcesso.Conta;
import lombok.AllArgsConstructor;
import lombok.Data;


public abstract class Pessoa {

	protected String nomeCompleto;
	protected String enderecoCompleto;
	protected Period idade;
	protected String eMail;
	protected String senha;
	protected String chaveCadastro;
	protected boolean statusPagamento;
	protected List<Conta> contaSecundaria;
	protected final int numeroPefisConta = 3;
	
	
	public Pessoa(String nomeCompleto, String enderecoCompleto, Period idade, String eMail, String senha,
			String chaveCadastro, boolean statusPagamento, List<Conta> contaSecundaria) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.enderecoCompleto = enderecoCompleto;
		this.idade = idade;
		this.eMail = eMail;
		this.senha = senha;
		this.chaveCadastro = chaveCadastro;
		this.statusPagamento = statusPagamento;
		this.contaSecundaria = contaSecundaria;
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}


	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}


	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}


	public Period getIdade() {
		return idade;
	}


	public void setIdade(Period idade) {
		this.idade = idade;
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


	public String getChaveCadastro() {
		return chaveCadastro;
	}


	public void setChaveCadastro(String chaveCadastro) {
		this.chaveCadastro = chaveCadastro;
	}


	public boolean isStatusPagamento() {
		return statusPagamento;
	}


	public void setStatusPagamento(boolean statusPagamento) {
		this.statusPagamento = statusPagamento;
	}


	public List<Conta> getContaSecundaria() {
		return contaSecundaria;
	}


	public void setContaSecundaria(List<Conta> contaSecundaria) {
		this.contaSecundaria = contaSecundaria;
	}


	public int getNumeroPefisConta() {
		return numeroPefisConta;
	}
	
	
	
}
