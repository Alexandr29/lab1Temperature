package controller;

import chart.BarChart_AWT;
import data.StockData;
import view.TemperatureChart;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;

public class MainFrameController {
    private BarChart_AWT barChart_awt;
    private StockData stockData;
    private TemperatureChart temperatureChart;
    private JPanel panel1;
    private JPanel topPanel;
    private JFormattedTextField yearTextField1;
    private JButton button1;

    public MainFrameController() {
        temperatureChart = new TemperatureChart();
        stockData = new StockData();
        stockData.loadDataFrmFile("data.csv");
        initComponents();
        initListeners();
    }

    private void initListeners() {
        button1.addActionListener(new MyButtonListener());
        yearTextField1.addKeyListener(new MyKeyAdapter());
        yearTextField1.addMouseListener(new MyMouseAdapter());


    }

    private void initComponents() {
        panel1 = temperatureChart.getPanel1();
        topPanel = temperatureChart.getTopPanel();
        yearTextField1 = temperatureChart.getSetYearField();
        button1 = temperatureChart.getStartButton();


    }

    public void showFrame() {
        temperatureChart.setVisible(true);
    }

    private class MyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int year = Integer.parseInt(yearTextField1.getText());
            System.out.println(year);

            if ((year >= 1880)& (year <=2016)){
                barChart_awt = new BarChart_AWT(yearTextField1.getText(),stockData, year);
                barChart_awt.setBorder( new BevelBorder(BevelBorder.RAISED));
                panel1.add(barChart_awt, BorderLayout.CENTER);
                panel1.revalidate();

                System.out.println(stockData.toString());
                System.out.println(stockData.getNumberOfRecords());
            }else {
                JOptionPane.showMessageDialog(panel1,"Введите значение от 1880 до 2016(включительно)","Warning",JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (yearTextField1.getText().equals("set Year")){
                yearTextField1.setText("");
            }
        }
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {

            char input = e.getKeyChar();
            if (input<'0' || input > '9'){
                e.consume();
            }
            if (yearTextField1.getText().equals("set Year")){
                yearTextField1.setText("");
            }
        }
    }
}
