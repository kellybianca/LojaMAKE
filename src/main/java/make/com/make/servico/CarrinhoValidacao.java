package make.com.make.servico;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarrinhoValidacao {
	
	private static final String NOME_PATTERN = "^[A-Z][a-z]* [ [A-Z][a-z]]*";
	
	private static  Pattern pattern;
	
	private static Matcher matcher;
	
	public boolean validarUsuario(String cliente, String tipoPagamento, String item, CharSequence valor) {
					
		if(validarCliente(cliente) && validarTipoPagamento(tipoPagamento) && validarItem(item) && validarValor(valor)) {
			return true;
		}
		return false;
	}
	
	public boolean validarCliente(String cliente) {
		
		 pattern = Pattern.compile(NOME_PATTERN, Pattern.CASE_INSENSITIVE);		
		 matcher= pattern.matcher(cliente);
		 return matcher.matches();
	}
	
	public boolean validarTipoPagamento(String tipoPagamento) {
		
		 pattern = Pattern.compile(NOME_PATTERN, Pattern.CASE_INSENSITIVE);		
		 matcher= pattern.matcher(tipoPagamento);
		 return matcher.matches();
	}
	
	public boolean validarItem(String item) {
		
		 pattern = Pattern.compile(NOME_PATTERN, Pattern.CASE_INSENSITIVE);		
		 matcher= pattern.matcher(item);
		 return matcher.matches();
	}
	
	public boolean validarValor(CharSequence valor) {
		
		 pattern = Pattern.compile(NOME_PATTERN, Pattern.CASE_INSENSITIVE);		
		 matcher= pattern.matcher(valor);
		 return matcher.matches();
	}
}
