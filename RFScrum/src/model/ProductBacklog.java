package model;

public class ProductBacklog {
	private int idPB;
	private char prioridade;
	private String categoria;
	private String descricao;
	private String estoria;
	
	public int getIdPB() {
		return idPB;
	}
	public void setIdPB(int idPB) {
		this.idPB = idPB;
	}
	
	public char getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(char prioridade) {
		this.prioridade = prioridade;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getEstoria() {
		return estoria;
	}
	public void setEstoria(String estoria) {
		this.estoria = estoria;
	}
	
}
