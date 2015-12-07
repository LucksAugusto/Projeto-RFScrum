package persistance;

import java.sql.SQLException;
import java.util.List;

import model.Projeto;
public interface IProjetoDAO {
	public void inserir(Projeto pro) throws SQLException;
	public void atualizar(Projeto pro) throws SQLException;
	public void excluir(Projeto pro) throws SQLException;
	public Projeto consultar(Projeto pro) throws SQLException;
	public List<Projeto> consultar() throws SQLException;
	public int proximoId() throws SQLException;
	
}
