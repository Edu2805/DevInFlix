package dados;

import java.util.List;

import filmes.FilmePlataforma;
import lombok.AllArgsConstructor;
import lombok.Data;
import usuarios.PessoaFisica;

@Data

public class DadosCurtidasDescurtidas {

	
	private String nomeUsuario;
	private String nomeFilme;
	private int escolhaFilme;
	private int indexSecaoUsuario;
	private int indexSecaoFilme;
	
	
	public void relatorioCurtidas (List<FilmePlataforma> filmes, List<PessoaFisica> pessoaFisica, int escolhaFilme, int indexSecaoUsuario, int indexSecaoFilme) {
		
		for (int i = indexSecaoUsuario; i < pessoaFisica.size(); i++) {
			
			nomeUsuario = pessoaFisica.get(i).getNomeCompleto();
			for (int j = indexSecaoFilme; j < filmes.size(); j++) {
				
				if(j == escolhaFilme & i == indexSecaoUsuario) {
					
					nomeFilme = filmes.get(j).getNome();
					break;
				}
			}
		}
		
		//System.out.println("Nome: " + nomeUsuario + ", Filme: " + nomeFilme);
	}
}
