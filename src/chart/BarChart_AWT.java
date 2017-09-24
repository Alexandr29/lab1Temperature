package chart;

import data.StockData;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class BarChart_AWT extends JPanel {

    public void createChart(String chartTitle, StockData stockData, int year){
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Months",
                "Temperature",
                createDataSet(stockData,year),
                PlotOrientation.VERTICAL,
                true, true, false);
        final CategoryPlot plot = barChart.getCategoryPlot();
        try {
            plot.setBackgroundImage(ImageIO.read(new java.io.File("img/more-i-susha.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.repaint();
        chartPanel.setPreferredSize(new java.awt.Dimension( 1000 ,800  ) );
        add( chartPanel);
        setVisible(true);

        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(0,135,205));
        renderer.setSeriesPaint(1, new Color(10,175,240));
        renderer.setSeriesPaint(2, new Color(0,150,110));
        renderer.setSeriesPaint(3, new Color(130,190,75));
        renderer.setSeriesPaint(4, new Color(190,200,50));
        renderer.setSeriesPaint(5, new Color(240,200,40));
        renderer.setSeriesPaint(6, new Color(240,130,50));
        renderer.setSeriesPaint(7, new Color(235,80,50));
        renderer.setSeriesPaint(8, new Color(235,60,100));
        renderer.setSeriesPaint(9, new Color(195,65,140));
        renderer.setSeriesPaint(10, new Color(114,70,150));
        renderer.setSeriesPaint(11, new Color(40,95,170));

    }

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