package controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ProductOwner;
import persistance.ProductOwnerDAO;

public class ControlePO {
	private JTable tblProductOwner;
	private JComboBox<String> combo = new JComboBox<String>();
	public ControlePO(JTable tblProductOwner) {
		this.tblProductOwner = tblProductOwner;
	}
	
	public ControlePO(JComboBox<String> comboProductOwner) {
		this.combo = comboProductOwner;
	}
	
	public void carregaCombo(){
		try{
			ProductOwnerDAO cDAO = new ProductOwnerDAO();
			List<ProductOwner> lista = cDAO.consultar();
			if(combo.getItemCount() > 0) {
				combo.removeAllItems();
			}
			if(combo != null){
				for (ProductOwner productOwner : lista) {
					combo.addItem(productOwner.getNome());
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void tabelaProductOwner() {
		if(tblProductOwner != null){
			DefaultTableModel modelo = (DefaultTableModel) tblProductOwner.getModel();
			if (modelo.getRowCount() > 0){
				modelo.setRowCount(0);
			}
			ProductOwnerDAO cDAO;
			try {
				cDAO = new ProductOwnerDAO();
				List<ProductOwner> listaProdutOwner = cDAO.consultar();
				for (ProductOwner c : listaProdutOwner){
					Object[] linha = new Object[6];
					linha[0] = c.getIdPO();
					linha[1] = c.getNome();
					linha[2] = c.getEmpresa();
					linha[3] = c.getCNPJ();
					linha[4] = c.getEndereco();
					linha[5] = c.getDataIng();
					modelo.addRow(linha);
				}
			} catch (ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}

}
