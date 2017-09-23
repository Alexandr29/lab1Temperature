package controller;

import chart.BarChart_AWT;
import data.StockData;
import view.TemperatureChart;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;

public class MainFrameController {
    private int counter = 0;
    private BarChart_AWT barChart_awt;
    private StockData stockData;
    private TemperatureChart temperatureChart;
    private JPanel panel1;
    private JFormattedTextField yearTextField1;
    private JButton button1;

    public MainFrameController() {
        temperatureChart = new TemperatureChart();
        stockData = new StockData();
        barChart_awt = new BarChart_AWT();
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
        yearTextField1 = temperatureChart.getSetYearField();
        button1 = temperatureChart.getStartButton();
    }

    public void showFrame() {
        temperatureChart.setVisible(true);
    }
    private void showDialog(){
        JOptionPane.showMessageDialog(panel1,"Введите значение от 1880 до 2016(включительно)","Warning",JOptionPane.ERROR_MESSAGE);
        barChart_awt.repaint();
    }

    private class MyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (counter>0){
                System.out.println(counter);
                barChart_awt.removeAll();
            }

            if (yearTextField1.getText().equals("Введите год")){
                showDialog();
                yearTextField1.setText("1880"); //ДОДУМАТЬ!
            }
            int year = Integer.parseInt(yearTextField1.getText());
            System.out.println(year);

            if ((year >= 1880)& (year <=2016)){
                barChart_awt.createChart(yearTextField1.getText(),stockData,year);
                barChart_awt.repaint();
                barChart_awt.setBorder( new BevelBorder(BevelBorder.RAISED));
                panel1.add(barChart_awt, BorderLayout.CENTER);
                panel1.revalidate();
            }else {
                showDialog();
            }
            counter++;
        }
    }

    private class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (yearTextField1.getText().equals("Введите год")){
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
            if (yearTextField1.getText().equals("Введите год")){
                yearTextField1.setText("");
            }
        }
    }
}
