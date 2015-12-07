package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ProductBacklog;

public class ProductBacklogDAO implements IProductBacklogDAO {

private Connection c;
	
	public ProductBacklogDAO() throws ClassNotFoundException, SQLException{
		IConnectDAO gDAO = new ConnectDAO();
		c = gDAO.getCon();
	}
	
	
	
	
	
	@Override
	public void inserir(ProductBacklog pb) throws SQLException {
		String sql = "INSERT INTO ProductBacklog (idPB, prioridade, categoria, descricao, estoria) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pb.getIdPB());
		ps.setString(2, String.valueOf(pb.getPrioridade()));
		ps.setString(3, pb.getCategoria());
		ps.setString(4, pb.getDescricao());
		ps.setString(5, pb.getEstoria());
		
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizar(ProductBacklog pb) throws SQLException {
		String sql = "UPDATE ProductBacklog SET prioridade = ?, categoria = ?, descricao = ?, estoria = ? WHERE idPB = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, String.valueOf(pb.getPrioridade()));
		ps.setString(2, pb.getCategoria());
		ps.setString(3, pb.getDescricao());
		ps.setString(4, pb.getEstoria());
		ps.setInt(5, pb.getIdPB());
		ps.execute();
		ps.close();
	}

	@Override
	public void excluir(ProductBacklog pb) throws SQLException {
		String sql = "DELETE ProductBacklog WHERE idPB = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pb.getIdPB());
		ps.execute();
		ps.close();
	}

	@Override
	public ProductBacklog consultar(ProductBacklog pb) throws SQLException {
		String sql = "SELECT idPB, prioridade, categoria, descricao, estoria FROM ProductBacklog WHERE idPB = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pb.getIdPB());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			pb.setIdPB(rs.getInt("idPB"));
			pb.setPrioridade(rs.getString("prioridade").charAt(0));
			pb.setCategoria(rs.getString("categoria"));
			pb.setDescricao(rs.getString("descricao"));
			pb.setEstoria(rs.getString("estoria"));
		}
		rs.close();
		ps.close();
		return pb;
	}

	@Override
	public List<ProductBacklog> consultar() throws SQLException {
		List<ProductBacklog> listaPB = new ArrayList<ProductBacklog>();
		String sql = "SELECT idPB, prioridade, categoria, descricao, estoria FROM ProductBacklog";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			ProductBacklog pb = new ProductBacklog();
			pb.setIdPB(rs.getInt("idPB"));
			pb.setPrioridade(rs.getString("prioridade").charAt(0));
			pb.setCategoria(rs.getString("categoria"));
			pb.setDescricao(rs.getString("descricao"));
			pb.setEstoria(rs.getString("estoria"));
			
			listaPB.add(pb);
			
		}
		rs.close();
		ps.close();
		
		return listaPB;
	}

	@Override
	public int proximoId() throws SQLException {
		String sql = "SELECT MAX(idPB) + 1 AS proximoId FROM ProductBacklog";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			return rs.getInt("proximoId");
		}else{
			return 1;
		}
	}

}
