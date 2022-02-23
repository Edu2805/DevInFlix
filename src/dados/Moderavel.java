package dados;

import interatividades.Comentarios;
import interatividades.Interacao;

public interface Moderavel {
	

	public boolean moderacaoComentario(String comentariosUsuarios);
	public boolean moderacaoConteudo(String interacaoUsuarios);

}
