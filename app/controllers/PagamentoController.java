package controllers;

import static play.data.Form.form;
import play.Logger;
import play.data.DynamicForm;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import services.PagamentoServices;
import util.AdminJson;
import util.Constantes;

public class PagamentoController extends Controller{
	
	/* AREA */
	@Transactional
	public static Result getListaPagamentosPorArea(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String area = (dynamicForm.get("area") == null)? "" : dynamicForm.get("area");
			return ok(AdminJson.getObject(PagamentoServices.getListaPagamentosPorArea(area, Constantes.MIL), "listaPagamentos"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getListaPagamentosPorArea(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getListaPagamentosPorAreaEEstado(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String area = (dynamicForm.get("area") == null)? "" : dynamicForm.get("area");
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			return ok(AdminJson.getObject(PagamentoServices.getListaPagamentosPorAreaEEstado(area, estado, Constantes.MIL), "listaPagamentos"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getListaPagamentosPorAreaEEstado(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getListaPagamentosPorAreaEEstadoECidade(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String area = (dynamicForm.get("area") == null)? "" : dynamicForm.get("area");
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			String cidade = (dynamicForm.get("cidade") == null)? "" : dynamicForm.get("cidade");
			return ok(AdminJson.getObject(PagamentoServices.getListaPagamentosPorAreaEEstadoECidade(area, estado, cidade, Constantes.MIL), "listaPagamentos"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getListaPagamentosPorAreaEEstadoECidade(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	/* EMPRESA */
	@Transactional
	public static Result getListaPagamentosPorCnpj(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String cnpj = (dynamicForm.get("cnpj") == null)? "" : dynamicForm.get("cnpj");
			return ok(AdminJson.getObject(PagamentoServices.getListaPagamentosPorCnpj(cnpj, Constantes.MIL), "listaPagamentos"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getListaPagamentosPorCnpj(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getListaPagamentosPorCnpjEEstado(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String cnpj = (dynamicForm.get("cnpj") == null)? "" : dynamicForm.get("cnpj");
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			return ok(AdminJson.getObject(PagamentoServices.getListaPagamentosPorCnpjEEstado(cnpj, estado, Constantes.MIL), "listaPagamentos"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getListaPagamentosPorCnpjEEstado(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getListaPagamentosPorCnpjEEstadoECidade(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String cnpj = (dynamicForm.get("cnpj") == null)? "" : dynamicForm.get("cnpj");
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			String cidade = (dynamicForm.get("cidade") == null)? "" : dynamicForm.get("cidade");
			return ok(AdminJson.getObject(PagamentoServices.getListaPagamentosPorCnpjEEstadoECidade(cnpj, estado, cidade, Constantes.MIL), "listaPagamentos"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getListaPagamentosPorCnpjEEstadoECidade(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	/* LOCAL */
	@Transactional
	public static Result getListaPagamentosPorEstado(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			return ok(AdminJson.getObject(PagamentoServices.getListaPagamentosPorEstado(estado, Constantes.MIL), "listaPagamentos"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getListaPagamentosPorEstado(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getListaPagamentosPorEstadoECidade(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			String cidade = (dynamicForm.get("cidade") == null)? "" : dynamicForm.get("cidade");
			return ok(AdminJson.getObject(PagamentoServices.getListaPagamentosPorEstadoECidade(estado, cidade, Constantes.MIL), "listaPagamentos"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getListaPagamentosPorEstadoECidade(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getListaPagamentosPorCidade(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String cidade = (dynamicForm.get("cidade") == null)? "" : dynamicForm.get("cidade");
			return ok(AdminJson.getObject(PagamentoServices.getListaPagamentosPorCidade(cidade, Constantes.MIL), "listaPagamentos"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getListaPagamentosPorCidade(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	/* ORGAO */
	@Transactional
	public static Result getListaPagamentosPorOrgao(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String orgao = (dynamicForm.get("orgao") == null)? "" : dynamicForm.get("orgao");
			return ok(AdminJson.getObject(PagamentoServices.getListaPagamentosPorOrgao(orgao, Constantes.MIL), "listaPagamentos"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getListaPagamentosPorOrgao(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getListaPagamentosPorOrgaoEEstado(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String orgao = (dynamicForm.get("orgao") == null)? "" : dynamicForm.get("orgao");
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			return ok(AdminJson.getObject(PagamentoServices.getListaPagamentosPorOrgaoEEstado(orgao, estado, Constantes.MIL), "listaPagamentos"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getListaPagamentosPorOrgaoEEstado(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getListaPagamentosPorOrgaoEEstadoECidade(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String orgao = (dynamicForm.get("orgao") == null)? "" : dynamicForm.get("orgao");
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			String cidade = (dynamicForm.get("cidade") == null)? "" : dynamicForm.get("cidade");
			return ok(AdminJson.getObject(PagamentoServices.getListaPagamentosPorOrgaoEEstadoECidade(orgao, estado, cidade, Constantes.MIL), "listaPagamentos"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getListaPagamentosPorOrgaoEEstadoECidade(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	/* CREDOR */ 
	@Transactional
	public static Result getListaPagamentosPorNomeCredor(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String nomeCredor = (dynamicForm.get("nomeCredor") == null)? "" : dynamicForm.get("nomeCredor");
			return ok(AdminJson.getObject(PagamentoServices.getListaPagamentosPorNomeCredor(nomeCredor, Constantes.MIL), "listaPagamentos"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getListaPagamentosPorNomeCredor(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getListaPagamentosPorNomeCredorEEstado(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String nomeCredor = (dynamicForm.get("nomeCredor") == null)? "" : dynamicForm.get("nomeCredor");
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			return ok(AdminJson.getObject(PagamentoServices.getListaPagamentosPorNomeCredorEEstado(nomeCredor, estado, Constantes.MIL), "listaPagamentos"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getListaPagamentosPorNomeCredorEEstado(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getListaPagamentosPorNomeCredorEEstadoECidade(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String nomeCredor = (dynamicForm.get("nomeCredor") == null)? "" : dynamicForm.get("nomeCredor");
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			String cidade = (dynamicForm.get("cidade") == null)? "" : dynamicForm.get("cidade");
			return ok(AdminJson.getObject(PagamentoServices.getListaPagamentosPorNomeCredorEEstadoECidade(nomeCredor, estado, cidade, Constantes.MIL), "listaPagamentos"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getListaPagamentosPorNomeCredorEEstadoECidade(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	/* VALOR */
	@Transactional
	public static Result getPagamentosPorRangeValor(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			int max = (dynamicForm.get("max") == null || dynamicForm.get("max").trim().isEmpty())? -1 : Integer.parseInt(dynamicForm.get("max"));
			int min = (dynamicForm.get("min") == null || dynamicForm.get("min").trim().isEmpty())? -1 : Integer.parseInt(dynamicForm.get("min"));
			
			if((max == -1 && min >=0)				// campo max nao informado
			|| (min == -1 && max > 0)				// campo min nao informado
			|| (max > 0 && min >= 0 && max > min)){	// campos informados
				return ok(AdminJson.getObject(PagamentoServices.getPagamentosPorRangeValor(min, max, Constantes.MIL), "listaPagamentos"));
			}
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getPagamentosPorRangeValor(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getPagamentosPorRangeValorEEstado(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			int max = (dynamicForm.get("max") == null || dynamicForm.get("max").trim().isEmpty())? -1 : Integer.parseInt(dynamicForm.get("max"));
			int min = (dynamicForm.get("min") == null || dynamicForm.get("min").trim().isEmpty())? -1 : Integer.parseInt(dynamicForm.get("min"));
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");

			if((max == -1 && min >=0)				// campo max nao informado
			|| (min == -1 && max > 0)				// campo min nao informado
			|| (max > 0 && min >= 0 && max > min)){	// campos informados
				return ok(AdminJson.getObject(PagamentoServices.getPagamentosPorRangeValorEEstado(min, max, estado, Constantes.MIL), "listaPagamentos"));
			}
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getPagamentosPorRangeValorEEstado(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getPagamentosPorRangeValorEEstadoECidade(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			int max = (dynamicForm.get("max") == null || dynamicForm.get("max").trim().isEmpty())? -1 : Integer.parseInt(dynamicForm.get("max"));
			int min = (dynamicForm.get("min") == null || dynamicForm.get("min").trim().isEmpty())? -1 : Integer.parseInt(dynamicForm.get("min"));
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			String cidade = (dynamicForm.get("cidade") == null)? "" : dynamicForm.get("cidade");

			if((max == -1 && min >=0)				// campo max nao informado
			|| (min == -1 && max > 0)				// campo min nao informado
			|| (max > 0 && min >= 0 && max > min)){	// campos informados
				return ok(AdminJson.getObject(PagamentoServices.getPagamentosPorRangeValorEEstadoECidade(min, max, estado, cidade, Constantes.MIL), "listaPagamentos"));
			}
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getPagamentosPorRangeValorEEstadoECidade(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	/* AGREGADOS */
	@Transactional
	public static Result getAgregadoPagamentosPorArea(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		try{
			return ok(AdminJson.getObject(PagamentoServices.getAgregadoPagamentosPorArea(Constantes.MIL), "listaAgregados"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getAgregadoPagamentosPorArea(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getAgregadoPagamentosPorAreaEEstado(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			return ok(AdminJson.getObject(PagamentoServices.getAgregadoPagamentosPorAreaEEstado(estado, Constantes.MIL), "listaAgregados"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getAgregadoPagamentosPorAreaEEstado(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getAgregadoPagamentosPorAreaEEstadoECidade(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			String cidade = (dynamicForm.get("cidade") == null)? "" : dynamicForm.get("cidade");
			return ok(AdminJson.getObject(PagamentoServices.getAgregadoPagamentosPorAreaEEstadoECidade(estado, cidade, Constantes.MIL), "listaAgregados"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getAgregadoPagamentosPorAreaEEstadoECidade(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getAgregadoPagamentosPorOrgaoEEstado(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			return ok(AdminJson.getObject(PagamentoServices.getAgregadoPagamentosPorOrgaoEEstado(estado, Constantes.MIL), "listaAgregados"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getAgregadoPagamentosPorOrgaoEEstado(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getAgregadoPagamentosPorOrgaoEEstadoECidade(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			String cidade = (dynamicForm.get("cidade") == null)? "" : dynamicForm.get("cidade");
			return ok(AdminJson.getObject(PagamentoServices.getAgregadoPagamentosPorOrgaoEEstadoECidade(estado, cidade, Constantes.MIL), "listaAgregados"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getAgregadoPagamentosPorOrgaoEEstadoECidade(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getAgregadoPagamentosPorEstado(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		try{
			return ok(AdminJson.getObject(PagamentoServices.getAgregadoPagamentosPorEstado(Constantes.MIL), "listaAgregados"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getAgregadoPagamentosPorEstado(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getAgregadoPagamentosPorEstadoECidade(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			return ok(AdminJson.getObject(PagamentoServices.getAgregadoPagamentosPorEstadoECidade(estado, Constantes.MIL), "listaAgregados"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getAgregadoPagamentosPorEstadoECidade(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
	@Transactional
	public static Result getAgregadoPagamentosPorEmpresaEEstado(){
		response().setHeader("Access-Control-Allow-Origin","*");
		response().setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		
		DynamicForm dynamicForm = form().bindFromRequest();
		try{
			String estado = (dynamicForm.get("estado") == null)? "" : dynamicForm.get("estado");
			return ok(AdminJson.getObject(PagamentoServices.getAgregadoPagamentosPorEmpresaEEstado(estado, Constantes.MIL), "listaAgregados"));
		}catch(Exception e){
			System.out.println("ERRO - PagamentoController/getAgregadoPagamentosPorEmpresaEEstado(): "+ e.getMessage());
		}
		return badRequest(AdminJson.getMensagem(AdminJson.msgConsulteAPI));
	}
	
}
