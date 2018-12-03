package make.com.make.servico;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemValidacao {
	
	private static final String NOME_PATTERN = "^[A-Z][a-z]* [ [A-Z][a-z]]*";
	
	private static  Pattern pattern;
		
	private static Matcher matcher;
	
	public boolean validarItem(String produto, int quantidade, Double valor) {
		
		if(validarNome(produto) ) {
			return true;
		}
		return false;
	}
	
	public boolean validarNome(String produto) {
		
		pattern = Pattern.compile(NOME_PATTERN, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(produto);
		return matcher.matches();
	
	}
}
