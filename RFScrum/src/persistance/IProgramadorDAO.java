package persistance;

import java.sql.SQLException;
import java.util.List;

import model.Programador;
public interface IProgramadorDAO {
	public void inserir(Programador ped) throws SQLException;
	public void atualizar(Programador ped) throws SQLException;
	public void excluir(Programador ped) throws SQLException;
	public Programador consultar(Programador ped) throws SQLException;
	public List<Programador> consultar() throws SQLException;
	public int proximoId() throws SQLException;
}
