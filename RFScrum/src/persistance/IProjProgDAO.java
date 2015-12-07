package persistance;

import java.sql.SQLException;
import java.util.List;

import model.ProjProg;

public interface IProjProgDAO {

	public void inserir(ProjProg pp) throws SQLException;
	public void atualizar(ProjProg pp) throws SQLException;
	public void excluir(ProjProg pp) throws SQLException;
	public ProjProg consultar(ProjProg pp) throws SQLException;
	public List<ProjProg> consultar() throws SQLException;
	
}
	