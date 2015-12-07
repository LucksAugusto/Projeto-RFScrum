package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDAO implements IConnectDAO {

	private static Connection con;
	
	@Override
	public Connection getCon() throws ClassCastException, SQLException {

		try { 
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=ScrumDB;namedPipe=true","sa","gu14021995");
			System.out.println("Conexao ok");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return con; 
	}


	public static void fechaConexao(){
		try {
			if(con!=null) con.close();
			con =null;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
