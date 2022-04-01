package interatividades;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;

import filmes.FilmePlataforma;

public interface EscolheFilme {
	
	public int escolhaDoFilme(List<FilmePlataforma> filmes, int escolha, Period period);
}
