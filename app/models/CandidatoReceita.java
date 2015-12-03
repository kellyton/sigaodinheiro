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

import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.swing.text.MaskFormatter;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class CandidatoReceita {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	@JsonProperty
	private int ano;
	@Column
	@JsonProperty
	private String partido;
	@Column
	@JsonProperty
	private long candidatoId;
	@Column
	@JsonProperty
	private String cnpj;
	@Column
	@JsonProperty
	private String nomeDoador;
	@Column
	@JsonProperty
	private String nomeDoadorReceita;
	@Column
	@JsonProperty
	private String atividadeEconomica;
	@Column
	@JsonProperty
	private Date data;
	@Column
	@JsonProperty
	private double valor;
	@Column
	@JsonProperty
	private String tipoReceita;
	@Column
	@JsonProperty
	private String fonteRecurso;
	@Column
	@JsonProperty
	private String especieRecurso;
	@Column
	@JsonProperty
	private String descricaoReceita;
	
	@Column(nullable = false)
	private Date createdAt;
	
	@Column(nullable = true)
	private Date updatedAt;
	
	//////////////////
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}

	public long getCandidatoId() {
		return candidatoId;
	}
	public void setCandidatoId(long candidatoId) {
		this.candidatoId = candidatoId;
	}
	public String getCnpj() {
		return cnpj;
	}
	
	public String getCnpjFormatted(){
		MaskFormatter mask;
		
		String newValue = cnpj;
		
        try {
        
        	if (cnpj.length() == 11){ //cpf
        		mask = new MaskFormatter("###.###.XXX-##");
        		newValue = cnpj.substring(0, 6) + cnpj.substring(9,11);
        	} else {
        		mask = new MaskFormatter("##.###.###/####-##");
        	}
		    mask.setValueContainsLiteralCharacters(false);
		    return mask.valueToString(newValue);
        
        } catch (ParseException e) {
			return "";
		}
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNomeDoador() {
		return nomeDoador;
	}
	public void setNomeDoador(String nomeDoador) {
		this.nomeDoador = nomeDoador;
	}
	public String getNomeDoadorReceita() {
		return nomeDoadorReceita;
	}
	public void setNomeDoadorReceita(String nomeDoadorReceita) {
		this.nomeDoadorReceita = nomeDoadorReceita;
	}
	public String getAtividadeEconomica() {
		return atividadeEconomica;
	}
	public void setAtividadeEconomica(String atividadeEconomica) {
		this.atividadeEconomica = atividadeEconomica;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getTipoReceita() {
		return tipoReceita;
	}
	public void setTipoReceita(String tipoReceita) {
		this.tipoReceita = tipoReceita;
	}
	public String getFonteRecurso() {
		return fonteRecurso;
	}
	public void setFonteRecurso(String fonteRecurso) {
		this.fonteRecurso = fonteRecurso;
	}
	public String getEspecieRecurso() {
		return especieRecurso;
	}
	public void setEspecieRecurso(String especieRecurso) {
		this.especieRecurso = especieRecurso;
	}
	public String getDescricaoReceita() {
		if (descricaoReceita.equals("#NULO")){
			return "";
		} else {
			return descricaoReceita;
		}
	}
	public void setDescricaoReceita(String descricaoReceita) {
		this.descricaoReceita = descricaoReceita;
	}
	
	//////////////
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

	@Override
	public String toString(){
		return candidatoId + " - " + cnpj + " - " + nomeDoador + " - " + valor;
	}
	
}
