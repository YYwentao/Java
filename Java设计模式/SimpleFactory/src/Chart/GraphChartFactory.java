package Chart;

public class GraphChartFactory implements ChartFactory {
	@Override
	public Chart getChart() {
		return new GraphChart();
	}
}
