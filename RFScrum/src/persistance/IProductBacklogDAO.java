package persistance;

import java.util.List;
import java.sql.SQLException;

import model.ProductBacklog;

public interface IProductBacklogDAO {
	
	public void inserir(ProductBacklog ped) throws SQLException;
	public void atualizar(ProductBacklog ped) throws SQLException;
	public void excluir(ProductBacklog ped) throws SQLException;
	public ProductBacklog consultar(ProductBacklog ped) throws SQLException;
	public List<ProductBacklog> consultar() throws SQLException;
	public int proximoId() throws SQLException;
	
}
