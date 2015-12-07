package model;

import java.util.Date;

public class Programador {
	private int idProg;
	private String nome;
	private String RG;
	private double salario;
	private String endereco;
	private Date dataContrato;
	private boolean experiencia;
	
	public int getIdProg() {
		return idProg;
	}
	public void setIdProg(int idProg) {
		this.idProg = idProg;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Date getDataContrato() {
		return dataContrato;
	}
	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
	}
	
	public boolean isExperiencia() {
		return experiencia;
	}
	public void setExperiencia(boolean experiencia) {
		this.experiencia = experiencia;
	}
	
}
