package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Programador;

public class ProgramadorDAO implements IProgramadorDAO {

	
	private Connection c;
	
	public ProgramadorDAO() throws ClassNotFoundException, SQLException{
		IConnectDAO gDAO = new ConnectDAO();
		c = gDAO.getCon();
	}
	
	
	@Override
	public void inserir(Programador pro) throws SQLException {
		String sql = "INSERT INTO Programador (idProg, nome, RG, salario, endereço, dataContrato, experiencia) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pro.getIdProg());
		ps.setString(2, pro.getNome());
		ps.setString(3, pro.getRG());
		ps.setDouble(4, pro.getSalario());
		ps.setString(5, pro.getEndereco());
		ps.setDate(6, java.sql.Date.valueOf(pro.getDataContrato().toString()));
		ps.setBoolean(7, pro.isExperiencia());
		ps.execute();
		ps.close();
	}
	@Override
	public void atualizar(Programador pro) throws SQLException {
		String sql = "UPDATE Programador SET nome = ?, RG = ?, salario = ?, endereço = ?,  experiencia = ? WHERE idProg = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, pro.getNome());
		ps.setString(2, pro.getRG());
		ps.setDouble(3, pro.getSalario());
		ps.setString(4, pro.getEndereco());
		ps.setBoolean(5, pro.isExperiencia());
		ps.setInt(6, pro.getIdProg());
		ps.execute();
		ps.close();
	}
	@Override
	public void excluir(Programador pro) throws SQLException {
		String sql = "DELETE Programador WHERE idProg = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pro.getIdProg());
		ps.execute();
		ps.close();
	}
	@Override
	public Programador consultar(Programador pro) throws SQLException {
		String sql = "SELECT idProg, nome, RG, salario, endereço, dataContrato, experiencia FROM Programador WHERE idProg = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pro.getIdProg());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			pro.setIdProg(rs.getInt("idProg"));
			pro.setNome(rs.getString("nome"));
			pro.setRG(rs.getString("RG"));
			pro.setSalario(rs.getDouble("salario"));
			pro.setEndereco(rs.getString("endereço"));
			pro.setDataContrato(rs.getDate("dataContrato"));
			pro.setExperiencia(rs.getBoolean("experiencia"));
		}
		rs.close();
		ps.close();
		return pro;
	}
	@Override
	public List<Programador> consultar() throws SQLException {
		List<Programador> listaProg = new ArrayList<Programador>();
		String sql = "SELECT idProg, nome, RG, salario, endereço, dataContrato, experiencia FROM Programador";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			Programador pro = new Programador();
			pro.setIdProg(rs.getInt("idProg"));
			pro.setNome(rs.getString("nome"));
			pro.setRG(rs.getString("RG"));
			pro.setSalario(rs.getDouble("salario"));
			pro.setEndereco(rs.getString("endereço"));
			pro.setDataContrato(rs.getDate("dataContrato"));
			pro.setExperiencia(rs.getBoolean("experiencia"));
			
			listaProg.add(pro);
			
		}
		rs.close();
		ps.close();
		
		return listaProg;
	}
	@Override
	public int proximoId() throws SQLException {
		String sql = "SELECT MAX(idProg) + 1 AS proximoId FROM Programador";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			return rs.getInt("proximoId");
		}else{
			return 1;
		}
	}
}
