package usuarios;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Pessoa {

	protected String nomeCompleto;
	protected String enderecoCompleto;
	protected String dataNascimento;
	
}
