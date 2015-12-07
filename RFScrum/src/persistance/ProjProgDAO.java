package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ProjProg;

public class ProjProgDAO implements IProjProgDAO{

	private Connection c;
	
	public ProjProgDAO() throws ClassNotFoundException, SQLException{
		IConnectDAO gDAO = new ConnectDAO();
		c = gDAO.getCon();
	}
	
	
	
	@Override
	public void inserir(ProjProg pp) throws SQLException {
		String sql = "INSERT INTO ProjProg (projeto, programador, scrumMaster) VALUES (?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pp.getProjeto());
		ps.setInt(2, pp.getProgramador());
		ps.setBoolean(3, pp.isScrumMaster());

		ps.execute();
		ps.close();
	}

	@Override
	public void atualizar(ProjProg pp) throws SQLException {
		String sql = "UPDATE ProjProg SET scrumMaster = ? WHERE projeto = ? and programador = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setBoolean(1, pp.isScrumMaster());
		ps.setInt(2, pp.getProjeto());
		ps.setInt(3, pp.getProgramador());
		ps.execute();
		ps.close();
	}

	@Override
	public void excluir(ProjProg pp) throws SQLException {
		String sql = "DELETE ProjProg WHERE projeto = ? and programador = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pp.getProjeto());
		ps.setInt(2, pp.getProgramador());
		ps.execute();
		ps.close();
	}

	@Override
	public ProjProg consultar(ProjProg pp) throws SQLException {
		String sql = "SELECT projeto, programador, scrumMaster FROM Projeto WHERE projeto = ? and programador = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pp.getProjeto());
		ps.setInt(2, pp.getProgramador());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			pp.setProjeto(rs.getInt("projeto"));
			pp.setProgramador(rs.getInt("programador"));
			pp.setScrumMaster(rs.getBoolean("scrumMaster"));
		}
		rs.close();
		ps.close();
		return pp;
	}

	@Override
	public List<ProjProg> consultar() throws SQLException {
		List<ProjProg> listaPP = new ArrayList<ProjProg>();
		String sql = "SELECT projeto, programador, scrumMaster FROM Projeto";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			ProjProg pp = new ProjProg();
			pp.setProjeto(rs.getInt("projeto"));
			pp.setProgramador(rs.getInt("programador"));
			pp.setScrumMaster(rs.getBoolean("scrumMaster"));
			
			listaPP.add(pp);
			
		}
		rs.close();
		ps.close();
		
		return listaPP;
	}

}
