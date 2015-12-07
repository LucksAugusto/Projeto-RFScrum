package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class Reuniao extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel painelReuniao;
	private JPanel painelDados;
	private JTabbedPane paneTables;
	private JTable table;
	private JTable table_1;
	private JLabel lblPrioridade;
	private JLabel lblCategoria;
	private JLabel lblDescricao;
	private JLabel lblEstoria;
	private JTextField txtPrioridade;
	private JTextField txtCategoria;
	private JTextArea txtDescricao;
	private JTextArea txtEstoria;
	private JButton btnAdicionar;
	private JButton btnNovaTarefa;
	private JScrollPane scrollDesc;
	private JScrollPane scrollEst;
	
	public Reuniao() {
		setResizable(false);
		setTitle("Primeira Reunião - RFScrum");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 746, 536);
		painelReuniao = new JPanel();
		painelReuniao.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelReuniao);
		painelReuniao.setLayout(null);
		
		paneTables = new JTabbedPane(JTabbedPane.TOP);
		paneTables.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		paneTables.setBounds(10, 11, 720, 190);
		table = new JTable();
		paneTables.addTab("BackLog", null, table, null);
		table_1 = new JTable();
		paneTables.addTab("Tarefas", null, table_1, null);
		
		painelDados = new JPanel();
		painelDados.setBounds(10, 204, 720, 293);
		painelDados.setLayout(null);
		
		lblPrioridade = new JLabel("Prioridade:");
		lblPrioridade.setBounds(10, 11, 87, 14);
		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(10, 36, 87, 14);
		lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(10, 61, 87, 14);
		lblEstoria = new JLabel("Estória:");
		lblEstoria.setBounds(264, 11, 46, 14);
		
		txtPrioridade = new JTextField();
		txtPrioridade.setBounds(71, 8, 177, 20);
		txtPrioridade.setColumns(10);
		txtCategoria = new JTextField();
		txtCategoria.setBounds(71, 33, 177, 20);
		txtCategoria.setColumns(10);
		
		scrollDesc = new JScrollPane();
		scrollDesc.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollDesc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollDesc.setBounds(71, 61, 177, 142);
		painelDados.add(scrollDesc);
		txtDescricao = new JTextArea();
		scrollDesc.setViewportView(txtDescricao);
		txtDescricao.setLineWrap(true);
		
		scrollEst = new JScrollPane();
		scrollEst.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollEst.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollEst.setBounds(307, 11, 403, 190);
		painelDados.add(scrollEst);
		txtEstoria = new JTextArea();
		scrollEst.setViewportView(txtEstoria);
		txtEstoria.setLineWrap(true);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(599, 259, 111, 23);
		btnNovaTarefa = new JButton("Nova Tarefa");
		btnNovaTarefa.setBounds(599, 225, 111, 23);
		
		painelReuniao.add(paneTables);
		painelReuniao.add(painelDados);
		painelDados.add(lblPrioridade);
		painelDados.add(lblCategoria);
		painelDados.add(lblDescricao);
		painelDados.add(lblEstoria);
		painelDados.add(txtPrioridade);
		painelDados.add(txtCategoria);
		painelDados.add(btnAdicionar);
		painelDados.add(btnNovaTarefa);
	}
	
}
