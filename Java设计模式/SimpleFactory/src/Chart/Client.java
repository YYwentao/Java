package Chart;

public class Client {
	public static void main(String[] args) {
		Chart hcf = new HistogramChartFactory().getChart();
		Chart gcf = new GraphChartFactory().getChart();
		hcf.display();
		gcf.display();
	}
}
