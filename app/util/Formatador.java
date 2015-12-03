package util;

import java.text.DecimalFormat;

import javax.swing.text.MaskFormatter;

public class Formatador {

	public static String getDoubleAsMoney(double numero){
		return new DecimalFormat("#,##0.00").format(numero);  
	}
	
	public static String getInvertedDateAsNormal(String invertedDate){
		String dia;
		String mes;
		String ano;
		//Original 2014-05-02
		dia = invertedDate.substring(8);
		mes = invertedDate.substring(5,7);
		ano = invertedDate.substring(0,4);
		return dia + "/" + mes + "/" + ano;
	}
	
	public static String getDoubleAsPercentual(double numero){
		double aux = numero*100;
		String retorno = new DecimalFormat("#0.00").format(aux) + "%"; 
		return retorno;
	}
	
	public static String getDoubleAsNumber(double numero){
		double aux = numero*100;
		String retorno = new DecimalFormat("#0.00").format(aux); 
		return retorno;
	}
	
	public static String getCnpjFormatted(String cnpjCpf){
		MaskFormatter mask;
        try {
        	if (cnpjCpf.length() == 11){ //cpf
        		mask = new MaskFormatter("###.###.###-##");
        	} else {
        		mask = new MaskFormatter("##.###.###/####-##");
        	}
		    mask.setValueContainsLiteralCharacters(false);
		    return mask.valueToString(cnpjCpf);
        } catch (Exception e) {
			return "";
		}
	}
}
