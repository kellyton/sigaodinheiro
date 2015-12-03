/* Copyright 2013 de Kellyton Brito. 
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

//import services.CandidatoService;

/** 
 * @author Kellyton Brito
 *
 */

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Candidato {
	
	/*
	 * ID é calculado automaticamente pela concatenação
	 * do ano com o numero do candidato. Tem que ser assim pois
	 * o número do candidato pode repetir em eleições distintas. 
	 */
	@Id
	@JsonProperty
	private long id;
	@Column
	private int ano;//usado para o ID
	@Column
	private String descricaoEleicao;
	@Column
	@JsonProperty
	private String uf;
	@Column
	private int codCargo;
	@Column
	@JsonProperty
	private String nomeCargo;
	@Column
	@JsonProperty
	private String nomeParlamentar;
	@Column
	@JsonProperty
	private String nomeCompleto;
	@Column
	@JsonProperty
	private long sequencial;//usado para o ID. concatena com o ano
	@Column
	@JsonProperty
	private int numero;
	@Column
	private int codSitCandidatura;
	@Column
	@JsonProperty
	public String nomeSitCandidatura;
	@Column
	@JsonProperty
	private String siglaPartido;
	@Column
	@JsonProperty
	private String nomePartido;
	@Column
	@JsonProperty
	private long codLegenda;
	@Column
	@JsonProperty
	private String nomeLegenda;
	@Column
	@JsonProperty
	private String composicaoLegenda;
	@Column
	private Date nascimento;
	@Column
	private String titulo;
	@Column
	@JsonProperty
	private String sexo;
	@Column
	private int codRaca;
	@Column
	@JsonProperty
	private String nomeRaca;
	@Column
	private int codOcupacao;
	@Column
	@JsonProperty
	private String nomeOcupacao;
	@Column
	private int codEscolaridade;
	@Column
	@JsonProperty
	private String nomeEscolaridade;
	@Column
	@JsonProperty
	private String municipioNascimento;
	@Column
	@JsonProperty
	private String estadoNascimento;
	@Column
	private double maxGasto;
	@Column
	@JsonProperty
	private double totalBens;
	@Column
	@JsonProperty
	private double totalArrecadado;
	@Column
	private String codCargoAtual;
	@Column
	private int tipoCargoAtual;//1 = senador; 2 = deputado federal; 0 = outros;
	
	@JsonProperty
	private boolean ehParlamentarAtual(){
		switch(tipoCargoAtual){
			case 1:
				return true;
			case 2:
				return true;
			default:
				return false;
		}
	}
	
	@JsonProperty
	private String cargoParlamentarAtual(){
		switch(tipoCargoAtual){
			case 1:
				return "SENADOR";
			case 2:
				return "DEPUTADO FEDERAL";
			default:
				return "";
		}
	}
	@JsonProperty
	private String codParlamentarAtual(){
		if (codCargoAtual == null) return "";
		return codCargoAtual;
	}
	
	@Column(nullable = false)
	private int resultado;
	
	@Column(nullable = false)
	private Date createdAt;
	
	@Column(nullable = true)
	private Date updatedAt;
	
	
	////////////////////////////
	/*public double getTotalArrecadadoPartido(){
		return CandidatoService.getTotalArrecadadoPartido(siglaPartido.toUpperCase());
	}*/
	
	public String getCargoAtual(){
		
		if (tipoCargoAtual == 1){
			return "SENADOR";
		} else if (tipoCargoAtual == 2){
			return "DEPUTADO FEDERAL";
		} else {
			if ( nomeOcupacao.contains("PRESIDENTE")
				|| nomeOcupacao.contains("GOVERNADOR")
				|| nomeOcupacao.contains("SENADOR")
				|| nomeOcupacao.contains("DEPUTADO")
				|| nomeOcupacao.contains("SUPLENTE")) {
				
				return nomeOcupacao;
			} else {
				return "";
			}
		}
	}
	
	public long getId() {
		return id;
	}
	@PrePersist
	private void setId() {
		this.id = Long.parseLong("" + ano + sequencial);
		setCreatedAt();
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
	public int getCodCargo() {
		return codCargo;
	}
	public void setCodCargo(int codCargo) {
		this.codCargo = codCargo;
	}
	public String getNomeCargo() {
		return nomeCargo;
	}
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getNomeParlamentar() {
		return nomeParlamentar;
	}
	public void setNomeParlamentar(String nomeParlamentar) {
		this.nomeParlamentar = nomeParlamentar;
	}
	public long getSequencial() {
		return sequencial;
	}
	public void setSequencial(long sequencial) {
		this.sequencial = sequencial;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCodSitCandidatura() {
		return codSitCandidatura;
	}
	public void setCodSitCandidatura(int codSitCandidatura) {
		this.codSitCandidatura = codSitCandidatura;
	}
	public String getNomeSitCandidatura() {
		return nomeSitCandidatura;
	}
	public void setNomeSitCandidatura(String nomeSitCandidatura) {
		this.nomeSitCandidatura = nomeSitCandidatura;
	}
	public String getSiglaPartido() {
		return siglaPartido;
	}
	public void setSiglaPartido(String siglaPartido) {
		this.siglaPartido = siglaPartido;
	}
	public String getNomePartido() {
		return nomePartido;
	}
	public void setNomePartido(String nomePartido) {
		this.nomePartido = nomePartido;
	}
	public long getCodLegenda() {
		return codLegenda;
	}
	public void setCodLegenda(long codLegenda) {
		this.codLegenda = codLegenda;
	}
	public String getNomeLegenda() {
		return nomeLegenda;
	}
	public void setNomeLegenda(String nomeLegenda) {
		this.nomeLegenda = nomeLegenda;
	}
	public String getComposicaoLegenda() {
		return composicaoLegenda;
	}
	public void setComposicaoLegenda(String composicaoLegenda) {
		this.composicaoLegenda = composicaoLegenda;
	}
	public int getCodOcupacao() {
		return codOcupacao;
	}
	public void setCodOcupacao(int codOcupacao) {
		this.codOcupacao = codOcupacao;
	}
	public String getNomeOcupacao() {
		return capitalize(nomeOcupacao);
	}
	public void setNomeOcupacao(String nomeOcupacao) {
		this.nomeOcupacao = nomeOcupacao;		
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getCodRaca() {
		return codRaca;
	}
	public void setCodRaca(int codRaca) {
		this.codRaca = codRaca;
	}
	public String getNomeRaca() {
		return nomeRaca;
	}
	public void setNomeRaca(String nomeRaca) {
		this.nomeRaca = nomeRaca;
	}
	
	public int getCodEscolaridade() {
		return codEscolaridade;
	}
	public void setCodEscolaridade(int codEscolaridade) {
		this.codEscolaridade = codEscolaridade;
	}
	public String getNomeEscolaridade() {
		return capitalize(nomeEscolaridade);
	}
	public void setNomeEscolaridade(String nomeEscolaridade) {
		this.nomeEscolaridade = nomeEscolaridade;
	}
	public String getMunicipioNascimento() {
		return capitalize(municipioNascimento);
	}
	public void setMunicipioNascimento(String municipioNascimento) {
		this.municipioNascimento = municipioNascimento;
	}
	public String getEstadoNascimento() {
		return estadoNascimento;
	}
	public void setEstadoNascimento(String estadoNascimento) {
		this.estadoNascimento = estadoNascimento;
	}
	public double getMaxGasto() {
		return maxGasto;
	}
	public void setMaxGasto(double maxGasto) {
		this.maxGasto= maxGasto;
	}
	public double getTotalBens() {
		return totalBens;
	}
	public void setTotalBens(double totalBens) {
		this.totalBens = totalBens;
	}
	public double getTotalArrecadado() {
		return totalArrecadado;
	}
	public void setTotalArrecadado(double totalArrecadado) {
		this.totalArrecadado = totalArrecadado;
	}
	public String getCodCargoAtual() {
		return codCargoAtual;
	}
	public void setCodCargoAtual(String codCargoAtual) {
		this.codCargoAtual = codCargoAtual;
	}
	public int getTipoCargoAtual() {
		return tipoCargoAtual;
	}
	public void setTipoCargoAtual(int tipoCargoAtual) {
		this.tipoCargoAtual = tipoCargoAtual;
	}
	
	public String getResultadoExtenso(){
		switch(resultado){
			case CandidatoResultado.RES_ELEITO:
				return "ELEITO";
			case CandidatoResultado.RES_TURNO2:
				return "SEGUNDO TURNO";
			case CandidatoResultado.RES_NAO_ELEITO:
				return "NÃO ELEITO";
			default:
				return "";
		}
	}
	
	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	//////////////////////////
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
		return nomeParlamentar + " - " + numero + " - " + siglaPartido;
	}
	
	public String getPartido() {
		return siglaPartido;
	}

	public String getPhotoURL() {
		return "http://divulgacand2014.tse.jus.br/divulga-cand-2014/eleicao/2014/UF/"+ uf + "/foto/" + sequencial + ".jpg";
	}

/*	public int getCargoEleito() {
		//codCargo = 5 é senador, 6 é dep federal
		switch (codCargo){
			case 5:
				return UsuarioAcompanhamento.SENADOR_ELEITO;
			case 6:
				return UsuarioAcompanhamento.DEPUTADO_FEDERAL_ELEITO;
			default:
				return 0;
		}
	}*/

	public String getIdExercicio() {
		return String.valueOf(id);
	}

	public String getCargoNome() {
		return nomeCargo;
	}

	public String getPeriodo() {
		//codCargo = 5 é senador, 6 é dep federal
		//só senador são 8 anos
		if (codCargo == 5){
			return "2015 a 2022";
		} else {
			return "2015 a 2018";
		}
	}

	/**
	 * Coloca em maiúsculas a primeira letra das palavras que tenham mais de 2 letras
	 * @param nomeOcupacao2
	 * @return
	 */
	private String capitalize(String palavra) {
		palavra = palavra.toLowerCase();
		String partes []= palavra.split(" ");
		StringBuffer palavraFinal = new StringBuffer();
		for (int i = 0; i < partes.length; i++){
			String temp = partes[i];
			if (temp.length() < 3 && i != 0){//artigo e tal, não faz nada. mas capitaliza se for a primeira
				palavraFinal.append(" " + temp);
			} else {
				palavraFinal.append(" " + temp.substring(0, 1).toUpperCase() + temp.substring(1));
			}
		}
		return palavraFinal.toString().trim();
	}
	
/*	@Override
	public int compareTo(IPoliticoExercicio o) {
		return nomeParlamentar.compareTo(o.getNomeParlamentar());
	}*/
	
}
