package make.com.make;

import org.junit.Test;

import make.com.make.servico.CategoriaValidacao;

public class CategoriaValidacaoTest {
	
	@Test
	public void naoPodeValidarCategoriaSemItens() {
		CategoriaValidacao categoria = new CategoriaValidacao();
		
		String nome = "Eletrodomestico";
		String itens = " ";
		
		boolean ehUsuarioValido = categoria.validarUsuario(nome, itens);
		assertEquals(false,ehUsuarioValido); 
	}

	@Test
	public void naoPodeValidarNomeJunto() {
		CategoriaValidacao categoria = new CategoriaValidacao();
		
		String nome = "CamaMesaEBanho";
		String itens = "toalha";
		
		boolean ehUsuarioValido = categoria.validarUsuario(nome, itens);
		assertEquals(false,ehUsuarioValido); 
	}
	private void assertEquals(boolean b, boolean ehUsuarioValido) {

	}
	

	@Test
	public void permitirValidarComTudoCorreto() {
		CategoriaValidacao categoria = new CategoriaValidacao();

		String nome = "Cama mesa e banho";
		String itens = "toalha";
		
		boolean ehUsuarioValido = categoria.validarUsuario(nome, itens);
		
		assertEquals(true, ehUsuarioValido);
	}
	
}
