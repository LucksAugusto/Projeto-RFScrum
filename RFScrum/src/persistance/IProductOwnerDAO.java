package persistance;

import java.util.List;
import java.sql.SQLException;

import model.ProductOwner;
public interface IProductOwnerDAO {
	public void inserir(ProductOwner ped) throws SQLException;
	public void atualizar(ProductOwner ped) throws SQLException;
	public void excluir(ProductOwner ped) throws SQLException;
	public ProductOwner consultar(ProductOwner ped) throws SQLException;
	public List<ProductOwner> consultar() throws SQLException;
	public int proximoId() throws SQLException;
}
