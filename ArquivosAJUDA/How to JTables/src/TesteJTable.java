import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;


public class TesteJTable extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteJTable frame = new TesteJTable();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TesteJTable() {
		
		super("Testes JTable");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 613, 310);
		contentPane.add(scrollPane);
		
		/*
		 * Cria um modelo de tabela com 10 colunas e 10 linhas
		 * JTables são tipicamente colocados dentro de um JScrollPane
		 */
		TableModel dataModel = new AbstractTableModel() {
			
			public Object getValueAt(int row, int col) {
				return new Integer(row+col);
			}
			
			public int getRowCount() {
				return 10;
			}
			
			public int getColumnCount() {
				return 10;
			}
		};
		
		table = new JTable(dataModel);
		scrollPane.setViewportView(table);
		
		/*
		 * Por padrão, o ajuste do rolamento horizontal é desnecessário
		 * 
		 * Para torná-lo automático, segue o código abaixo
		 */
//		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		
		/*
		 * Cria uma ordenação das linhas automaticamente
		 */
		table.setAutoCreateRowSorter(true);
	}
}
