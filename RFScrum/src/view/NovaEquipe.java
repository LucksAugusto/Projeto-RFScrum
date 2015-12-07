package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControlePO;

public class NovaEquipe extends JFrame implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	
	public static int foco = 0;
	private JPanel painelNovaEquipe;
	private JLabel lblProjeto;
	private JLabel lblCodProjeto;
	private JLabel lblNomeProjeto;
	private JLabel lblProductOwner;
	private JLabel lblEquipe;
	private JTextField txtCodProjeto;
	private JTextField txtNomeProjeto;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnCriar;
	private JComboBox<String> comboProductOwner;
	private JTable table;
	private JSeparator separator;
	private JScrollPane scrollPane;
	
	Reuniao telaReuniao = new Reuniao();
	ProductOwnerCRUD telaPOCRUD = new ProductOwnerCRUD();


	public NovaEquipe() {
		setResizable(false);
		setTitle("Nova Equipe - RFScrum");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 461, 372);
		getContentPane().setLayout(null);
		painelNovaEquipe = new JPanel();
		painelNovaEquipe.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelNovaEquipe);
		painelNovaEquipe.setLayout(null);
				
		lblProjeto = new JLabel("Projeto");
		lblProjeto.setBounds(10, 0, 46, 14);
		lblCodProjeto = new JLabel("Cód. Projeto:");
		lblCodProjeto.setBounds(105, 25, 76, 14);
		lblNomeProjeto = new JLabel("Nome Projeto:");
		lblNomeProjeto.setBounds(105, 56, 85, 14);
		lblProductOwner = new JLabel("Product Owner:");
		lblProductOwner.setBounds(105, 90, 92, 14);
		lblEquipe = new JLabel("Equipe");
		lblEquipe.setBounds(10, 129, 46, 14);
		
		txtCodProjeto = new JTextField();
		txtCodProjeto.setBounds(201, 22, 115, 20);
		txtCodProjeto.setColumns(10);
		txtNomeProjeto = new JTextField();
		txtNomeProjeto.setBounds(201, 53, 115, 20);
		txtNomeProjeto.setColumns(10);
		
		btnAdicionar = new JButton("+");
		btnAdicionar.setBounds(320, 86, 41, 23);
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(10, 297, 95, 23);
		btnCriar = new JButton("Criar");
		btnCriar.setBounds(370, 310, 80, 23);
		
		comboProductOwner = new JComboBox<String>();
		comboProductOwner.setBounds(201, 87, 115, 20);
//		
//		scrollPane = new JScrollPane();
//		scrollPane.setBounds(10, 139, 449, 171);
//		tblProj = new JTable();
//		tblProj.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		scrollPane.setViewportView(tblPO);
//		DefaultTableModel modelo = new DefaultTableModel(
//				new Object[][] {
//					{null, null, null, null, null, null},
//				},
//				new String[] {
//					"ID","Nome","Empresa","CNPJ","Endereço","Data Ingresso"
//				})
//				{					   
//					   private static final long serialVersionUID = 1L;
//					   boolean[] columnEditables = new boolean[] {
//					    false, false, false, false, false, false
//					   };
//					   public boolean isCellEditable(int row, int column) {
//					    return columnEditables[column];
//					   }
//					  };
//		tblPO.setModel(modelo);
//		ControlePO c3po = new ControlePO(tblPO);
//		c3po.tabelaProductOwner();
		
		separator = new JSeparator();
		separator.setBounds(-10, 129, 465, 2);
		
		painelNovaEquipe.add(lblProjeto);
		painelNovaEquipe.add(lblCodProjeto);
		painelNovaEquipe.add(lblNomeProjeto);
		painelNovaEquipe.add(lblProductOwner);
		painelNovaEquipe.add(lblEquipe);
		painelNovaEquipe.add(txtCodProjeto);
		painelNovaEquipe.add(txtNomeProjeto);
		painelNovaEquipe.add(btnAdicionar);
		painelNovaEquipe.add(btnConsultar);
		painelNovaEquipe.add(btnCriar);
		painelNovaEquipe.add(comboProductOwner);
//		painelNovaEquipe.add(table);
		painelNovaEquipe.add(separator);
		
		ControlePO c3po = new ControlePO(comboProductOwner);
		c3po.carregaCombo();
		comboProductOwner.addMouseListener(this);
		btnCriar.addActionListener(this);
		btnAdicionar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		String cmd = a.getActionCommand();
		if(cmd.equals("Criar")) {
			telaReuniao.setVisible(true);
			telaReuniao.setAlwaysOnTop(true);
			telaReuniao.setLocationRelativeTo(null);
			this.dispose();
		} else if(cmd.equals("+")) {
			telaPOCRUD.setVisible(true);
			telaPOCRUD.setAlwaysOnTop(true);
			telaPOCRUD.setLocationRelativeTo(null);
				
		} else {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ControlePO c3po = new ControlePO(comboProductOwner);
		c3po.carregaCombo();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

