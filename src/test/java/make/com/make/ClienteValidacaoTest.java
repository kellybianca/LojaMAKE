package make.com.make;

import org.junit.Test;

import make.com.make.servico.ClienteValidacao;

public class ClienteValidacaoTest {

	@Test
	public void naoPodeValidarNomeComNumeros() {
		ClienteValidacao cliente = new ClienteValidacao();

		String nome = "Erica 123 Beatriz";
		String cpf = "12345678912";
		String senha = "123456";
		
		boolean ehUsuarioValido = cliente.validarUsuario(nome, cpf, senha);
		
		assertEquals(false, ehUsuarioValido);
	}
	
	private void assertEquals(boolean b, boolean ehUsuarioValido) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void naoPodeValidarNomeESobrenomeEscritosSemEspaco() {
		ClienteValidacao servico = new ClienteValidacao();

		String nome = "AnaMariaBraga";
		String email = "anamaria@gmail.com";
		int idade = 30;
		
		boolean ehUsuarioValido = servico.validarUsuario(nome, email, idade);
		
		assertEquals(false, ehUsuarioValido);
	}
	


	@Test
	public void permitirValidarComTudoCorreto() {
		ClienteValidacao servico = new ClienteValidacao();

		String nome = "Ana Maria Braga";
		String email = "anamaria@gmail.com";
		int idade = 69;
		
		boolean ehUsuarioValido = servico.validarUsuario(nome, email, idade);
		
		assertEquals(true, ehUsuarioValido);
	}
	

}
