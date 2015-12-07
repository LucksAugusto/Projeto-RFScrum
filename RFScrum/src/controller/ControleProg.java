package controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Programador;
import persistance.ProgramadorDAO;

public class ControleProg {
private JTable tblProgramador;
	
	public ControleProg(JTable tblProgramador) {
		this.tblProgramador = tblProgramador;
	}
	
	
	public void tabelaProgramador() {
		if(tblProgramador != null){
			DefaultTableModel modelo = (DefaultTableModel) tblProgramador.getModel();
			if (modelo.getRowCount() > 0){
				modelo.setRowCount(0);
			}
			ProgramadorDAO pDAO;
			try {
				pDAO = new ProgramadorDAO();
				List<Programador> listaProgramador = pDAO.consultar();
				for (Programador c : listaProgramador){
					Object[] linha = new Object[7];
					linha[0] = c.getIdProg();
					linha[1] = c.getNome();
					linha[2] = c.getRG();
					linha[3] = c.getSalario();
					linha[4] = c.getEndereco();
					linha[5] = c.getDataContrato();
					linha[6] = c.isExperiencia();
					modelo.addRow(linha);
				}
			} catch (ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}
}
