package dados;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

import generos.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SomaGenerosUsuarios {

	int acao;
	int aventura;
	int romance;
	int cartoon;
	int drama;
	int documentario;
	int independentes;
	int suspense;
	int outros;

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
}
