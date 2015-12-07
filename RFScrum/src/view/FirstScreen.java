package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistance.ConnectDAO;

public class FirstScreen extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel painel;
	private JMenuBar menu;
	private JMenu menuCad;
	private JMenuItem menuPO;
	private JMenuItem menuProg;
	private JMenuBar menuBar;
	private JButton btnLogin;
	private JButton btnNovaEquipe;
	
	Login telaLogin = new Login();
	ProgramadorCRUD telaProgCRUD = new ProgramadorCRUD();
	ProductOwnerCRUD telaPOCRUD = new ProductOwnerCRUD();
	NovaEquipe telaNovaEquipe = new NovaEquipe();
	
	public FirstScreen() {
		setResizable(false);
		setTitle("RFScrum");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 216, 213);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		painel.setLayout(null);
		
		setContentPane(painel);
		
		menu = new JMenuBar();
		menu.setBounds(0, 0, 210, 21);
		menuCad = new JMenu("Cadastros");
		menuPO = new JMenuItem("Product Owners");
		menuProg = new JMenuItem("Programadores");
		menuBar = new JMenuBar();
		
		menu.add(menuCad);
		menuCad.add(menuPO);
		menuCad.add(menuProg);
		menuCad.add(menuBar);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(49, 48, 113, 23);
		btnNovaEquipe = new JButton("Nova Equipe");		
		btnNovaEquipe.setBounds(49, 97, 113, 23);
		
		painel.add(menu);
		painel.add(btnLogin);		
		painel.add(btnNovaEquipe);
		
		
		btnLogin.addActionListener(this);
		btnNovaEquipe.addActionListener(this);
		menuPO.addActionListener(this);
		menuProg.addActionListener(this);
	}
	
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

	@Override
	public void actionPerformed(ActionEvent a) {
		String cmd = a.getActionCommand();
		if("Login".equals(cmd)) {
		telaLogin.setVisible(true);
		telaLogin.setAlwaysOnTop(true);
		telaLogin.setLocationRelativeTo(null);
		this.setVisible(false);
		} else if("Nova Equipe".equals(cmd)) {
			telaNovaEquipe.setVisible(true);
			telaNovaEquipe.setAlwaysOnTop(true);
			telaNovaEquipe.setLocationRelativeTo(null);
		} else if("Product Owners".equals(cmd)) {
			telaPOCRUD.setVisible(true);
			telaPOCRUD.setAlwaysOnTop(true);
			telaPOCRUD.setLocationRelativeTo(null);
		} else if("Programadores".equals(cmd)) {
			telaProgCRUD.setVisible(true);
			telaProgCRUD.setAlwaysOnTop(true);
			telaProgCRUD.setLocationRelativeTo(null);
		} else {
			System.out.println("Error");
		}
		}

}
