package filmes;

import generos.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Colecao {

	private int id;
	private String nome;
	private String sinopse;
	private String genero;
	private String Link;
	
}
