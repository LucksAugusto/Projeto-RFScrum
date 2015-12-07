package persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ProductOwner;

public class ProductOwnerDAO implements IProductOwnerDAO {

	private Connection c;
	
	public ProductOwnerDAO() throws ClassNotFoundException, SQLException{
		IConnectDAO gDAO = new ConnectDAO();
		c = gDAO.getCon();
	}
	

	
	@Override
	public void inserir(ProductOwner po) throws SQLException {
		String sql = "INSERT INTO ProductOwner (idPO, nome, empresa, CNPJ, endereco, dataIng) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, po.getIdPO());
		ps.setString(2, po.getNome());
		ps.setString(3, po.getEmpresa());
		ps.setString(4, po.getCNPJ());
		ps.setString(5, po.getEndereco());
		ps.setDate(6, (Date) po.getDataIng());
		
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizar(ProductOwner po) throws SQLException {
		String sql = "UPDATE ProductOwner SET nome = ?, empresa = ?, CNPJ = ?, endereco = ? WHERE idPO = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, po.getNome());
		ps.setString(2, po.getEmpresa());
		ps.setString(3, po.getCNPJ());
		ps.setString(4, po.getEndereco());
		ps.setInt(5, po.getIdPO());
		ps.execute();
		ps.close();
	}

	@Override
	public void excluir(ProductOwner po) throws SQLException {
		String sql = "DELETE ProductOwner WHERE idPO = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, po.getIdPO());
		ps.execute();
		ps.close();
	}

	@Override
	public ProductOwner consultar(ProductOwner po) throws SQLException {
		String sql = "SELECT idPO, nome, empresa, CNPJ, endereco, dataIng FROM ProductOwner WHERE idPO = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, po.getIdPO());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			po.setIdPO(rs.getInt("idPO"));
			po.setNome(rs.getString("nome"));
			po.setEmpresa(rs.getString("empresa"));
			po.setCNPJ(rs.getString("CNPJ"));
			po.setEndereco(rs.getString("endereco"));
			po.setDataIng(rs.getDate("dataIng"));
		}
		rs.close();
		ps.close();
		return po;
	}

	@Override
	public List<ProductOwner> consultar() throws SQLException {
		List<ProductOwner> listaPO = new ArrayList<ProductOwner>();
		String sql = "SELECT idPO, nome, empresa, CNPJ, endereco, dataIng FROM ProductOwner";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			ProductOwner po = new ProductOwner();
			po.setIdPO(rs.getInt("idPO"));
			po.setNome(rs.getString("nome"));
			po.setEmpresa(rs.getString("empresa"));
			po.setCNPJ(rs.getString("CNPJ"));
			po.setEndereco(rs.getString("endereco"));
			po.setDataIng(rs.getDate("dataIng"));
			
			listaPO.add(po);
			
		}
		rs.close();
		ps.close();
		
		return listaPO;
	}

	@Override
	public int proximoId() throws SQLException {
		String sql = "SELECT MAX(idPO) + 1 AS proximoId FROM ProductOwner";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			return rs.getInt("proximoId");
		}else{
			return 1;
		}
	}

}
