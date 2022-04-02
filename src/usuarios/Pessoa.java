package usuarios;

import java.time.Period;
import java.util.List;

import informacoesDeAcesso.ContaPerfis;
import lombok.AllArgsConstructor;
import lombok.Data;


public abstract class Pessoa {

	protected String nomeConta;
	protected String enderecoConta;
	protected Period idadeConta;
	protected String eMailConta;
	protected String senhaConta;
	protected String chaveCadastroConta;
	protected boolean statusPagamento;
	protected List<ContaPerfis> contaSecundaria;
	protected final int numeroPefisConta = 5;
	
	
	public Pessoa(String nomeCompleto, String enderecoCompleto, Period idade, String eMail, String senha,
			String chaveCadastroConta, boolean statusPagamento, List<ContaPerfis> contaSecundaria) {
		super();
		this.nomeConta = nomeCompleto;
		this.enderecoConta = enderecoCompleto;
		this.idadeConta = idade;
		this.eMailConta = eMail;
		this.senhaConta = senha;
		this.chaveCadastroConta = chaveCadastroConta;
		this.statusPagamento = statusPagamento;
		this.contaSecundaria = contaSecundaria;
	}


	public String getNomeConta() {
		return nomeConta;
	}


	public void setNomeConta(String nomeCompleto) {
		this.nomeConta = nomeCompleto;
	}


	public String getEnderecoConta() {
		return enderecoConta;
	}


	public void setEnderecoConta(String enderecoCompleto) {
		this.enderecoConta = enderecoCompleto;
	}


	public Period getIdadeConta() {
		return idadeConta;
	}


	public void setIdadeConta(Period idade) {
		this.idadeConta = idade;
	}


	public String geteMailConta() {
		return eMailConta;
	}


	public void seteMailConta(String eMail) {
		this.eMailConta = eMail;
	}


	public String getSenhaConta() {
		return senhaConta;
	}


	public void setSenhaConta(String senha) {
		this.senhaConta = senha;
	}


	public String getChaveCadastroConta() {
		return chaveCadastroConta;
	}


	public void setChaveCadastroConta(String chaveCadastro) {
		this.chaveCadastroConta = chaveCadastro;
	}


	public boolean isStatusPagamento() {
		return statusPagamento;
	}


	public void setStatusPagamento(boolean statusPagamento) {
		this.statusPagamento = statusPagamento;
	}


	public List<ContaPerfis> getContaSecundaria() {
		return contaSecundaria;
	}


	public void setContaSecundaria(List<ContaPerfis> contaSecundaria) {
		this.contaSecundaria = contaSecundaria;
	}


	public int getNumeroPefisConta() {
		return numeroPefisConta;
	}
	
}
