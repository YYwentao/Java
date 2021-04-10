package Chart;

public class HistogramChartFactory implements ChartFactory {
	@Override
	public Chart getChart() {
		return new HistogramChart();
	}
}
