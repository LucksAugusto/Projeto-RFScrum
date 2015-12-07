package view;

import java.sql.SQLException;

import persistance.ConnectDAO;

public class Main {

	public static void main(String[] args) {
			FirstScreen tela = new FirstScreen();
			tela.setVisible(true);
			tela.setAlwaysOnTop(true);
			tela.setLocationRelativeTo(null);
			ConnectDAO con = new ConnectDAO();
			try {
				con.getCon();
			} catch (ClassCastException | SQLException e) {
				e.printStackTrace();
			}
		
	}

}
