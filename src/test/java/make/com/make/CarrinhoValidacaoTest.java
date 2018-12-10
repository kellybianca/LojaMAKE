package make.com.make;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import make.com.make.servico.CarrinhoValidacao;

public class CarrinhoValidacaoTest {

	/*
	 * 
	 * String cliente,String tipoPagamento, String item, CharSequence valor
	 */
	
	@Test
	public void naoPodeValidarNomeESobrenomeEscritosSemEspaco() {
		CarrinhoValidacao carrinho = new CarrinhoValidacao();

		String cliente = "AnaMariaBraga";
		String tipoPagamento = "Boleto";
		String item = "Toalha";
		CharSequence valor = "250.00";
		
		boolean ehUsuarioValido = carrinho.validarUsuario(cliente, tipoPagamento, item, valor);
		
		assertEquals(false, ehUsuarioValido);
	}
	
	@Test
	public void naoPermitirSemAFormaDePagamento() {
		CarrinhoValidacao carrinho = new CarrinhoValidacao();

		String cliente = "Ana Maria Braga";
		String tipoPagamento = " ";
		String item = "Toalha";
		CharSequence valor = "250.00";
		
		boolean ehUsuarioValido = carrinho.validarUsuario(cliente, tipoPagamento, item, valor);
		
		assertEquals(true, ehUsuarioValido);
	}
	
	@Test
	public void naoPermitirSemItem() {
		CarrinhoValidacao carrinho = new CarrinhoValidacao();

		String cliente = "Ana Maria Braga";
		String tipoPagamento = "Boleto";
		String item = " ";
		CharSequence valor = "250.00";
		
		boolean ehUsuarioValido = carrinho.validarUsuario(cliente, tipoPagamento, item, valor);
		
		assertEquals(true, ehUsuarioValido);
	}
	
	@Test
	public void naoPermitirSemValorr() {
		CarrinhoValidacao carrinho = new CarrinhoValidacao();

		String cliente = "Ana Maria Braga";
		String tipoPagamento = "Boleto";
		String item = "Toalha";
		CharSequence valor = " ";
		
		boolean ehUsuarioValido = carrinho.validarUsuario(cliente, tipoPagamento, item, valor);
		
		assertEquals(true, ehUsuarioValido);
	}
		
	@Test
	public void permitirValidarComTudoCorreto() {
		CarrinhoValidacao carrinho = new CarrinhoValidacao();

		String cliente = "Ana Maria Braga";
		String tipoPagamento = "Boleto";
		String item = "Toalha";
		CharSequence valor = "250.00";
		
		boolean ehUsuarioValido = carrinho.validarUsuario(cliente, tipoPagamento, item, valor);
		
		
		assertEquals(true, ehUsuarioValido);
	}
}
