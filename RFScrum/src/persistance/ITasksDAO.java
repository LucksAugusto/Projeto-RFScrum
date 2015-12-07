package persistance;

import java.sql.SQLException;
import java.util.List;

import model.Tasks;
public interface ITasksDAO {
	public void inserir(Tasks ped) throws SQLException;
	public void atualizar(Tasks ped) throws SQLException;
	public void excluir(Tasks ped) throws SQLException;
	public Tasks consultar(Tasks ped) throws SQLException;
	public List<Tasks> consultar() throws SQLException;
}
