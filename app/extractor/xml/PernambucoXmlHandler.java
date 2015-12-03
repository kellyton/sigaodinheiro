package extractor.xml;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import models.Pagamento;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import extractor.ExtractorResults;

import play.db.jpa.JPA;

import play.Logger;

public class PernambucoXmlHandler extends DefaultHandler {
	private boolean bArea;
	private boolean bElemento;
	private boolean bOrgao;
	private boolean bCnpj;
	private boolean bValor;
	private boolean bData;
	private boolean bAno;
	
	Pagamento pagamento;
	
	ExtractorResults er;
	int count = 0;
	
	public PernambucoXmlHandler(ExtractorResults er) {
		this.er = er;
	}

	public void startElement(String uri, String localName,String qName, 
            Attributes attributes) throws SAXException {
		
		if (qName.equalsIgnoreCase("row")) {
			pagamento = new Pagamento();
		} else if (qName.equalsIgnoreCase("FUNCAO")) {
			bArea = true;
		} else if (qName.equalsIgnoreCase("ELEMENTO_DESPESA")) {
			bElemento = true;
		} else if (qName.equalsIgnoreCase("UNIDADE_ORCAMENTARIA")) {
			bOrgao = true;
		} else if (qName.equalsIgnoreCase("CPF_CNPJ")) {
			bCnpj = true;
		} else if (qName.equalsIgnoreCase("VALOR_EMPENHADO")) {
			bValor = true;
		} else if (qName.equalsIgnoreCase("DATA_EMPENHO")) {
			bData = true;
		} else if (qName.equalsIgnoreCase("ANO_REFERENCIA")) {
			bAno = true;
		}
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("row")) {
			savePagamento();
		} else if (qName.equalsIgnoreCase("FUNCAO")) {
			bArea = false;
		} else if (qName.equalsIgnoreCase("ELEMENTO_DESPESA")) {
			bElemento = false;
		} else if (qName.equalsIgnoreCase("UNIDADE_ORCAMENTARIA")) {
			bOrgao = false;
		} else if (qName.equalsIgnoreCase("CPF_CNPJ")) {
			bCnpj = false;
		} else if (qName.equalsIgnoreCase("VALOR_EMPENHADO")) {
			bValor = false;
		} else if (qName.equalsIgnoreCase("DATA_EMPENHO")) {
			bData = false;
		} else if (qName.equalsIgnoreCase("ANO_REFERENCIA")) {
			bAno = false;
		}
	}
	
	private void savePagamento() {
		try {
			er.registros++;
			JPA.em().persist(pagamento);
			er.acertos++;
			
			pagamento = null;
			count++;
			if (count%500 == 0){//registra no log e commita a cada 500
				Logger.info("Salvo " + count);
				JPA.em().getTransaction().commit();
				JPA.em().getTransaction().begin();
				System.gc();
			}
		} catch (Exception e){
			Logger.error("Erro salvando Pagamento: " + pagamento + ": " + e.getMessage());
			er.erros++;
		}
		
	}

	public void characters(char ch[], int start, int length) throws SAXException {
		if (bArea) {
			String s = new String(ch, start, length).trim();
			pagamento.setArea(s);
		}
		if (bElemento){
			String s = new String(ch, start, length).trim();
			pagamento.setElemento(s);
		}
		if (bOrgao) {
			String s = new String(ch, start, length).trim();
			pagamento.setOrgao(s);
		}
		if (bCnpj) {
			String s = new String(ch, start, length).trim();
			pagamento.setCnpj(s);
		}
		if (bValor) {
			String s = new String(ch, start, length).trim();
			pagamento.setValor(Float.valueOf(s.trim()));
		}
		if (bData) {
			String s = new String(ch, start, length).trim();
			
			Date date = null;
			try {
		    	date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(s);
		    	pagamento.setData(date);
	    	} catch (Exception e){
	    		Logger.error("Erro convertendo data " + date + " do pagamento " + pagamento);
	    	}
		}
		if (bAno) {
			String s = new String(ch, start, length).trim();
			pagamento.setAno(Integer.valueOf(s));
		}
	}
}
