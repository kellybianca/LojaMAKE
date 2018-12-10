package make.com.make;



import org.junit.Test;

import make.com.make.servico.FreteValidacao;

public class FreteValidacaoTest {
	
	@Test
	public void naoPodeValidarComNomeSemEspaco() {
		FreteValidacao frete = new FreteValidacao();
		
		String cliente = "EricaBeatriz";
		CharSequence cep = "1215454";
		CharSequence valor = "50.00";
		String endereco = "Graciliano Ramos";
		
		boolean ehUsuarioValido = frete.validarUsuario(cliente, cep, valor, endereco);
		
		assertEquals(false, ehUsuarioValido);
	}
	
	private void assertEquals(boolean b, boolean ehUsuarioValido) {
		
	}

	@Test
	public void naoPodeValidarCepComCaractere() {
		FreteValidacao frete = new FreteValidacao();
		
		String cliente = "Erica Beatriz";
		CharSequence cep = "121545-4";
		CharSequence valor = "50.00";
		String endereco = "Graciliano Ramos";
		
		boolean ehUsuarioValido = frete.validarUsuario(cliente, cep, valor, endereco);
		
		assertEquals(false, ehUsuarioValido);
	}
	
	@Test
	public void naoPodeValidarEnderecoSemEspaco() {
		FreteValidacao frete = new FreteValidacao();
		
		String cliente = "Erica Beatriz";
		CharSequence cep = "1215454";
		CharSequence valor = "50.00";
		String endereco = "GracilianoRamos";
		
		boolean ehUsuarioValido = frete.validarUsuario(cliente, cep, valor, endereco);
		
		assertEquals(false, ehUsuarioValido);
	}
	
	@Test
	public void podeValidarComTudoCerto() {
		FreteValidacao frete = new FreteValidacao();
		
		String cliente = "Erica Beatriz";
		CharSequence cep = "1215454";
		CharSequence valor = "50.00";
		String endereco = "Graciliano Ramos";
		
		boolean ehUsuarioValido = frete.validarUsuario(cliente, cep, valor, endereco);
		
		assertEquals(true, ehUsuarioValido);
	}
}
