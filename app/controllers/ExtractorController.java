package controllers;

import extractor.ExtractorResults;
import extractor.PernambucoExtractor;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class ExtractorController extends Controller {
	
	public static Result processaMunicipios() {
		ExtractorResults er = PernambucoExtractor.processaMunicipios();
        return ok(er.toString());
    }
	
	public static Result processaPernambuco() {
		ExtractorResults er = PernambucoExtractor.processaPernambuco();
        return ok(er.toString());
    }
	
	public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
		
}
