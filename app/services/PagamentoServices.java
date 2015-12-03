package services;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.Pagamento;
import play.db.jpa.JPA;

public class PagamentoServices {
	
	
	/* AREA */
	public static List<Pagamento> getListaPagamentosPorArea(String area, int quantidadeResultados){
		area = area.replace("'", "").replace("\"", "");
		String query = "FROM Pagamento "
				+ "WHERE area LIKE '%"+area+"%' "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.getResultList();
	}
	
	public static List<Pagamento> getListaPagamentosPorAreaEEstado(String area, String estado, int quantidadeResultados){
		area = area.replace("'", "").replace("\"", "");
		String query = "FROM Pagamento "
				+ "WHERE area LIKE '%"+area+"%' "
				+ "AND estado = :estado "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("estado", estado)
				.getResultList();
	}
	
	public static List<Pagamento> getListaPagamentosPorAreaEEstadoECidade(String area, String estado, String cidade, int quantidadeResultados){
		area = area.replace("'", "").replace("\"", "");
		cidade = cidade.replace("'", "").replace("\"", "");
		String query = "FROM Pagamento "
				+ "WHERE area LIKE '%"+area+"%' "
				+ "AND estado = :estado "
				+ "AND cidade LIKE '%"+cidade+"%' "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("estado", estado)
				.getResultList();
	}
	
	/* EMPRESA */
	public static  List<Pagamento> getListaPagamentosPorCnpj(String cnpj, int quantidadeResultados){
		String query = "FROM Pagamento "
				+ "WHERE cnpj = :cnpj "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("cnpj", cnpj)
				.getResultList();
	}
	
	public static  List<Pagamento> getListaPagamentosPorCnpjEEstado(String cnpj, String estado, int quantidadeResultados){
		String query = "FROM Pagamento "
				+ "WHERE cnpj = :cnpj "
				+ "AND estado = :estado "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("cnpj", cnpj)
				.setParameter("estado", estado)
				.getResultList();
	}
	
	public static  List<Pagamento> getListaPagamentosPorCnpjEEstadoECidade(String cnpj, String estado, String cidade, int quantidadeResultados){
		cidade = cidade.replace("'", "").replace("\"", "");
		String query = "FROM Pagamento "
				+ "WHERE cnpj = :cnpj "
				+ "AND estado = :estado "
				+ "AND cidade LIKE '%"+cidade+"%' "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("cnpj", cnpj)
				.setParameter("estado", estado)
				.getResultList();
	}
	
	/* LOCAL */
	public static  List<Pagamento> getListaPagamentosPorEstado(String estado, int quantidadeResultados){
		String query = "FROM Pagamento "
				+ "WHERE estado = :estado "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("estado", estado)
				.getResultList();
	}
	
	public static List<Pagamento> getListaPagamentosPorEstadoECidade(String estado, String cidade, int quantidadeResultados){
		cidade = cidade.replace("'", "").replace("\"", "");
		String query = "FROM Pagamento "
				+ "WHERE estado = :estado "
				+ "AND cidade LIKE '%"+cidade+"%' "
				+ "ORDER BY valor DESC";
		return  JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("estado", estado)
				.getResultList();
	}
	
	public static List<Pagamento> getListaPagamentosPorCidade(String cidade, int quantidadeResultados){
		cidade = cidade.replace("'", "").replace("\"", "");
		String query = "FROM Pagamento "
				+ "WHERE cidade LIKE '%"+cidade+"%' "
				+ "ORDER BY valor DESC";
		return  JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.getResultList();
	}
	
	/* ORGAO */
	public static  List<Pagamento> getListaPagamentosPorOrgao(String orgao, int quantidadeResultados){
		orgao = orgao.replace("'", "").replace("\"", "");
		String query = "FROM Pagamento "
				+ "WHERE orgao LIKE '%"+orgao+"%' "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.getResultList();
	}
	
	public static  List<Pagamento> getListaPagamentosPorOrgaoEEstado(String orgao, String estado, int quantidadeResultados){
		orgao = orgao.replace("'", "").replace("\"", "");
		String query = "FROM Pagamento "
				+ "WHERE orgao LIKE '%"+orgao+"%' "
				+ "AND estado = :estado "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("estado", estado)
				.getResultList();
	}
	
	public static  List<Pagamento> getListaPagamentosPorOrgaoEEstadoECidade(String orgao, String estado, String cidade, int quantidadeResultados){
		orgao = orgao.replace("'", "").replace("\"", "");
		cidade = cidade.replace("'", "").replace("\"", "");
		String query = "FROM Pagamento "
				+ "WHERE orgao LIKE '%"+orgao+"%' "
				+ "AND estado = :estado "
				+ "AND cidade LIKE '%"+cidade+"%' "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("estado", estado)
				.getResultList();
	}
	
	/* CREDOR */
	public static  List<Pagamento> getListaPagamentosPorNomeCredor(String nomeCredor, int quantidadeResultados){
		nomeCredor = nomeCredor.replace("'", "").replace("\"", "");
		String query = "FROM Pagamento "
				+ "WHERE nomeCredor LIKE '%"+nomeCredor+"%' "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.getResultList();
	}
	
	public static  List<Pagamento> getListaPagamentosPorNomeCredorEEstado(String nomeCredor, String estado, int quantidadeResultados){
		nomeCredor = nomeCredor.replace("'", "").replace("\"", "");
		String query = "FROM Pagamento "
				+ "WHERE nomeCredor LIKE '%"+nomeCredor+"%' "
				+ "AND estado = :estado "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("estado", estado)
				.getResultList();
	}
	
	public static  List<Pagamento> getListaPagamentosPorNomeCredorEEstadoECidade(String nomeCredor, String estado, String cidade, int quantidadeResultados){
		nomeCredor = nomeCredor.replace("'", "").replace("\"", "");
		cidade = cidade.replace("'", "").replace("\"", "");
		String query = "FROM Pagamento "
				+ "WHERE nomeCredor LIKE '%"+nomeCredor+"%' "
				+ "AND estado = :estado "
				+ "AND cidade LIKE '%"+cidade+"%' "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("estado", estado)
				.getResultList();
	}
	
	/* VALOR */
	public static List<Pagamento> getPagamentosPorRangeValor(int min, int max, int quantidadeResultados) {
		String query = "FROM Pagamento " +
				" WHERE valor";
		if(min == -1){
			query += " <= :max ORDER BY valor DESC";
			return JPA.em().createQuery(query)
					.setMaxResults(quantidadeResultados)
	    			.setParameter("max", Float.parseFloat(max +""))
	    			.getResultList();
		}else if(max == -1){
			query += " >= :min ORDER BY valor";
			return JPA.em().createQuery(query)
					.setMaxResults(quantidadeResultados)
	    			.setParameter("min", Float.parseFloat(min +""))
	    			.getResultList();
		}else{
			query += " BETWEEN "+min+" AND "+max+" ORDER BY valor DESC";
			return JPA.em().createQuery(query)
					.setMaxResults(quantidadeResultados)
	    			.getResultList();
		}
	}
	
	public static List<Pagamento> getPagamentosPorRangeValorEEstado(int min, int max, String estado, int quantidadeResultados) {
		String query = "FROM Pagamento " +
				" WHERE estado = :estado "
				+ "AND valor";
		if(min == -1){
			query += " <= :max ORDER BY valor DESC";
			return JPA.em().createQuery(query)
					.setMaxResults(quantidadeResultados)
	    			.setParameter("max", Float.parseFloat(max +""))
	    			.setParameter("estado", estado)
	    			.getResultList();
		}else if(max == -1){
			query += " >= :min ORDER BY valor";
			return JPA.em().createQuery(query)
					.setMaxResults(quantidadeResultados)
	    			.setParameter("min", Float.parseFloat(min +""))
	    			.setParameter("estado", estado)
	    			.getResultList();
		}else{
			query += " BETWEEN "+min+" AND "+max+" ORDER BY valor DESC";
			return JPA.em().createQuery(query)
					.setMaxResults(quantidadeResultados)
					.setParameter("estado", estado)
	    			.getResultList();
		}
	}
	
	public static List<Pagamento> getPagamentosPorRangeValorEEstadoECidade(int min, int max, String estado, String cidade, int quantidadeResultados) {
		cidade = cidade.replace("'", "").replace("\"", "");				
		String query = "FROM Pagamento " +
				" WHERE estado = :estado "
				+ "AND cidade LIKE '%"+cidade+"%' "
				+ "AND valor";
		if(min == -1){
			query += " <= :max ORDER BY valor DESC";
			return JPA.em().createQuery(query)
					.setMaxResults(quantidadeResultados)
	    			.setParameter("max", Float.parseFloat(max +""))
	    			.setParameter("estado", estado)
	    			.getResultList();
		}else if(max == -1){
			query += " >= :min ORDER BY valor";
			return JPA.em().createQuery(query)
					.setMaxResults(quantidadeResultados)
	    			.setParameter("min", Float.parseFloat(min +""))
	    			.setParameter("estado", estado)
	    			.getResultList();
		}else{
			query += " BETWEEN "+min+" AND "+max+" ORDER BY valor DESC";
			return JPA.em().createQuery(query)
					.setMaxResults(quantidadeResultados)
					.setParameter("estado", estado)
	    			.getResultList();
		}
	}
	
	/* AGREGADOS */
	public static List<HashMap<String, String>> getAgregadoPagamentosPorArea(int quantidadeResultados){
		String query = "SELECT area, SUM(valor) as valor "
				+ "FROM Pagamento "
				+ "GROUP BY area "
				+ "ORDER BY valor DESC";
		List<Object> lo = JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.getResultList();
		List<HashMap<String, String>> listaResultado = new ArrayList<HashMap<String,String>>();
		
		for (Object o : lo) {
			Object[] itens = (Object[]) o;
			HashMap<String, String> map = new HashMap<String, String>();

			map.put("area", (String)itens[0]);
			map.put("valor", (new DecimalFormat("#,###.00").format(itens[1])) +"");
			listaResultado.add(map);
		}
		return listaResultado;
	}
	
	public static List<HashMap<String, String>> getAgregadoPagamentosPorAreaEEstado(String estado, int quantidadeResultados){
		String query = "SELECT area, SUM(valor) as valor "
				+ "FROM Pagamento "
				+ "WHERE estado = :estado "
				+ "GROUP BY area "
				+ "ORDER BY valor DESC";
		List<Object> lo = JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("estado", estado)
				.getResultList();
		List<HashMap<String, String>> listaResultado = new ArrayList<HashMap<String,String>>();
		
		for (Object o : lo) {
			Object[] itens = (Object[]) o;
			HashMap<String, String> map = new HashMap<String, String>();

			map.put("area", (String)itens[0]);
			map.put("valor", (new DecimalFormat("#,###.00").format(itens[1])) +"");
			listaResultado.add(map);
		}
		return listaResultado;
	}
	
	public static List<HashMap<String, String>> getAgregadoPagamentosPorAreaEEstadoECidade(String estado, String cidade, int quantidadeResultados){
		cidade = cidade.replace("'", "").replace("\"", "");	
		String query = "SELECT area, SUM(valor) as valor "
				+ "FROM Pagamento "
				+ "WHERE estado = :estado "
				+ "AND cidade LIKE '%"+cidade+"%' "
				+ "GROUP BY area "
				+ "ORDER BY valor DESC";
		List<Object> lo = JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("estado", estado)
				.getResultList();
		List<HashMap<String, String>> listaResultado = new ArrayList<HashMap<String,String>>();
		
		for (Object o : lo) {
			Object[] itens = (Object[]) o;
			HashMap<String, String> map = new HashMap<String, String>();

			map.put("area", (String)itens[0]);
			map.put("valor", (new DecimalFormat("#,###.00").format(itens[1])) +"");
			listaResultado.add(map);
		}
		return listaResultado;
	}
	
	public static List<HashMap<String, String>> getAgregadoPagamentosPorOrgaoEEstado(String estado, int quantidadeResultados){
		String query = "SELECT orgao, SUM(valor) as valor "
				+ "FROM Pagamento "
				+ "WHERE estado = :estado "
				+ "GROUP BY orgao "
				+ "ORDER BY valor DESC";
		List<Object> lo = JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("estado", estado)
				.getResultList();
		List<HashMap<String, String>> listaResultado = new ArrayList<HashMap<String,String>>();
		
		for (Object o : lo) {
			Object[] itens = (Object[]) o;
			HashMap<String, String> map = new HashMap<String, String>();

			map.put("orgao", (String)itens[0]);
			map.put("valor", (new DecimalFormat("#,###.00").format(itens[1])) +"");
			listaResultado.add(map);
		}
		return listaResultado;
	}
	
	public static List<HashMap<String, String>> getAgregadoPagamentosPorOrgaoEEstadoECidade(String estado, String cidade, int quantidadeResultados){
		cidade = cidade.replace("'", "").replace("\"", "");	
		String query = "SELECT orgao, SUM(valor) as valor "
				+ "FROM Pagamento "
				+ "WHERE estado = :estado "
				+ "AND cidade LIKE '%"+cidade+"%' "
				+ "GROUP BY orgao "
				+ "ORDER BY valor DESC";
		List<Object> lo = JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("estado", estado)
				.getResultList();
		List<HashMap<String, String>> listaResultado = new ArrayList<HashMap<String,String>>();
		
		for (Object o : lo) {
			Object[] itens = (Object[]) o;
			HashMap<String, String> map = new HashMap<String, String>();

			map.put("orgao", (String)itens[0]);
			map.put("valor", (new DecimalFormat("#,###.00").format(itens[1])) +"");
			listaResultado.add(map);
		}
		return listaResultado;
	}
	
	public static List<HashMap<String, String>> getAgregadoPagamentosPorEstado(int quantidadeResultados){
		String query = "SELECT estado, SUM(valor) as valor "
				+ "FROM Pagamento "
				+ "GROUP BY estado "
				+ "ORDER BY valor DESC";
		List<Object> lo = JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.getResultList();
		List<HashMap<String, String>> listaResultado = new ArrayList<HashMap<String,String>>();
		
		for (Object o : lo) {
			Object[] itens = (Object[]) o;
			HashMap<String, String> map = new HashMap<String, String>();

			map.put("estado", (String)itens[0]);
			map.put("valor", (new DecimalFormat("#,###.00").format(itens[1])) +"");
			listaResultado.add(map);
		}
		return listaResultado;
	}
	
	public static List<HashMap<String, String>> getAgregadoPagamentosPorEstadoECidade(String estado, int quantidadeResultados){
		String query = "SELECT cidade, SUM(valor) as valor "
				+ "FROM Pagamento "
				+ "WHERE estado = :estado "
				+ "GROUP BY cidade "
				+ "ORDER BY valor DESC";
		List<Object> lo = JPA.em().createQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("estado", estado)
				.getResultList();
		List<HashMap<String, String>> listaResultado = new ArrayList<HashMap<String,String>>();
		
		for (Object o : lo) {
			Object[] itens = (Object[]) o;
			HashMap<String, String> map = new HashMap<String, String>();

			map.put("estado", (String)itens[0]);
			map.put("valor", (new DecimalFormat("#,###.00").format(itens[1])) +"");
			listaResultado.add(map);
		}
		return listaResultado;
	}
	
	public static List<HashMap<String, String>> getAgregadoPagamentosPorEmpresaEEstado(String estado, int quantidadeResultados){
		String query = "SELECT e.nome, SUM(p.valor) as valor "
				+ "FROM Pagamento p INNER JOIN Empresa e "
				+ "WHERE p.estado = :estado "
				+ "AND p.cnpj = e.cnpjCpf "
				+ "AND p.cnpj is not null "
				+ "GROUP BY p.cnpj "
				+ "ORDER BY valor DESC";
		List<Object> lo = JPA.em().createNativeQuery(query)
				.setMaxResults(quantidadeResultados)
				.setParameter("estado", estado)
				.getResultList();
		List<HashMap<String, String>> listaResultado = new ArrayList<HashMap<String,String>>();
		
		for (Object o : lo) {
			Object[] itens = (Object[]) o;
			HashMap<String, String> map = new HashMap<String, String>();

			map.put("nomeEmpresa", (String)itens[0]);
			map.put("valor", (new DecimalFormat("#,###.00").format(itens[1])) +"");
			listaResultado.add(map);
		}
		return listaResultado;
	}
}
