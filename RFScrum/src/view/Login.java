package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame{

	private static final long serialVersionUID = 1L;

	private JPanel painelLogin;
	private JLabel lblNome;
	private JLabel lblCodigo;
	private JTextField txtNome;
	private JTextField txtCodigo;
	private JButton btnEntrar;
	
	public Login() {
		setResizable(false);
		setTitle("Login - RFScrum");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 272, 223);
		getContentPane().setLayout(null);
		painelLogin = new JPanel();
		painelLogin.setBounds(0, 0, 266, 195);
		setContentPane(painelLogin);
		painelLogin.setLayout(null);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(68, 41, 46, 14);
		lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(68, 79, 46, 14);
		
		txtNome = new JTextField();
		txtNome.setBounds(120, 38, 86, 20);
		txtNome.setColumns(10);
		txtCodigo = new JTextField();
		txtCodigo.setBounds(120, 76, 86, 20);
		txtCodigo.setColumns(10);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(167, 161, 89, 23);
		
		painelLogin.add(lblNome);
		painelLogin.add(lblCodigo);
		painelLogin.add(txtNome);
		painelLogin.add(txtCodigo);
		painelLogin.add(btnEntrar);
	}
}
