package model;

import java.sql.Date;

public class ProductOwner {
	private int idPO;
	private String nome;
	private String empresa;
	private String CNPJ;
	private String endereco;
	private Date dataIng;
	
	public int getIdPO() {
		return idPO;
	}
	public void setIdPO(int idPO) {
		this.idPO = idPO;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Date getDataIng() {
		return dataIng;
	}
	public void setDataIng(java.sql.Date date) {
		this.dataIng = date;
	}
	
}
