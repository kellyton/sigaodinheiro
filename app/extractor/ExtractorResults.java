package extractor;

import java.util.Date;

import play.Logger;

public class ExtractorResults {

	public long registros;
	public long acertos;
	public long erros;
	String mensagem;
	public Date inicio;
	public Date fim;
	
	public ExtractorResults(){
		registros = 0;
		acertos = 0;
		erros = 0;
		this.inicio = new Date();
		Logger.info("Iniciado em " + inicio);
	}
	
	public ExtractorResults(String mensagem) {
		registros = 0;
		acertos = 0;
		erros = 0;
		this.mensagem = mensagem;
		this.inicio = new Date();
		
		Logger.info("Processando: " + mensagem);
		Logger.info("Iniciado em " + inicio);
	}

	public String getTempo(){
		if (fim == null){
			fim = new Date();
		}
		return (fim.getTime() - inicio.getTime())/1000 + "s";
	}
	
	public String toString(){
		String newline = System.getProperty("line.separator");
		return "### Processamento realizado: " + mensagem + newline +
				"Registros = " + registros + newline + 
				"Acertos = " + acertos + newline +  
				"Erros = " + erros + newline + 
				"Tempo: " + getTempo() + newline;
		
	}
	
}
