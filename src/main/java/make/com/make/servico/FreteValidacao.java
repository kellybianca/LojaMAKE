package make.com.make.servico;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FreteValidacao {
	private static final String NOME_PATTERN = "^[A-Z][a-z]* [ [A-Z][a-z]]*";
	
	private static  Pattern pattern;
		
	private static Matcher matcher;
	
	public boolean validarUsuario(String cliente, CharSequence cep, CharSequence valor, String endereco) {
					
		if(validarCliente(cliente) && validarCep(cep) && validarValor(valor) && validarEndereco(endereco)) {
			return true;
		}
		return false;
	}
	
	public boolean validarCliente(String cliente) {
		pattern = Pattern.compile(NOME_PATTERN, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(cliente);
		return matcher.matches();
	}
	
	public boolean validarCep(CharSequence cep) {
		pattern = Pattern.compile(NOME_PATTERN, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(cep);
		return matcher.matches();
	}
	
	public boolean validarValor(CharSequence valor) {
		pattern = Pattern.compile(NOME_PATTERN, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(valor);
		return matcher.matches();
	}
	
	public boolean validarEndereco(String endereco) {
		pattern = Pattern.compile(NOME_PATTERN, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(endereco);
		return matcher.matches();
	}

	
	
	
	
	
}
