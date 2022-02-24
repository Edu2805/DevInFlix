package dados;

import interatividades.Comentarios;
import interatividades.Interacao;

public interface Moderavel {
	

	public boolean moderacaoComentarioUsuario(String comentariosUsuarios);
	public boolean moderacaoComentarioPerfil(String comentariosPerfil);
	public boolean moderacaoConteudoUsuario(String interacaoUsuarios);
	public boolean moderacaoConteudoPerfil(String interacaoPerfil);

}
