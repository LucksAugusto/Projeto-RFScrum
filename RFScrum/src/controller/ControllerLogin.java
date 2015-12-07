package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ControllerLogin implements ActionListener{

	private JTextField txtCod;
	private JTextField txtNome;
	private JButton btnLog;
	
//	private TelaProgramador = new Programador();
//	private TelaScrumMaster = new ScrumMaster();

	public ControllerLogin(JTextField txtCod, JTextField txtNome, JButton btnLog){
		this.txtCod = txtCod;
		this.txtNome = txtNome;
		this.btnLog = btnLog;
	}
	
	public boolean logar() {
		//txt field1 - conferir banco
		//txtfield2 - conferir banco
		//se os dois primeiros forem validos verificar o scrum master e abrir a tela baseando se nele
		//conferir scrummaster
		return false;
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		boolean valida = logar();
		if(valida) {
//		telaScrumMaster.setVisible(true);
//		telaScrumMaster.setAlwaysOnTop(true);
//		telaScrumMaster.setLocationRelativeTo(null);
//		this.setVisible(false);
		} else if("Nova Equipe".equals(cmd)) {
//			telaProgramador.setVisible(true);
//			telaProgramador.setAlwaysOnTop(true);
//			telaProgramador.setLocationRelativeTo(null);
		}
	}
}
