package extractor.xml;

import models.MunicipioPE;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import extractor.ExtractorResults;

import play.db.jpa.JPA;

import play.Logger;

public class MunicipiosPEXmlHandler extends DefaultHandler {

	private boolean bestado;
	private boolean bmunicipio;
	private boolean bcodigo;
	private boolean bcodigoIbge;
	private boolean bcodigoAgres;
	
	MunicipioPE municipio;
	
	ExtractorResults er;
	int count = 0;
	
	public MunicipiosPEXmlHandler(ExtractorResults er) {
		this.er = er;
	}

	public void startElement(String uri, String localName,String qName, 
            Attributes attributes) throws SAXException {
		
		if (qName.equalsIgnoreCase("Municipios")) {
			municipio = new MunicipioPE();
			municipio.setEstado("PE");
		} else if (qName.equalsIgnoreCase("CODIGO")) {
			bcodigo = true;
		}else if (qName.equalsIgnoreCase("CODIGOIBGE")) {
			bcodigoIbge = true;
		}else if (qName.equalsIgnoreCase("CODIGOSAGRES")) {
			bcodigoAgres = true;
		}else if (qName.equalsIgnoreCase("MUNICIPIO")) {
			bmunicipio = true;
		}else if (qName.equalsIgnoreCase("UNIDADEFEDERATIVA")) {
			bestado = true;
		}
		
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if (qName.equalsIgnoreCase("Municipios")) {
			saveMunicipio();
		} else if (qName.equalsIgnoreCase("CODIGO")) {
			bcodigo = false;
		}else if (qName.equalsIgnoreCase("CODIGOIBGE")) {
			bcodigoIbge = false;
		}else if (qName.equalsIgnoreCase("CODIGOSAGRES")) {
			bcodigoAgres = false;
		}else if (qName.equalsIgnoreCase("MUNICIPIO")) {
			bmunicipio = false;
		}else if (qName.equalsIgnoreCase("UNIDADEFEDERATIVA")) {
			bestado = false;
		}
	}
	
	public void characters(char ch[], int start, int length) throws SAXException {
		if (bcodigo) {
			String s = new String(ch, start, length).trim();
			municipio.setCodigo(s);
		}
		if (bcodigoIbge){
			String s = new String(ch, start, length).trim();
			municipio.setCodigoIbge(s);
		}
		if (bcodigoAgres){
			String s = new String(ch, start, length).trim();
			municipio.setCodigoAgres(s);
		}
		if (bmunicipio){
			String s = new String(ch, start, length).trim();
			municipio.setMunicipio(s);
		}
		if (bestado){
			String s = new String(ch, start, length).trim();
			municipio.setEstado(s);
		}
	}
	
	private void saveMunicipio() {
		try {
			er.registros++;
			//JPA.em().persist(municipio);
			er.acertos++;
			
			count++;
			if (count%500 == 0){//registra no log e commita a cada 500
				Logger.info("Salvo " + count);
				//JPA.em().getTransaction().commit();
				//JPA.em().getTransaction().begin();
				System.gc();
			}
		} catch (Exception e){
			Logger.error("Erro salvando municipio: " + municipio + ": " + e.getMessage());
			er.erros++;
		}
		
	}
	
}
