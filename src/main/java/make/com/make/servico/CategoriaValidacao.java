package make.com.make.servico;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CategoriaValidacao {

	private static final String NOME_PATTERN = "^[A-Z][a-z]* [ [A-Z][a-z]]*";
	
	private static  Pattern pattern;
		
	private static Matcher matcher;
	
	public boolean validarUsuario(String nome, String itens) {
		
		if(validarNome(nome) && validarItens(itens)) {
			return true;
		}
		return false;
	}
	
	public boolean validarNome(String nome) {
		
		pattern = Pattern.compile(NOME_PATTERN, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(nome);
		return matcher.matches();
	}
	
public boolean validarItens(String itens) {
		
		pattern = Pattern.compile(NOME_PATTERN, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(itens);
		return matcher.matches();
	
	}
}
