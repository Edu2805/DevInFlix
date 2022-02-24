package dados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author eduardoamorim
 *
 */
public class ModeracaoDeConteudo implements Moderavel {

	private String interacaoUsuarios;
	private String comentariosUsuarios;
	private boolean verificaModeracaoUsuarioComentario;
	private boolean verificaModeracaoPerfilComentario;
	private boolean verificaModeracaoUsuarioConteudo;
	private boolean verificaModeracaoPerfilConteudo;
	private String palavrasProibidas;
	private List<String> listaPalavrasProibidas;

	public ModeracaoDeConteudo() {

	}

	@Override
	public boolean moderacaoComentarioUsuario(String comentariosUsuarios) {

		verificaModeracaoUsuarioComentario = false;

		Scanner sc = new Scanner(System.in);
		listaPalavrasProibidas = new ArrayList<String>();

		for (int i = 0;; i++) {

			System.out.print("--> ");
			palavrasProibidas = sc.nextLine();

			if (palavrasProibidas.toLowerCase().contains("sair") == true) {

				break;
			} else {

				listaPalavrasProibidas.add(palavrasProibidas.toLowerCase());

			}

		}

		for (String moderacoes : listaPalavrasProibidas) {

			if (comentariosUsuarios.toLowerCase().contains(moderacoes) == true) {

				verificaModeracaoUsuarioComentario = true;
				break;

			}

		}
		return verificaModeracaoUsuarioComentario;

	}

	@Override
	public boolean moderacaoComentarioPerfil(String comentariosPerfil) {

		verificaModeracaoPerfilComentario = false;

		listaPalavrasProibidas.add(palavrasProibidas.toLowerCase());

		for (String moderacoes : listaPalavrasProibidas) {

			if (comentariosPerfil.toLowerCase().contains(moderacoes) == true) {

				verificaModeracaoPerfilComentario = true;
				break;

			}
		}
		return verificaModeracaoPerfilComentario;
	}

	@Override
	public boolean moderacaoConteudoUsuario(String interacaoUsuarios) {

		verificaModeracaoUsuarioConteudo = false;

		listaPalavrasProibidas.add(palavrasProibidas.toLowerCase());

		for (String moderacoes : listaPalavrasProibidas) {

			if (interacaoUsuarios.toLowerCase().contains(moderacoes) == true) {

				verificaModeracaoUsuarioConteudo = true;
				break;

			}

		}
		return verificaModeracaoUsuarioConteudo;
	}

	@Override
	public boolean moderacaoConteudoPerfil(String interacaoPerfil) {

		verificaModeracaoPerfilConteudo = false;

		listaPalavrasProibidas.add(palavrasProibidas.toLowerCase());

		for (String moderacoes : listaPalavrasProibidas) {

			if (interacaoPerfil.toLowerCase().contains(moderacoes) == true) {

				verificaModeracaoPerfilConteudo = true;
				break;

			}

		}
		return verificaModeracaoPerfilConteudo;

	}

	public String getInteracaoUsuarios() {
		return interacaoUsuarios;
	}

	public void setInteracaoUsuarios(String interacaoUsuarios) {
		this.interacaoUsuarios = interacaoUsuarios;
	}

	public String getComentariosUsuarios() {
		return comentariosUsuarios;
	}

	public void setComentariosUsuarios(String comentariosUsuarios) {
		this.comentariosUsuarios = comentariosUsuarios;
	}

	public boolean isVerificaModeracaoUsuarioComentario() {
		return verificaModeracaoUsuarioComentario;
	}

	public void setVerificaModeracaoUsuarioComentario(boolean verificaModeracaoUsuarioComentario) {
		this.verificaModeracaoUsuarioComentario = verificaModeracaoUsuarioComentario;
	}

	public boolean isVerificaModeracaoPerfilComentario() {
		return verificaModeracaoPerfilComentario;
	}

	public void setVerificaModeracaoPerfilComentario(boolean verificaModeracaoPerfilComentario) {
		this.verificaModeracaoPerfilComentario = verificaModeracaoPerfilComentario;
	}

	public boolean isVerificaModeracaoUsuarioConteudo() {
		return verificaModeracaoUsuarioConteudo;
	}

	public void setVerificaModeracaoUsuarioConteudo(boolean verificaModeracaoUsuarioConteudo) {
		this.verificaModeracaoUsuarioConteudo = verificaModeracaoUsuarioConteudo;
	}

	public boolean isVerificaModeracaoPerfilConteudo() {
		return verificaModeracaoPerfilConteudo;
	}

	public void setVerificaModeracaoPerfilConteudo(boolean verificaModeracaoPerfilConteudo) {
		this.verificaModeracaoPerfilConteudo = verificaModeracaoPerfilConteudo;
	}

	public List<String> getListaPalavrasProibidas() {
		return listaPalavrasProibidas;
	}

	public void setListaPalavrasProibidas(List<String> listaPalavrasProibidas) {
		this.listaPalavrasProibidas = listaPalavrasProibidas;
	}

	public String getPalavrasProibidasComentarios() {
		return palavrasProibidas;
	}

	public void setPalavrasProibidasComentarios(String palavrasProibidasComentarios) {
		this.palavrasProibidas = palavrasProibidasComentarios;
	}

}
