package persistance;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectDAO {
	
	public Connection getCon() throws ClassCastException, SQLException;
	
}
