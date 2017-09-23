package chart;

import data.StockData;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;


public class BarChart_AWT extends JPanel {

    public BarChart_AWT(String chartTitle, StockData stockData, int year) {

        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Months",
                "Temperature",
                createDataSet(stockData,year),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.repaint();
        chartPanel.setPreferredSize(new java.awt.Dimension( 800 ,800  ) );
        add( chartPanel);
        setVisible(true);
    }

    //private double tmp;

    private CategoryDataset createDataSet(StockData stockData, int year) {
        //String[] arr2 = new String[12];
        double arr1[] = new double[12];
        final String speed = "Months";
        String[] arr2 = new String[]{"Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};

        final DefaultCategoryDataset dataSet =
                new DefaultCategoryDataset( );
                    arr1[0] = stockData.getRecordNumber(year-1880).getJan();
                    arr1[1] = stockData.getRecordNumber(year-1880).getFeb();
                    arr1[2] = stockData.getRecordNumber(year-1880).getMar();
                    arr1[3] = stockData.getRecordNumber(year-1880).getApr();
                    arr1[4] = stockData.getRecordNumber(year-1880).getMay();
                    arr1[5] = stockData.getRecordNumber(year-1880).getJun();
                    arr1[6] = stockData.getRecordNumber(year-1880).getJul();
                    arr1[7] = stockData.getRecordNumber(year-1880).getAug();
                    arr1[8] = stockData.getRecordNumber(year-1880).getSep();
                    arr1[9] = stockData.getRecordNumber(year-1880).getOct();
                    arr1[10] = stockData.getRecordNumber(year-1880).getNov();
                    arr1[11] = stockData.getRecordNumber(year-1880).getDec();

                for (int i = 0; i < 12; i++) {
                    dataSet.addValue(arr1[i],arr2[i], speed);
                }
        return dataSet;
    }

}