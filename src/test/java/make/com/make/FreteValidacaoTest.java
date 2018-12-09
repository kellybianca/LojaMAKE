package make.com.make;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import make.com.make.servico.FreteValidacao;

public class FreteValidacaoTest {
	
	@Test
	public void naoPodeValidarComNomeSemEspaco() {
		FreteValidacao frete = new FreteValidacao();
		
		String cliente = "EricaBeatriz";
		long cep = 1215454;
		Double valor = 50.00;
		String endereco = "Graciliano Ramos";
		
		boolean ehUsuarioValido = frete.validarUsuario(cliente, cep, valor, endereco);
		
		assertEquals(false, ehUsuarioValido);
	}
	
	@Test
	public void naoPodeValidarCepComCaractere() {
		FreteValidacao frete = new FreteValidacao();
		
		String cliente = "Erica Beatriz";
		long cep = 123456-000;
		Double valor = 50.00;
		String endereco = "Graciliano Ramos";
		
		boolean ehUsuarioValido = frete.validarUsuario(cliente, cep, valor, endereco);
		
		assertEquals(false, ehUsuarioValido);
	}
	
	@Test
	public void naoPodeValidarEnderecoSemEspaco() {
		FreteValidacao frete = new FreteValidacao();
		
		String cliente = "Erica Beatriz";
		long cep = 1215454;
		Double valor = 50.00;
		String endereco = "GracilianoRamos";
		
		boolean ehUsuarioValido = frete.validarUsuario(cliente, cep, valor, endereco);
		
		assertEquals(false, ehUsuarioValido);
	}
	
	@Test
	public void podeValidarComTudoCerto() {
		FreteValidacao frete = new FreteValidacao();
		
		String cliente = "Erica Beatriz";
		long cep = 1215454;
		Double valor = 50.00;
		String endereco = "Graciliano Ramos";
		
		boolean ehUsuarioValido = frete.validarUsuario(cliente, cep, valor, endereco);
		
		assertEquals(true, ehUsuarioValido);
	}
}
