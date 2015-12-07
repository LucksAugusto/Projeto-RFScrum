import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GraficoDePizza extends ApplicationFrame{

	private static final long serialVersionUID = 1L;

	/*
	 * Pensar em como fazer com List<> ?
	 * 
	 * Posso criar uma Lista com alguns dados do BD por exemplo de uma consulta,
	 * e após isso, dar um get em cada um deles para dividir o gráfico com o setvalue
	 * 
	 * Link do exemplo: http://www.tutorialspoint.com/jfreechart/jfreechart_database_interface.htm
	 */
	
	public GraficoDePizza(String title) {
		super(title);
		setContentPane(PainelGrafico());
	}
	
	private static PieDataset criarDataSet(){
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("William", new Double(1));
		dataset.setValue("Raquel", new Double(100));
		dataset.setValue("Dulce", new Double(2000));
		return dataset;
	}

	private static JFreeChart criarGrafico( PieDataset dataset ){
		JFreeChart grafico = ChartFactory.createPieChart(
				"Dias Trabalhados", 
				dataset,
				true,
				true,
				false);
		return grafico;
	}
	
	public static JPanel PainelGrafico(){
		JFreeChart grafico = criarGrafico(criarDataSet());
		return new ChartPanel(grafico);
	}
	
	public static void main(String[] args) {
		GraficoDePizza g = new GraficoDePizza( "Dias Trabalhados" );
		g.setSize( 560, 367 );
		RefineryUtilities.centerFrameOnScreen(g);
		g.setVisible(true);
		
		/*
		 * Criar a imagem do gráfico:
		 * 
		 *  int width = 640;
            int height = 480; 
            File pieChart = new File( "PieChart.jpeg" ); 
            ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
		 */
	}
	
}
