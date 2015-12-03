package extractor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import extractor.xml.MunicipiosPEXmlHandler;

import play.Logger;
import play.db.jpa.Transactional;

public class PernambucoExtractor {
	
	@Transactional
	public static ExtractorResults processaPernambuco() {
		String file = "./dados/SCA_Despesas.xml";
		//String file = "./dados/testesaida.txt.xml";
				
		ExtractorResults er = new ExtractorResults();
		Logger.info("Processando dados das despesas");
    	
    	try {
    		SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
    		
    		InputStream inputStream = new FileInputStream(file);
    		Reader reader = new InputStreamReader(inputStream,"UTF-8");
    		//Reader reader = new InputStreamReader(inputStream,"cp1252");
    		
    		InputSource is = new InputSource(reader);
    		//is.setEncoding("UTF-8");
    		is.setEncoding("cp1252");
    		
    		
			MunicipiosPEXmlHandler dhandler = new MunicipiosPEXmlHandler(er);
			saxParser.parse(is, dhandler);
			
			reader.close();
			is = null;
			saxParser = null;
			factory = null;
			
		} catch (ParserConfigurationException e) {
			Logger.error("Error of response parse. " + e.getMessage());
			return er;
		} catch (SAXException e) {
			Logger.error("Error reading xml response. " + e.getMessage());
			return er;
		} catch (IOException e) {
			Logger.error("Error saving Deputados's data. " + e.getMessage());
			return er;
		}
    	
    	Logger.info("Dados básicos processados!");
		
		return er;
    }
	
	public static ExtractorResults processaMunicipios() {
		String file = "./dados/MunicipiosPE.xml";
				
		ExtractorResults er = new ExtractorResults();
		Logger.info("Processando dados básicos");
    	
    	try {
    		SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
    		
    		InputStream inputStream = new FileInputStream(file);
    		//Reader reader = new InputStreamReader(inputStream,"UTF-8");
    		Reader reader = new InputStreamReader(inputStream,"cp1252");
    		InputSource is = new InputSource(reader);
    		is.setEncoding("cp1252");
    		
			MunicipiosPEXmlHandler dhandler = new MunicipiosPEXmlHandler(er);
			saxParser.parse(is, dhandler);
			
			reader.close();
			is = null;
			saxParser = null;
			factory = null;
			
		} catch (ParserConfigurationException e) {
			Logger.error("Error of response parse. " + e.getMessage());
			return er;
		} catch (SAXException e) {
			Logger.error("Error reading xml response. " + e.getMessage());
			return er;
		} catch (IOException e) {
			Logger.error("Error saving Deputados's data. " + e.getMessage());
			return er;
		}
    	
    	Logger.info("Dados básicos processados!");
    	
    	return er;  		
    }
	
}
