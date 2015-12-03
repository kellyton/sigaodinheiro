package services;

import java.util.List;

import models.Pagamento;
import play.db.jpa.JPA;

public class PagamentoServices {
	
	
	/* AREA */
	public static List<Pagamento> getListaPagamentosPorArea(String area){
		String query = "FROM Pagamento "
				+ "WHERE area = :area "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setParameter("area", area)
				.getResultList();
	}
	
	public static List<Pagamento> getListaPagamentosPorAreaEEstado(String area, String estado){
		String query = "FROM Pagamento "
				+ "WHERE area = :area "
				+ "AND estado = :estado "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setParameter("area", area)
				.setParameter("estado", estado)
				.getResultList();
	}
	
	public static List<Pagamento> getListaPagamentosPorAreaEEstado(String area, String estado, String cidade){
		String query = "FROM Pagamento "
				+ "WHERE area = :area "
				+ "AND estado = :estado "
				+ "AND cidade = :cidade"
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setParameter("area", area)
				.setParameter("estado", estado)
				.setParameter("cidade", cidade)
				.getResultList();
	}
	
	/* EMPRESA */
	public static  List<Pagamento> getListaPagamentosPorCnpj(String cnpj){
		String query = "FROM Pagamento "
				+ "WHERE cnpj = :cnpj "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setParameter("cnpj", cnpj).getResultList();
	}
	
	/* LOCAL */
	public static  List<Pagamento> getListaPagamentosPorEstado(String estado){
		String query = "FROM Pagamento "
				+ "WHERE estado = :estado "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setParameter("estado", estado).getResultList();
	}
	
	public static List<Pagamento> getListaPagamentosPorCidade(String estado, String cidade){
		String query = "FROM Pagamento "
				+ "WHERE estado = :estado "
				+ "AND cidade = :cidade "
				+ "ORDER BY valor DESC";
		return  JPA.em().createQuery(query)
				.setParameter("estado", estado)
				.setParameter("cidade", cidade)
				.getResultList();
	}
	
	/* ORGAO */
	public static  List<Pagamento> getListaPagamentosPorOrgao(String orgao){
		String query = "FROM Pagamento "
				+ "WHERE orgao = :orgao "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setParameter("orgao", orgao).getResultList();
	}
	
	/* CREDOR */
	public static  List<Pagamento> getListaPagamentosPorNomeCredor(String nomeCredor){
		String query = "FROM Pagamento "
				+ "WHERE nomeCredor = :nomeCredor "
				+ "ORDER BY valor DESC";
		return JPA.em().createQuery(query)
				.setParameter("nomeCredor", nomeCredor).getResultList();
	}
	
	/* VALOR */
	public static List<Pagamento> getPagamentosPorRangeValor(int min, int max) {
		String query = "FROM Pagamento " +
				" WHERE valor";
		if(min == -1){
			query += " <= :max ORDER BY valor";
			return JPA.em().createQuery(query)
	    			.setMaxResults(250)
	    			.setParameter("max", Double.parseDouble(max +""))
	    			.getResultList();
		}else if(max == -1){
			query += " >= :min ORDER BY valor";
			return JPA.em().createQuery(query)
	    			.setParameter("min", Double.parseDouble(min +""))
	    			.getResultList();
		}else{
			query += " BETWEEN "+min+" AND "+max+" ORDER BY valor";
			return JPA.em().createQuery(query)
	    			.getResultList();
		}
	}
	
}
