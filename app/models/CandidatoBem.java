/* Copyright 2013 de Kellyton Brito. 
**/

package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

/** 
 * @author Kellyton Brito
 *
 */

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class CandidatoBem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty
	private long id;
	@Column
	private long candidatoId;
	@Column
	private int ano;
	@Column
	private String descricaoEleicao;
	@Column
	private String uf;
	@Column
	private long sequencial;
	@Column
	@JsonProperty
	private int codBem;
	@Column
	@JsonProperty
	private String tipoBem;
	@Column
	@JsonProperty
	private String descricaoBem;
	@Column
	@JsonProperty
	private double valorBem;
	@Column(nullable = false)
	private Date createdAt;
	@Column(nullable = true)
	private Date updatedAt;
		
	
	public long getId() {
		return id;
	}
	@PrePersist
	private void setCandidatoId() {
		this.candidatoId = Long.parseLong("" + ano + sequencial);
		setCreatedAt();
	}
	public long getCandidatoId(){
		return candidatoId;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getDescricaoEleicao() {
		return descricaoEleicao;
	}
	public void setDescricaoEleicao(String descricaoEleicao) {
		this.descricaoEleicao = descricaoEleicao;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public long getSequencial() {
		return sequencial;
	}
	public void setSequencial(long sequencial) {
		this.sequencial = sequencial;
	}
	public int getCodBem() {
		return codBem;
	}
	public void setCodBem(int codBem) {
		this.codBem = codBem;
	}
	public String getTipoBem() {
		return tipoBem;
	}
	public void setTipoBem(String tipoBem) {
		this.tipoBem = tipoBem;
	}
	public String getDescricaoBem() {
		return descricaoBem;
	}
	public void setDescricaoBem(String descricaoBem) {
		this.descricaoBem = descricaoBem;
	}
	public double getValorBem() {
		return valorBem;
	}
	public void setValorBem(double valorBem) {
		this.valorBem = valorBem;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	//@PrePersist
	private void setCreatedAt() {
		this.createdAt = new Date();
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	@PreUpdate
	private void setUpdatedAt() {
		this.updatedAt = new Date();
	}
	@Override
	public String toString(){
		return sequencial + " - " + tipoBem + " - " + descricaoBem;
	}
}
