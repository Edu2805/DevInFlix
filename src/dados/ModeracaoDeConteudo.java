package dados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ModeracaoDeConteudo implements Moderavel{
	
	
	private String interacaoUsuarios;
	private String comentariosUsuarios;
	private boolean verificaModeracao;
	
	
	@Override
	public boolean moderacaoComentario(String comentariosUsuarios) {
		
		Scanner sc = new Scanner(System.in);
		List <String> listaPalavrasProibidas = new ArrayList<String>();
		String palavrasProibidasComentarios;
		
		for (int i = 0; ; i++) {
			
			palavrasProibidasComentarios = sc.nextLine();
			String conversaoModeracao = palavrasProibidasComentarios.toLowerCase();
			
			listaPalavrasProibidas.add(conversaoModeracao);
			if(palavrasProibidasComentarios.contains("sair") == true) {
				
				break;
			}
			
		}
		
		String conversaoComentario = comentariosUsuarios.toLowerCase();
		for (String moderacoes : listaPalavrasProibidas) {
			
			if(moderacoes.contains(conversaoComentario) == true) {
				
				verificaModeracao = true;
				
			}
			
		}
		return verificaModeracao;
		
	}


	@Override
	public boolean moderacaoConteudo(String interacaoUsuarios) {
		
		String palavrasProibidasConteudos;
		
		return false;
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


	public boolean isVerificaModeracao() {
		return verificaModeracao;
	}


	public void setVerificaModeracao(boolean verificaModeracao) {
		this.verificaModeracao = verificaModeracao;
	}
	
	
}
