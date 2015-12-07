package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.Programador;
import persistance.ProgramadorDAO;
import controller.ControleProg;

public class ProgramadorCRUD extends JFrame implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel painelProgCRUD;
	private JLabel lblNome;
	private JLabel lblProjeto;
	private JLabel lblRG;
	private JLabel lblSalario;
	private JLabel lblEndereco;
	private JLabel lblData;
	private JLabel lblData2;
	private JTextField txtNome;
	private JTextField txtProjeto;
	private JTextField txtRG;
	private JTextField txtSalario;
	private JTextField txtEndereco;
	private JTextField txtPesquisa;
	private JButton btnSalvar;
	private JButton btnEditar;
	private JButton btnDeletar;
	private JScrollPane scrollPane;
	private JCheckBox chckbxExpScrum;
	private JTable tblProgramador;
	private JSeparator separator;

	private JLabel lblPesquisar;
	
	@SuppressWarnings("deprecation")
	public ProgramadorCRUD() {
		setResizable(false);
		setTitle("Cadastro de Programadores - RFScrum");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 475, 392);
		getContentPane().setLayout(null);
		painelProgCRUD = new JPanel();
		painelProgCRUD.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelProgCRUD);
		painelProgCRUD.setLayout(null);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		lblProjeto = new JLabel("Projetos:");
		lblProjeto.setBounds(10, 36, 52, 14);
		lblRG = new JLabel("RG:");
		lblRG.setBounds(10, 61, 46, 14);
		lblSalario = new JLabel("Salario:");
		lblSalario.setBounds(253, 11, 46, 14);
		lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(253, 36, 59, 14);
		lblData = new JLabel("Data:");
		lblData.setBounds(253, 61, 46, 14);
		lblData2 = new JLabel("*/*/*");
		lblData2.setBounds(309, 61, 80, 14);
		
		txtNome = new JTextField();
		txtNome.setBounds(65, 8, 166, 20);
		txtNome.setColumns(10);		
		txtProjeto = new JTextField();
		txtProjeto.setText("0");
		txtProjeto.setBounds(65, 33, 166, 20);
		txtProjeto.setColumns(10);		
		txtRG = new JTextField();
		txtRG.setBounds(65, 58, 166, 20);
		txtRG.setColumns(10);
		txtSalario = new JTextField();
		txtSalario.setBounds(312, 8, 153, 20);
		txtSalario.setColumns(10);
		txtEndereco = new JTextField();
		txtEndereco.setBounds(312, 33, 153, 20);
		txtEndereco.setColumns(10);
		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(10, 151, 353, 20);
		txtPesquisa.setColumns(10);
				
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(175, 92, 89, 23);
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(274, 92, 89, 23);
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(373, 92, 89, 23);
		lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setBounds(366, 149, 98, 23);
		
		chckbxExpScrum = new JCheckBox("Experiencia Scrum");
		chckbxExpScrum.setBounds(6, 92, 135, 23);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 182, 449, 171);
		tblProgramador = new JTable();
		tblProgramador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblProgramador);
		DefaultTableModel modelo = new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null},
				},
				new String[] {
					"ID","Nome","RG","Salario","Endereço","Data Contrato", "Experiencia"
				})
				{					   
					   private static final long serialVersionUID = 1L;
					   boolean[] columnEditables = new boolean[] {
					    false, false, false, false, false, false, false
					   };
					   public boolean isCellEditable(int row, int column) {
					    return columnEditables[column];
					   }
					  };
		tblProgramador.setModel(modelo);
		ControleProg cprog = new ControleProg(tblProgramador);
		cprog.tabelaProgramador();
		
		
		separator = new JSeparator();
		separator.setBounds(0, 138, 607, 2);
		
		
		painelProgCRUD.add(lblNome);
		painelProgCRUD.add(lblProjeto);
		painelProgCRUD.add(lblRG);
		painelProgCRUD.add(lblSalario);				
		painelProgCRUD.add(lblEndereco);		
		painelProgCRUD.add(lblData);
		painelProgCRUD.add(lblData2);
		painelProgCRUD.add(txtNome);
		painelProgCRUD.add(txtProjeto);
		painelProgCRUD.add(txtRG);
		painelProgCRUD.add(txtSalario);
		painelProgCRUD.add(txtEndereco);
		painelProgCRUD.add(txtPesquisa);
		painelProgCRUD.add(btnSalvar);		
		painelProgCRUD.add(btnEditar);		
		painelProgCRUD.add(btnDeletar);		
		painelProgCRUD.add(lblPesquisar);
		painelProgCRUD.add(chckbxExpScrum);
		painelProgCRUD.add(scrollPane);
		painelProgCRUD.add(separator);		
		
		lblData2.setText(new java.util.Date().toGMTString()); 
		btnSalvar.addActionListener(this);
		btnDeletar.addActionListener(this);
		btnEditar.addActionListener(this);
		tblProgramador.addMouseListener(this);
		txtPesquisa.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {

			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				filtrarTab(tblProgramador,txtPesquisa);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		Programador pro = new Programador();
		ProgramadorDAO proDAO = null;
		java.util.Date dataUtil = new java.util.Date();
		if("Salvar".equals(cmd)) {
			try {
				proDAO = new ProgramadorDAO();
				pro.setIdProg(proDAO.proximoId());
				pro.setNome(txtNome.getText());
				pro.setRG(txtRG.getText());
				pro.setSalario(Double.valueOf(txtSalario.getText()));
				pro.setEndereco(txtEndereco.getText());
				pro.setDataContrato(new java.sql.Date(dataUtil.getTime()));
				pro.setExperiencia(chckbxExpScrum.isSelected());
				proDAO.inserir(pro);
				ControleProg cprog = new ControleProg(tblProgramador);
				cprog.tabelaProgramador();
				txtNome.setText("");
				txtRG.setText("");
				txtSalario.setText("");
				txtEndereco.setText("");
				txtProjeto.setText("0");
				chckbxExpScrum.setSelected(false);
			} catch (ClassNotFoundException | SQLException e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		} else if("Editar".equals(cmd)){
			int linha = tblProgramador.getSelectedRow();
			try {
				proDAO = new ProgramadorDAO();
				pro.setIdProg(Integer.valueOf(tblProgramador.getValueAt(linha, 0).toString()));
				pro.setNome(txtNome.getText());
				pro.setRG(txtRG.getText());
				pro.setSalario(Double.valueOf(txtSalario.getText()));
				pro.setEndereco(txtEndereco.getText());
				pro.setExperiencia(chckbxExpScrum.isSelected());
				proDAO.atualizar(pro);
				ControleProg cprog = new ControleProg(tblProgramador);
				cprog.tabelaProgramador();
				txtNome.setText("");
				txtRG.setText("");
				txtSalario.setText("");
				txtEndereco.setText("");
				chckbxExpScrum.setSelected(false);
			} catch (ClassNotFoundException | SQLException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}		   
		} else if("Deletar".equals(cmd)){
			int linha = tblProgramador.getSelectedRow();
			try {
				proDAO = new ProgramadorDAO();
				pro.setIdProg(Integer.valueOf(tblProgramador.getValueAt(linha, 0).toString()));
				proDAO.excluir(pro);
				ControleProg cprog = new ControleProg(tblProgramador);
				cprog.tabelaProgramador();
			} catch (ClassNotFoundException | SQLException e2) {
				e2.printStackTrace();
			}

		} else {
			
		}
	}
	
	public void filtrarTab(JTable nometbl, JTextField pesquisa){
		DefaultTableModel model = (DefaultTableModel) nometbl.getModel();
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);  
		nometbl.setRowSorter(sorter);
		String text = pesquisa.getText();  
		if (text.length() == 0) {  
		          sorter.setRowFilter(null);  
		} else {  
		          sorter.setRowFilter(RowFilter.regexFilter(text));
		          nometbl.setRowSorter(sorter);
		}
		}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount() == 1){
		int linha = tblProgramador.getSelectedRow();
		if( linha == -1) {
					
				} else {
				txtNome.setText(tblProgramador.getValueAt(linha, 1).toString());
				txtRG.setText(tblProgramador.getValueAt(linha, 2).toString());
				txtSalario.setText(tblProgramador.getValueAt(linha, 3).toString());
				txtEndereco.setText(tblProgramador.getValueAt(linha, 4).toString());
				chckbxExpScrum.setSelected((boolean) tblProgramador.getValueAt(linha, 6));
				}
		}	
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
	}  
		
		
	
}
