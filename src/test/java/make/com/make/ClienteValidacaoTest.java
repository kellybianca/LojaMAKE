package make.com.make;

public class ClienteValidacaoTest {

	@Test
	public void naoPodeValidarNomeComNumeros() {
		ClienteValidacao servico = new ClienteValidacao();

		String nome = "Ana Maria 123 Braga";
		String email = "anamaria@gmail.com";
		int idade = 30;
		
		boolean ehUsuarioValido = servico.validarUsuario(nome, email, idade);
		
		assertEquals(false, ehUsuarioValido);
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
