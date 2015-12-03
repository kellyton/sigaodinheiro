package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MunicipioPE {

	@Column
	private String estado;
	@Column
	private String municipio;
	@Id
	private String codigo;
	@Column
	private String codigoIbge;
	@Column
	private String codigoAgres;
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigoIbge() {
		return codigoIbge;
	}
	public void setCodigoIbge(String codigoIbge) {
		this.codigoIbge = codigoIbge;
	}
	public String getCodigoAgres() {
		return codigoAgres;
	}
	public void setCodigoAgres(String codigoAgres) {
		this.codigoAgres = codigoAgres;
	}
	
	public String toString(){
		return codigo + "-" + municipio;
	}
	
}
