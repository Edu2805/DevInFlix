package financeiro;

import java.util.Scanner;

public class Financeiro {
	
	protected boolean pagamento;

	public boolean verificaMensalidade(int escolheFormaPagamento) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			switch (escolheFormaPagamento) {
			case 1:
				System.out.println("Você irá pagar com cartão de crédito");
				return pagamento = true;
			case 2:
				System.out.println("Você irá pagar com PIX");
				return pagamento = true;
			case 3:
				System.out.println("Você irá pagar com Boleto");
				return pagamento = true;
			case 4:
				System.out.println("Não deixe de acertar a sua forma de pagamento para desfrutar de nosso catálogo!");
				return pagamento = false;
			default:
				System.out.println("\nForma de pagamento inválida\n");
				return pagamento = false;
			}
		}
	}

	public boolean isPagamento() {
		return pagamento;
	}

	public void setPagamento(boolean pagamento) {
		this.pagamento = pagamento;
	}
	
}
