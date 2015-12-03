/* Copyright 2014 de Kellyton Brito. Este arquivo é parte 
* do programa MeuCongressoNacional.com . O MeuCongressoNacional.com 
* é um software livre; você pode redistribuí-lo e/ou modificá-lo 
* dentro dos termos da GNU Affero General Public License como 
* publicada pela Fundação do Software Livre (FSF) na versão 3 
* da Licença. Este programa é distribuído na esperança que possa 
* ser útil, mas SEM NENHUMA GARANTIA; sem uma garantia implícita 
* de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR. Veja 
* a licença para maiores detalhes, disponível em 
* meucongressonacional.com/license. Você deve ter recebido uma cópia 
* da GNU Affero General Public License, sob o título "LICENCA.txt", 
* junto com este programa, se não, acesse http://www.gnu.org/licenses/
**/

package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class CandidatoResultado {

	public static final int RES_ELEITO = 1;
	public static final int RES_TURNO2 = 2;
	public static final int RES_NAO_ELEITO = 0;
	
	@Id
	@JsonProperty
	private long candidatoId;
	@Column
	@JsonProperty
	private long votos;
	@Column
	@JsonProperty
	private long votosTotais;
	@Column
	@JsonProperty
	private float percentual;
	@Column
	@JsonProperty
	private int resultado;
	@Column
	private int ano;
	
	@Column(nullable = false)
	private Date createdAt;
	@Column(nullable = true)
	private Date updatedAt;
	public long getCandidatoId() {
		return candidatoId;
	}
	public void setCandidatoId(long candidatoId) {
		this.candidatoId = candidatoId;
	}
	public long getVotos() {
		return votos;
	}
	public void setVotos(long votos) {
		this.votos = votos;
	}
	public float getPercentual() {
		return percentual;
	}
	public void setPercentual(float percentual) {
		this.percentual = percentual;
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public long getVotosTotais() {
		return votosTotais;
	}
	public void setVotosTotais(long votosTotais) {
		this.votosTotais = votosTotais;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	@PrePersist
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
	
	public String toString(){
		return candidatoId + " - " + votos + " - " + percentual + " - " + resultado;
	}
	
}
