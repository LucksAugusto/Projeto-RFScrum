package model;

public class Tasks {
	private String nomeTask;
	private int idProjeto;
	private String categoriaTask;
	private String descricaoTask;
	private int pontoTask;
	private boolean estadoTask;
	private int numSprint;
	
	public String getNomeTask() {
		return nomeTask;
	}
	public void setNomeTask(String nomeTask) {
		this.nomeTask = nomeTask;
	}
	
	public String getDescricaoTask() {
		return descricaoTask;
	}
	public void setDescricaoTask(String descricaoTask) {
		this.descricaoTask = descricaoTask;
	}
	
	public int getPontoTask() {
		return pontoTask;
	}
	public void setPontoTask(int pontoTask) {
		this.pontoTask = pontoTask;
	}
	
	public boolean isEstadoTask() {
		return estadoTask;
	}
	public void setEstadoTask(boolean estadoTask) {
		this.estadoTask = estadoTask;
	}
	public int getIdProjeto() {
		return idProjeto;
	}
	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}
	public String getCategoriaTask() {
		return categoriaTask;
	}
	public void setCategoriaTask(String categoriaTask) {
		this.categoriaTask = categoriaTask;
	}
	public int getNumSprint() {
		return numSprint;
	}
	public void setNumSprint(int numSprint) {
		this.numSprint = numSprint;
	}
	
	
}
