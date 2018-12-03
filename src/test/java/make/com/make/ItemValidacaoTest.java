package make.com.make;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import make.com.make.servico.ItemValidacao;

public class ItemValidacaoTest {
	
	@Test
	public void naoPodeValidarNomeComNumeros() {
		ItemValidacao item = new ItemValidacao();

		String produto = "Garrafa Termica 123 São bento";
		int quantidade = 3;
		Double valor = 30.00;
		
		boolean ehUsuarioValido = item.validarItem(produto, quantidade, valor);
		
		assertEquals(false, ehUsuarioValido);
	}
	
	@Test
	public void naoPodeValidarNomeEscritoSemEspaco() {
		ItemValidacao item = new ItemValidacao();

		String produto = "GarrafaTermicaSaoBento";
		int quantidade = 3;
		Double valor = 30.00;
		
		boolean ehUsuarioValido = item.validarItem(produto, quantidade, valor);
		
		assertEquals(false, ehUsuarioValido);
	}
	
	@Test
	public void permitirValidarComTudoCorreto() {
		ItemValidacao item = new ItemValidacao();

		String produto = "Garrafa Termica Sao Bento";
		int quantidade = 3;
		Double valor = 30.00;
		
		boolean ehUsuarioValido = item.validarItem(produto, quantidade, valor);
		
		assertEquals(false, ehUsuarioValido);
	}
	
}
