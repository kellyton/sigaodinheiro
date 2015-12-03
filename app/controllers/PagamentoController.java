package controllers;

import static play.data.Form.form;
import play.Logger;
import play.data.DynamicForm;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import services.PagamentoServices;
import util.AdminJson;

public class PagamentoController extends Controller{
	
	@Transactional
	public static Result getListaPagamentosPorCidade(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			String cidade = (dynamicForm.get("cidade") == null)? "" : dynamicForm.get("cidade");
			return ok(AdminJson.getObject(PagamentoServices.getListaPagamentosPorCidade(estado, cidade), "listaPagamentos"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getListaPagamentosPorCidade(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getPagamentosPorRangeValor(String tipoPolitico){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			int max = (dynamicForm.get("max") == null || dynamicForm.get("max").trim().isEmpty())? -1 : Integer.parseInt(dynamicForm.get("max"));
			int min = (dynamicForm.get("min") == null || dynamicForm.get("min").trim().isEmpty())? -1 : Integer.parseInt(dynamicForm.get("min"));
			
			if((max == -1 && min >=0)				// campo max nao informado
			|| (min == -1 && max > 0)				// campo min nao informado
			|| (max > 0 && min >= 0 && max > min)){	// campos informados
				return ok(AdminJson.getObject(PagamentoServices.getPagamentosPorRangeValor(min, max), "listaPagamentos"));
			}
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getPagamentosPorRangeValor(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
}
