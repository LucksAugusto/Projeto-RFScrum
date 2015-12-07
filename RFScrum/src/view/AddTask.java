package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class AddTask extends JFrame{

	private static final long serialVersionUID = 1L;

	private JPanel painelAddTask;
	private JLabel lblNome;
	private JLabel lblDescricao;
	private JLabel lblPontos;
	private JTextField txtNome;
	private JTextArea txtDesc;
	private JScrollPane scrollDesc;

	private JSpinner spinPontos;

	private JButton btnAdicionar;
	
	public AddTask() {
		setResizable(false);
		setTitle("Adiciionar Tarefa - RFScrum");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 341, 226);
		painelAddTask = new JPanel();
		painelAddTask.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelAddTask);
		painelAddTask.setLayout(null);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(58, 26, 46, 14);
		lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(58, 53, 84, 14);
		lblPontos = new JLabel("Pontos:");
		lblPontos.setBounds(58, 119, 46, 14);
		
		txtNome = new JTextField();
		txtNome.setBounds(119, 23, 149, 20);
		txtNome.setColumns(10);
		
		scrollDesc = new JScrollPane();
		scrollDesc.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollDesc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollDesc.setBounds(120, 48, 148, 59);
		painelAddTask.add(scrollDesc);
		txtDesc = new JTextArea();
		scrollDesc.setViewportView(txtDesc);
		txtDesc.setLineWrap(true);
		
		spinPontos = new JSpinner();
		spinPontos.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		spinPontos.setBounds(119, 116, 65, 20);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(109, 164, 89, 23);
		
		painelAddTask.add(lblNome);
		painelAddTask.add(lblDescricao);
		painelAddTask.add(lblPontos);
		painelAddTask.add(txtNome);
		painelAddTask.add(spinPontos);
		painelAddTask.add(btnAdicionar);
	}
}
