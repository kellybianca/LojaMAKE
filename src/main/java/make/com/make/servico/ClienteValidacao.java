package make.com.make.servico;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClienteValidacao {
	
	private static final String NOME_PATTERN = "^[A-Z][a-z]* [ [A-Z][a-z]]*";
	
	private static  Pattern pattern;
		
	private static Matcher matcher;
	
	public boolean validarUsuario(String nome, String cpf) {
		
		if(validarCpf(cpf) && validarNome(nome) ) {
			return true;
		}
		return false;
	}
	
	public boolean validarNome(String nome) {
		
		pattern = Pattern.compile(NOME_PATTERN, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(nome);
		return matcher.matches();
	
	}
	
	public boolean validarCpf(String cpf) {
		pattern = Pattern.compile(NOME_PATTERN, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(cpf);
		return matcher.matches();
	}
	
}
