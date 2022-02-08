package usuarios;

import java.time.Period;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Pessoa {

	protected String nomeCompleto;
	protected String enderecoCompleto;
	protected Period idade;
	protected String eMail;
	protected String senha;
	protected String chaveCadastro;
	protected boolean statusPagamento;
	
}
