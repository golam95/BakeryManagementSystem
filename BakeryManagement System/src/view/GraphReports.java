package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import Controller.Databaseconnect;

public class GraphReports extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JDesktopPane desktop;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	Databaseconnect connect = new Databaseconnect();
	Connection conn;
	private JButton btn_exit = new JButton("Exit");
	private JButton btn_viewbakerycost = new JButton("View Bakery Cost With Graph");
	private JButton btn_ordercost = new JButton("View Order Cost With Graph");
	private JButton btn_back = new JButton("Back");

	//

	private JButton btn_barchart = new JButton("Bar Chart");
	private JButton btn_areachart = new JButton("Area Chart");
	private JButton btn_linechart = new JButton("Line Chart");
	private JButton btn_watefallchar = new JButton("Waterfall Chart");

	//
	JPanel pan_search = new JPanel();
	private JButton btn_barchart1 = new JButton("Bar Chart");
	private JButton btn_areachart1 = new JButton("Area Chart");
	private JButton btn_linechart1 = new JButton("Line Chart");
	private JButton btn_watefallchar1 = new JButton("Waterfall Chart");

	//

	///
	public GraphReports() {
		super("YearChart Reports");
		try {
			this.setSize(700, 300);
			this.setLocation(screenheith / 2, screedwidth / 7);
			this.setLayout(null);
			this.setResizable(false);
			JPanel pan_left = new JPanel();
			pan_left.setBounds(30, 30, 620, 200);
			pan_left.setBackground(Color.WHITE);
			pan_left.setLayout(null);
			btn_back.setBounds(10, 10, 80, 25);
			btn_viewbakerycost.setBounds(150, 20, 250, 25);
			btn_ordercost.setBounds(150, 60, 250, 25);

			btn_ordercost.addActionListener(this);
			btn_viewbakerycost.addActionListener(this);
			btn_back.addActionListener(this);

			btn_barchart.setBounds(230, 10, 120, 25);
			btn_areachart.setBounds(230, 50, 120, 25);
			btn_linechart.setBounds(230, 90, 120, 25);
			btn_watefallchar.setBounds(230, 130, 120, 25);

			btn_barchart1.setBounds(230, 10, 120, 25);
			btn_areachart1.setBounds(230, 50, 120, 25);
			btn_linechart1.setBounds(230, 90, 120, 25);
			btn_watefallchar1.setBounds(230, 130, 120, 25);

			pan_search.add(btn_barchart);
			pan_search.add(btn_areachart);
			pan_search.add(btn_linechart);
			pan_search.add(btn_watefallchar);
			pan_search.add(btn_barchart1);
			pan_search.add(btn_areachart1);
			pan_search.add(btn_linechart1);
			pan_search.add(btn_watefallchar1);

			Action action = new Action();
			btn_barchart.addActionListener(action);
			btn_areachart.addActionListener(action);
			btn_linechart.addActionListener(action);
			btn_watefallchar.addActionListener(action);

			btn_barchart1.addActionListener(action);
			btn_areachart1.addActionListener(action);
			btn_linechart1.addActionListener(action);
			btn_watefallchar1.addActionListener(action);

			btn_viewbakerycost.setBackground(Color.ORANGE);
			btn_ordercost.setBackground(Color.ORANGE);
			btn_ordercost.setForeground(Color.black);
			btn_viewbakerycost.setForeground(Color.black);
			btn_exit.addActionListener(this);

			pan_search.setLayout(null);
			pan_search.setBounds(20, 20, 580, 160);
			pan_search.setBackground(Color.decode("#FFE4B5"));
			btn_back.setVisible(false);
			btn_exit.setBounds(210, 120, 100, 25);
			pan_search.add(btn_back);
			pan_search.add(btn_exit);
			pan_search.add(btn_viewbakerycost);
			pan_search.add(btn_ordercost);
			pan_left.add(pan_search);

			btn_barchart.setVisible(false);
			btn_areachart.setVisible(false);
			btn_linechart.setVisible(false);
			btn_watefallchar.setVisible(false);

			btn_barchart1.setVisible(false);
			btn_areachart1.setVisible(false);
			btn_linechart1.setVisible(false);
			btn_watefallchar1.setVisible(false);

			btn_barchart.setBackground(Color.GRAY);
			btn_areachart.setBackground(Color.GRAY);
			btn_linechart.setBackground(Color.GRAY);
			btn_watefallchar.setBackground(Color.GRAY);

			btn_barchart.setForeground(Color.WHITE);
			btn_areachart.setForeground(Color.WHITE);
			btn_linechart.setForeground(Color.WHITE);
			btn_watefallchar.setForeground(Color.WHITE);

			btn_barchart1.setBackground(Color.GRAY);
			btn_areachart1.setBackground(Color.GRAY);
			btn_linechart1.setBackground(Color.GRAY);
			btn_watefallchar1.setBackground(Color.GRAY);

			btn_barchart1.setForeground(Color.WHITE);
			btn_areachart1.setForeground(Color.WHITE);
			btn_linechart1.setForeground(Color.WHITE);
			btn_watefallchar1.setForeground(Color.WHITE);

			this.add(pan_left);
			this.getContentPane().setBackground(Color.decode("#875A3C"));
			this.setVisible(true);
		} catch (Exception ex) {

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(btn_exit)) {
			this.setVisible(false);
			dispose();

		} else if (source.equals(btn_ordercost)) {
			total_cost();

		} else if (source.equals(btn_viewbakerycost)) {
			bakerycost();
		} else if (source.equals(btn_back)) {
			back();

		}

	}

	public void bakerycost() {
		btn_back.setVisible(true);

		btn_ordercost.setVisible(false);
		btn_viewbakerycost.setVisible(false);
		btn_exit.setVisible(false);

		btn_barchart.setVisible(true);
		btn_areachart.setVisible(true);
		btn_linechart.setVisible(true);
		btn_watefallchar.setVisible(true);

		btn_barchart1.setVisible(false);
		btn_areachart1.setVisible(false);
		btn_linechart1.setVisible(false);
		btn_watefallchar1.setVisible(false);

	}

	public void total_cost() {

		btn_barchart1.setVisible(true);
		btn_areachart1.setVisible(true);
		btn_linechart1.setVisible(true);
		btn_watefallchar1.setVisible(true);

		btn_back.setVisible(true);
		//
		btn_ordercost.setVisible(false);
		btn_viewbakerycost.setVisible(false);

		btn_exit.setVisible(false);

		//
		btn_barchart.setVisible(false);
		btn_areachart.setVisible(false);
		btn_linechart.setVisible(false);
		btn_watefallchar.setVisible(false);

	}

	public void back() {

		btn_back.setVisible(false);
		btn_barchart.setVisible(false);
		btn_areachart.setVisible(false);
		btn_linechart.setVisible(false);
		btn_watefallchar.setVisible(false);

		btn_barchart1.setVisible(false);
		btn_areachart1.setVisible(false);
		btn_linechart1.setVisible(false);
		btn_watefallchar1.setVisible(false);

		btn_ordercost.setVisible(true);
		btn_viewbakerycost.setVisible(true);
		btn_exit.setVisible(true);

	}

	class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource();
			if (source.equals(btn_barchart)) {
				try {
					conn = connect.setConnection(conn);
					String query = "Select yearname,total_amountcost from yearly_report";
					JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn, query);
					JFreeChart chartsa = ChartFactory.createBarChart("Bakery Cost Peryear", "Year", "Total Cost",
							dataset, PlotOrientation.VERTICAL, false, true, true);

					chartsa.setBackgroundPaint(Color.decode("#FFE4B5"));
					CategoryPlot p = chartsa.getCategoryPlot();
					p.setRangeGridlinePaint(Color.GREEN);

					BarRenderer renderer = null;
					CategoryPlot plot = chartsa.getCategoryPlot();
					CategoryAxis xAxis = (CategoryAxis) plot.getDomainAxis();
					xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
					renderer = new BarRenderer();
					ChartFrame frame = new ChartFrame("Query", chartsa);
					frame.setVisible(true);
					frame.setLocation(screenheith / 4, screedwidth / 16);
					frame.setSize(1000, 650);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}

			} else if (source.equals(btn_areachart)) {

				try {
					conn = connect.setConnection(conn);
					String query = "Select yearname,total_amountcost from yearly_report";
					JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn, query);
					JFreeChart chartsa = ChartFactory.createAreaChart("Bakery Cost Peryear", "Year", "Total Cost",
							dataset, PlotOrientation.VERTICAL, false, true, true);

					chartsa.setBackgroundPaint(Color.decode("#FFE4B5"));
					CategoryPlot p = chartsa.getCategoryPlot();
					p.setRangeGridlinePaint(Color.GREEN);

					BarRenderer renderer = null;
					CategoryPlot plot = chartsa.getCategoryPlot();
					CategoryAxis xAxis = (CategoryAxis) plot.getDomainAxis();
					xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
					renderer = new BarRenderer();
					ChartFrame frame = new ChartFrame("Query", chartsa);
					frame.setVisible(true);
					frame.setLocation(screenheith / 4, screedwidth / 16);
					frame.setSize(1000, 650);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}

			} else if (source.equals(btn_linechart)) {
				try {
					conn = connect.setConnection(conn);
					String query = "Select yearname,total_amountcost from yearly_report";
					JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn, query);
					JFreeChart chartsa = ChartFactory.createLineChart("Bakery Cost Peryear", "Year", "Total Cost",
							dataset, PlotOrientation.VERTICAL, false, true, true);
					chartsa.setBackgroundPaint(Color.decode("#FFE4B5"));
					CategoryPlot p = chartsa.getCategoryPlot();
					p.setRangeGridlinePaint(Color.GREEN);

					BarRenderer renderer = null;
					CategoryPlot plot = chartsa.getCategoryPlot();
					CategoryAxis xAxis = (CategoryAxis) plot.getDomainAxis();
					xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
					renderer = new BarRenderer();
					ChartFrame frame = new ChartFrame("Query", chartsa);
					frame.setVisible(true);
					frame.setLocation(screenheith / 4, screedwidth / 16);
					frame.setSize(1000, 650);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}

			} else if (source.equals(btn_watefallchar)) {
				try {
					conn = connect.setConnection(conn);
					String query = "Select yearname,total_amountcost from yearly_report";
					JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn, query);
					JFreeChart chartsa = ChartFactory.createWaterfallChart("Bakery Cost Peryear", "Year", "Total Cost",
							dataset, PlotOrientation.VERTICAL, false, true, true);
					chartsa.setBackgroundPaint(Color.decode("#FFE4B5"));
					CategoryPlot p = chartsa.getCategoryPlot();
					p.setRangeGridlinePaint(Color.GREEN);

					BarRenderer renderer = null;
					CategoryPlot plot = chartsa.getCategoryPlot();
					CategoryAxis xAxis = (CategoryAxis) plot.getDomainAxis();
					xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
					renderer = new BarRenderer();
					ChartFrame frame = new ChartFrame("Query", chartsa);
					frame.setVisible(true);
					frame.setLocation(screenheith / 4, screedwidth / 16);
					frame.setSize(1000, 650);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}

			} else if (source.equals(btn_barchart1)) {
				try {
					conn = connect.setConnection(conn);
					String query = "Select yearname,total_amountorder from yearly_report";
					JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn, query);
					JFreeChart chartsa = ChartFactory.createBarChart3D("Bakery Cost Peryear", "Year", "Total Cost",
							dataset, PlotOrientation.VERTICAL, false, true, true);

					chartsa.setBackgroundPaint(Color.decode("#FFE4B5"));
					CategoryPlot p = chartsa.getCategoryPlot();
					p.setRangeGridlinePaint(Color.GREEN);

					BarRenderer renderer = null;
					CategoryPlot plot = chartsa.getCategoryPlot();
					CategoryAxis xAxis = (CategoryAxis) plot.getDomainAxis();
					xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
					renderer = new BarRenderer();
					ChartFrame frame = new ChartFrame("Query", chartsa);
					frame.setVisible(true);
					frame.setLocation(screenheith / 4, screedwidth / 16);
					frame.setSize(1000, 650);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}

			} else if (source.equals(btn_areachart1)) {
				try {
					conn = connect.setConnection(conn);
					String query = "Select yearname,total_amountorder from yearly_report";
					JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn, query);
					JFreeChart chartsa = ChartFactory.createStackedAreaChart("Bakery Cost Peryear", "Year",
							"Total Cost", dataset, PlotOrientation.VERTICAL, false, true, true);
					BarRenderer renderer = null;
					CategoryPlot plot = chartsa.getCategoryPlot();
					CategoryAxis xAxis = (CategoryAxis) plot.getDomainAxis();
					xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
					renderer = new BarRenderer();
					ChartFrame frame = new ChartFrame("Query", chartsa);
					frame.setVisible(true);
					frame.setLocation(screenheith / 4, screedwidth / 16);
					frame.setSize(1000, 650);
					chartsa.setBackgroundPaint(Color.decode("#FFE4B5"));
					CategoryPlot p = chartsa.getCategoryPlot();
					p.setRangeGridlinePaint(Color.GREEN);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}

			} else if (source.equals(btn_linechart1)) {
				try {
					conn = connect.setConnection(conn);
					String query = "Select yearname,total_amountorder from yearly_report";
					JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn, query);
					JFreeChart chartsa = ChartFactory.createLineChart3D("Bakery Cost Peryear", "Year", "Total Cost",
							dataset, PlotOrientation.VERTICAL, false, true, true);
					BarRenderer renderer = null;
					CategoryPlot plot = chartsa.getCategoryPlot();
					CategoryAxis xAxis = (CategoryAxis) plot.getDomainAxis();
					xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
					renderer = new BarRenderer();
					ChartFrame frame = new ChartFrame("Query", chartsa);
					frame.setVisible(true);
					frame.setLocation(screenheith / 4, screedwidth / 16);
					frame.setSize(1000, 650);
					chartsa.setBackgroundPaint(Color.decode("#FFE4B5"));
					CategoryPlot p = chartsa.getCategoryPlot();
					p.setRangeGridlinePaint(Color.GREEN);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}

			} else if (source.equals(btn_watefallchar1)) {
				try {
					conn = connect.setConnection(conn);
					String query = "Select yearname,total_amountorder from yearly_report";
					JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn, query);
					JFreeChart chartsa = ChartFactory.createWaterfallChart("Bakery Cost Peryear", "Year", "Total Cost",
							dataset, PlotOrientation.VERTICAL, false, true, true);
					BarRenderer renderer = null;
					CategoryPlot plot = chartsa.getCategoryPlot();
					CategoryAxis xAxis = (CategoryAxis) plot.getDomainAxis();
					xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
					renderer = new BarRenderer();
					ChartFrame frame = new ChartFrame("Query", chartsa);
					frame.setVisible(true);
					frame.setLocation(screenheith / 4, screedwidth / 16);
					frame.setSize(1000, 650);
					chartsa.setBackgroundPaint(Color.decode("#FFE4B5"));
					CategoryPlot p = chartsa.getCategoryPlot();
					p.setRangeGridlinePaint(Color.GREEN);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}

			}

		}

	}

}
