package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Projeto;

public class ProjetoDAO implements IProjetoDAO{

	private Connection c;
	
	public ProjetoDAO() throws ClassNotFoundException, SQLException{
		IConnectDAO gDAO = new ConnectDAO();
		c = gDAO.getCon();
	}
	
	
	@Override
	public void inserir(Projeto pro) throws SQLException {
		String sql = "INSERT INTO Projeto (codProjeto, nomePrjeto, productOwner) VALUES (?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pro.getCodProjeto());
		ps.setString(2, pro.getNomeProjeto());
		ps.setInt(3, pro.getProductOwner());

		ps.execute();
		ps.close();
	}

	@Override
	public void atualizar(Projeto pro) throws SQLException {
		String sql = "UPDATE Projeto SET nomeProjeto = ?, productOwner = ? WHERE codProjeto = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, pro.getNomeProjeto());
		ps.setInt(2, pro.getProductOwner());
		
		ps.setInt(3, pro.getCodProjeto());
		ps.execute();
		ps.close();
	}

	@Override
	public void excluir(Projeto pro) throws SQLException {
		String sql = "DELETE Projeto WHERE codProjeto = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pro.getCodProjeto());
		ps.execute();
		ps.close();
	}

	@Override
	public Projeto consultar(Projeto pro) throws SQLException {
		String sql = "SELECT codProjeto, nomeProjeto, productOwner FROM Projeto WHERE codProjeto = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pro.getCodProjeto());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			pro.setCodProjeto(rs.getInt("codProjeto"));
			pro.setNomeProjeto(rs.getString("nomeProjeto"));
			pro.setProductOwner(rs.getInt("productOwner"));
		}
		rs.close();
		ps.close();
		return pro;
	}

	@Override
	public List<Projeto> consultar() throws SQLException {
		List<Projeto> listaProj = new ArrayList<Projeto>();
		String sql = "SELECT codProjeto, nomeProjeto, productOwner FROM Projeto";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			Projeto pro = new Projeto();
			pro.setCodProjeto(rs.getInt("codProjeto"));
			pro.setNomeProjeto(rs.getString("nomeProjeto"));
			pro.setProductOwner(rs.getInt("productOwner"));
			
			listaProj.add(pro);
			
		}
		rs.close();
		ps.close();
		
		return listaProj;
	}

	@Override
	public int proximoId() throws SQLException {
		String sql = "SELECT MAX(codProjeto) + 1 AS proximoId FROM Projeto";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			return rs.getInt("proximoId");
		}else{
			return 1;
		}
	}
	
}