package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JButton;
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

import controller.ControlePO;
import model.ProductOwner;
import persistance.ProductOwnerDAO;

public class ProductOwnerCRUD extends JFrame implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel painelPOCRUD;
	private JLabel lblNome;
	private JLabel lblCNPJ;
	private JLabel lblEmpresa;
	private JLabel lblEndereco;
	private JLabel lblPesquisar;
	private JTextField txtNome;
	private JTextField txtCNPJ;
	private JTextField txtEmpresa;
	private JTextField txtEndereco;
	private JTextField txtPesquisa;
	private JButton btnSalvar;
	private JButton btnEditar;
	private JButton btnDeletar;
	private JTable tblPO;
	private JScrollPane scrollPane;
	private JSeparator separator;

	
	public ProductOwnerCRUD() {
		setResizable(false);
		setTitle("Product Owners - RFScrum");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 475, 359);
		getContentPane().setLayout(null);
		painelPOCRUD = new JPanel();
		painelPOCRUD.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPOCRUD);
		painelPOCRUD.setLayout(null);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		lblCNPJ = new JLabel("CNPJ:");
		lblCNPJ.setBounds(10, 36, 46, 14);
		lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(253, 11, 59, 14);
		lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(253, 36, 59, 14);
		lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setBounds(369, 107, 98, 23);
		
		txtNome = new JTextField();
		txtNome.setBounds(58, 8, 166, 20);
		txtNome.setColumns(10);
		txtCNPJ = new JTextField();
		txtCNPJ.setBounds(58, 33, 166, 20);
		txtCNPJ.setColumns(10);
		txtEmpresa = new JTextField();
		txtEmpresa.setBounds(312, 8, 153, 20);
		txtEmpresa.setColumns(10);
		txtEndereco = new JTextField();
		txtEndereco.setBounds(312, 33, 153, 20);
		txtEndereco.setColumns(10);
		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(10, 108, 353, 20);
		txtPesquisa.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 61, 89, 23);
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(109, 61, 89, 23);
		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(208, 61, 89, 23);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 449, 171);
		tblPO = new JTable();
		tblPO.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tblPO);
		DefaultTableModel modelo = new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
				},
				new String[] {
					"ID","Nome","Empresa","CNPJ","Endereço","Data Ingresso"
				})
				{					   
					   private static final long serialVersionUID = 1L;
					   boolean[] columnEditables = new boolean[] {
					    false, false, false, false, false, false
					   };
					   public boolean isCellEditable(int row, int column) {
					    return columnEditables[column];
					   }
					  };
		tblPO.setModel(modelo);
		ControlePO c3po = new ControlePO(tblPO);
		c3po.tabelaProductOwner();
		
		separator = new JSeparator();
		separator.setBounds(0, 95, 607, 2);
		
		painelPOCRUD.add(lblNome);
		painelPOCRUD.add(lblCNPJ);
		painelPOCRUD.add(lblEmpresa);
		painelPOCRUD.add(lblEndereco);
		painelPOCRUD.add(lblPesquisar);
		painelPOCRUD.add(txtNome);	
		painelPOCRUD.add(txtCNPJ);
		painelPOCRUD.add(txtEmpresa);
		painelPOCRUD.add(txtEndereco);
		painelPOCRUD.add(txtPesquisa);
		painelPOCRUD.add(btnSalvar);
		painelPOCRUD.add(btnEditar);
		painelPOCRUD.add(btnDeletar);
		painelPOCRUD.add(scrollPane);
		painelPOCRUD.add(separator);

		btnSalvar.addActionListener(this);
		btnDeletar.addActionListener(this);
		btnEditar.addActionListener(this);
		tblPO.addMouseListener(this);
		txtPesquisa.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {

			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				filtrarTab(tblPO,txtPesquisa);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		ProductOwner PO = new ProductOwner();
		ProductOwnerDAO PODAO = null;
		java.util.Date dataUtil = new java.util.Date();
		if("Salvar".equals(cmd)) {
			try {
				PODAO = new ProductOwnerDAO();
				PO.setIdPO(PODAO.proximoId());
				PO.setNome(txtNome.getText());
				PO.setEmpresa(txtEmpresa.getText());
				PO.setCNPJ(txtCNPJ.getText());
				PO.setEndereco(txtEndereco.getText());
				PO.setDataIng(new java.sql.Date(dataUtil.getTime()));
				PODAO.inserir(PO);
				ControlePO c3po = new ControlePO(tblPO);
				c3po.tabelaProductOwner();
				txtNome.setText("");
				txtEmpresa.setText("");
				txtCNPJ.setText("");
				txtEndereco.setText("");
			} catch (ClassNotFoundException | SQLException e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		} else if("Editar".equals(cmd)){
			int linha = tblPO.getSelectedRow();
			   try {
				   PODAO = new ProductOwnerDAO();
				   PO.setIdPO(Integer.valueOf(tblPO.getValueAt(linha, 0).toString()));
				   PO.setNome(txtNome.getText());
				   PO.setEmpresa(txtEmpresa.getText());
				   PO.setCNPJ(txtCNPJ.getText());
				   PO.setEndereco(txtEndereco.getText());
				   PODAO.atualizar(PO);
				   ControlePO c3po = new ControlePO(tblPO);
				   c3po.tabelaProductOwner();
				   txtNome.setText("");
				   txtEmpresa.setText("");
				   txtCNPJ.setText("");
				   txtEndereco.setText("");
			} catch (ClassNotFoundException | SQLException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}		   
		} else if("Deletar".equals(cmd)){
			int linha = tblPO.getSelectedRow();
			   try {
				PODAO = new ProductOwnerDAO();
				PO.setIdPO(Integer.valueOf(tblPO.getValueAt(linha, 0).toString()));
				PODAO.excluir(PO);
				ControlePO c3po = new ControlePO(tblPO);
			  	c3po.tabelaProductOwner();
			} catch (ClassNotFoundException | SQLException e2) {
				e2.printStackTrace();
			}
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
		int linha = tblPO.getSelectedRow();
		if( linha == -1) {
					
				} else {
				txtNome.setText(tblPO.getValueAt(linha, 1).toString());
				txtEmpresa.setText(tblPO.getValueAt(linha, 2).toString());
				txtCNPJ.setText(tblPO.getValueAt(linha, 3).toString());
				txtEndereco.setText(tblPO.getValueAt(linha, 4).toString());
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
