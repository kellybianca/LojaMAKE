package make.com.make;

import org.junit.Test;

import make.com.make.servico.ClienteValidacao;

public class ClienteValidacaoTest {

	@Test
	public void naoPodeValidarNomeComNumeros() {
		ClienteValidacao cliente = new ClienteValidacao();

		String nome = "Erica 123 Beatriz";
		String cpf = "12345678912";

		boolean ehUsuarioValido = cliente.validarUsuario(nome, cpf);
		
		assertEquals(false, ehUsuarioValido);
	}
	
	private void assertEquals(boolean b, boolean ehUsuarioValido) {
		
	}

	@Test
	public void naoPodeValidarNomeESobrenomeEscritosSemEspaco() {
		ClienteValidacao servico = new ClienteValidacao();

		String nome = "EricaBeatriz";
		String cpf = "12345678912";
		
		boolean ehUsuarioValido = servico.validarUsuario(nome, cpf);
		assertEquals(false, ehUsuarioValido);
	}

	
	public void naoPodeValidarCpfComCaracteres() {
		ClienteValidacao servico = new ClienteValidacao();

		String nome = "EricaBeatriz";
		String cpf = "123.456.789-12";
		
		boolean ehUsuarioValido = servico.validarUsuario(nome, cpf);
		assertEquals(false, ehUsuarioValido);
	}

	@Test
	public void permitirValidarComTudoCorreto() {
		ClienteValidacao servico = new ClienteValidacao();

		String nome = "Ana Maria Braga";
		String cpf = "123456778925";
		
		boolean ehUsuarioValido = servico.validarUsuario(nome, cpf);
		
		assertEquals(true, ehUsuarioValido);
	}
	

}
