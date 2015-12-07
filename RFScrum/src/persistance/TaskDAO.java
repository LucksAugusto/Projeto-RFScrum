package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tasks;

public class TaskDAO implements ITasksDAO {

	private Connection c;
	
	public TaskDAO() throws ClassNotFoundException, SQLException{
		IConnectDAO gDAO = new ConnectDAO();
		c = gDAO.getCon();
	}
	
	
	
	@Override
	public void inserir(Tasks t) throws SQLException {
		String sql = "INSERT INTO Tasks (nomeTask, idProjeto, categoriaTask, descricaoTask, pontoTask, estadoTask, numSprint) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, t.getNomeTask());
		ps.setInt(2, t.getIdProjeto());
		ps.setString(3, t.getCategoriaTask());
		ps.setString(4, t.getDescricaoTask());
		ps.setInt(5, t.getPontoTask());
		ps.setBoolean(6, t.isEstadoTask());
		ps.setInt(7, t.getNumSprint());
		
		ps.execute();
		ps.close();
	}

	@Override
	public void atualizar(Tasks t) throws SQLException {
		String sql = "UPDATE Tasks SET idProjeto = ?, categoriaTask = ?, descricaoTask = ?, pontoTask = ?, estadoTask = ?, numSprint = ? WHERE nomeTask = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, t.getIdProjeto());
		ps.setString(2, t.getCategoriaTask());
		ps.setString(3, t.getDescricaoTask());
		ps.setInt(4, t.getPontoTask());
		ps.setBoolean(5, t.isEstadoTask());
		ps.setInt(6, t.getNumSprint());
		ps.setString(4, t.getNomeTask());
		
		ps.execute();
		ps.close();
	}

	@Override
	public void excluir(Tasks t) throws SQLException {
		String sql = "DELETE Tasks WHERE nomeTask = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, t.getNomeTask());
		ps.execute();
		ps.close();
	}

	@Override
	public Tasks consultar(Tasks t) throws SQLException {
		String sql = "SELECT nomeTask, idProjeto, categoriaTask, descricaoTask, pontoTask, estadoTask, numSprint FROM Tasks WHERE nomeTask = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, t.getNomeTask());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			t.setNomeTask(rs.getString("nomeTask"));
			t.setIdProjeto(rs.getInt("idProjeto"));
			t.setCategoriaTask(rs.getString("categoriaTask"));
			t.setDescricaoTask(rs.getString("descricaoTask"));
			t.setPontoTask(rs.getInt("pontoTask"));
			t.setEstadoTask(rs.getBoolean("estadoTask"));
			t.setNumSprint(rs.getInt("numSprint"));
			
			
		}
		rs.close();
		ps.close();
		return t;
	}

	@Override
	public List<Tasks> consultar() throws SQLException {
		List<Tasks> listaTasks = new ArrayList<Tasks>();
		String sql = "SELECT nomeTask, idProjeto, categoriaTask, descricaoTask, pontoTask, estadoTask, numSprint FROM Tasks";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			Tasks t = new Tasks();
			t.setNomeTask(rs.getString("nomeTask"));
			t.setIdProjeto(rs.getInt("idProjeto"));
			t.setCategoriaTask(rs.getString("categoriaTask"));
			t.setDescricaoTask(rs.getString("descricaoTask"));
			t.setPontoTask(rs.getInt("pontoTask"));
			t.setEstadoTask(rs.getBoolean("estadoTask"));
			t.setNumSprint(rs.getInt("numSprint"));
			
			listaTasks.add(t);
			
		}
		rs.close();
		ps.close();
		
		return listaTasks;
	}

	
}
