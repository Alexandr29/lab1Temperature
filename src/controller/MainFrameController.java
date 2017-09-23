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
    private JLabel matOzhidanie;
    private JLabel dizpersiya;

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
        matOzhidanie = temperatureChart.getMatOzhidanie();
        dizpersiya= temperatureChart.getDizpersiya();
    }

    public void showFrame() {
        temperatureChart.setTitle("Temperature Chart");
        temperatureChart.setVisible(true);
    }

    public double getMatOzhidanie(int year){
        double sum = 0;
        double[] arr1 = new double[12];
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
            sum = sum+arr1[i];
        }
        sum=sum/12;
        return sum;
    }
    public void enterOrButton(){
        if (counter>0){
            barChart_awt.removeAll();
        }
        if(yearTextField1.getText().equals("")){
            showDialog();
        }
        if (yearTextField1.getText().equals("Введите год")){
            showDialog();
            //yearTextField1.setText("1880"); //ДОДУМАТЬ!
        }
        int year = Integer.parseInt(yearTextField1.getText());

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
        if ((year >= 1880)& (year <=2016)) {
            matOzhidanie.setText(String.valueOf(getMatOzhidanie(year)));
            dizpersiya.setText(String.valueOf(getDispersiya(year)));
        }
    }

    public double getDispersiya(int year){
        double sum = 0;
        double[] arr1 = new double[12];
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
            arr1[i] = Math.pow(arr1[i],2);
            arr1[i]=arr1[i]/12;
            sum = sum+arr1[i];
        }
        sum = (sum - Math.pow(getMatOzhidanie(year),2));
        return sum;
    }

    private void showDialog(){
        yearTextField1.setText("1880");
        JOptionPane.showMessageDialog(panel1,"Введите значение от 1880 до 2016(включительно)","Warning",JOptionPane.ERROR_MESSAGE);
        barChart_awt.repaint();
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
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                enterOrButton();
            }
        }

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

    private class MyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            enterOrButton();
    }
}}
