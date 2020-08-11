package homeWork7.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private final String NUMBER_1 = "1";
    private final String NUMBER_2 = "2";
    private final String NUMBER_3 = "3";
    private final String NUMBER_4 = "4";
    private final String NUMBER_5 = "5";
    private final String NUMBER_6 = "6";
    private final String NUMBER_7 = "7";
    private final String NUMBER_8 = "8";
    private final String NUMBER_9 = "9";
    private final String NUMBER_0 = "0";
    private final String DOT = ".";
    private final String DIV = "/";
    private final String MULTI = "x";
    private final String PLUS = "+";
    private final String MINUS = "-";
    private final String TOTAL = "=";
    private final String CLEAR_BUTTON = "C";
    private double a = 0;
    private double b = 0;
    private JTextField result;
    private String operation = "";
    private String argument;

    public Calculator() {
        super("Анькин калькулятор");
        setBounds(100, 100, 400, 400);

        JPanel resultPanel = new JPanel();
        result = new JTextField(25);
        result.setHorizontalAlignment(JTextField.RIGHT);
        result.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JButton clearButton = new JButton(CLEAR_BUTTON);
        resultPanel.add(result, BorderLayout.WEST);
        resultPanel.add(clearButton, BorderLayout.EAST);
        add(resultPanel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new GridLayout(4, 4, 5, 12));

        JButton button1 = new JButton(NUMBER_1);
        buttonsPanel.add(button1);
        JButton button2 = new JButton(NUMBER_2);
        buttonsPanel.add(button2);
        JButton button3 = new JButton(NUMBER_3);
        buttonsPanel.add(button3);
        JButton buttonDiv = new JButton(DIV);
        buttonsPanel.add(buttonDiv);
        JButton button4 = new JButton(NUMBER_4);
        buttonsPanel.add(button4);
        JButton button5 = new JButton(NUMBER_5);
        buttonsPanel.add(button5);
        JButton button6 = new JButton(NUMBER_6);
        buttonsPanel.add(button6);
        JButton buttonMulti = new JButton(MULTI);
        buttonsPanel.add(buttonMulti);
        JButton button7 = new JButton(NUMBER_7);
        buttonsPanel.add(button7);
        JButton button8 = new JButton(NUMBER_8);
        buttonsPanel.add(button8);
        JButton button9 = new JButton(NUMBER_9);
        buttonsPanel.add(button9);
        JButton buttonMinus = new JButton(MINUS);
        buttonsPanel.add(buttonMinus);
        JButton button0 = new JButton(NUMBER_0);
        buttonsPanel.add(button0);
        JButton buttonDot = new JButton(DOT);
        buttonsPanel.add(buttonDot);
        JButton buttonTotal = new JButton(TOTAL);
        buttonsPanel.add(buttonTotal);
        JButton buttonPlus = new JButton(PLUS);
        buttonsPanel.add(buttonPlus);

        add(buttonsPanel, BorderLayout.CENTER);

        ButtonNumberListener buttonNumberListener = new ButtonNumberListener();

        button0.addActionListener(buttonNumberListener);
        button1.addActionListener(buttonNumberListener);
        button2.addActionListener(buttonNumberListener);
        button3.addActionListener(buttonNumberListener);
        button4.addActionListener(buttonNumberListener);
        button5.addActionListener(buttonNumberListener);
        button6.addActionListener(buttonNumberListener);
        button7.addActionListener(buttonNumberListener);
        button8.addActionListener(buttonNumberListener);
        button9.addActionListener(buttonNumberListener);
        buttonDot.addActionListener(buttonNumberListener);

        ButtonOperationListener buttonOperationListener = new ButtonOperationListener();

        buttonDiv.addActionListener(buttonOperationListener);
        buttonMulti.addActionListener(buttonOperationListener);
        buttonPlus.addActionListener(buttonOperationListener);
        buttonMinus.addActionListener(buttonOperationListener);

        buttonTotal.addActionListener(new ButtonTotalListener());

        clearButton.addActionListener(e -> {
            a = 0;
            b = 0;
            result.setText("");
            argument = "";
            operation = "";
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public double calculate(String expression) {
        int operationPos = expression.indexOf(operation);
        double a = Double.valueOf(expression.substring(0, operationPos));
        double b = Double.valueOf(expression.substring(operationPos + operation.length()));

        switch (operation) {
            case PLUS:
                return a + b;
            case MINUS:
                return a - b;
            case MULTI:
                return a * b;
            case DIV:
                return a / b;
        }
        return 0;
    }

    private class ButtonNumberListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            result.setText(result.getText() + button.getText());
        }
    }

    private class ButtonOperationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if (!operation.isEmpty()) {
                result.setText(String.valueOf(calculate(result.getText())));
            }
            result.setText(result.getText() + button.getText());
            operation = button.getText();
        }
    }

    private class ButtonTotalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            result.setText(String.valueOf(calculate(result.getText())));
            operation = "";
        }
    }
}
