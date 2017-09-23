package view;

import javax.swing.*;

public class TemperatureChart extends JFrame{
    private JPanel panel1;
    private JPanel topPanel;
    private JFormattedTextField setYearField;
    private JButton startButton;
    private JLabel matOzhidanie;
    private JLabel dizpersiya;
    private JPanel centerPanel;

    public TemperatureChart() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(panel1);
        setSize(1000,1000);
        setLocationRelativeTo(null);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    public JLabel getMatOzhidanie() {
        return matOzhidanie;
    }

    public JLabel getDizpersiya() {
        return dizpersiya;
    }

    public JFormattedTextField getSetYearField() {
        return setYearField;
    }

    public JButton getStartButton() {
        return startButton;
    }
}
