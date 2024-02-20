package org.example.GUI;

import org.example.DataModels.Polynomial;
import org.example.BusinessLogic.PolynomialOperations;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PolynomialInterface {
    private JFrame frmOperationsWithPolynomials;
    PolynomialOperations operationsWithPolynomials;

    public static void main(String[] args) {
        try {
            PolynomialInterface window = new PolynomialInterface();
            window.frmOperationsWithPolynomials.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PolynomialInterface() {
        create();
    }

    private void create() {
        operationsWithPolynomials = new PolynomialOperations();
        frmOperationsWithPolynomials = new JFrame();
        frmOperationsWithPolynomials.setTitle("Polynomial Calculator");
        frmOperationsWithPolynomials.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
        frmOperationsWithPolynomials.setBounds(100, 100, 300, 320);
        frmOperationsWithPolynomials.setBackground(Color.LIGHT_GRAY);
        frmOperationsWithPolynomials.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmOperationsWithPolynomials.getContentPane().setLayout(null);

        JLabel label = new JLabel("Polynomial Calculator");
        label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        label.setBounds(80, 11, 215, 20);
        label.setForeground(Color.DARK_GRAY);
        frmOperationsWithPolynomials.getContentPane().add(label);

        JLabel lblFirstPolynomial = new JLabel("First polynomial = ");
        lblFirstPolynomial.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblFirstPolynomial.setBounds(21, 42, 215, 20);
        frmOperationsWithPolynomials.getContentPane().add(lblFirstPolynomial);

        JLabel lblSecondPolynomial = new JLabel("Second polynomial = ");
        lblSecondPolynomial.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblSecondPolynomial.setBounds(10, 73, 215, 20);
        frmOperationsWithPolynomials.getContentPane().add(lblSecondPolynomial);

        JLabel lblResult = new JLabel("Result = ");
        lblResult.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblResult.setBounds(40, 104, 215, 20);
        frmOperationsWithPolynomials.getContentPane().add(lblResult);

        JTextField firstPolynomial = new JTextField();
        firstPolynomial.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        firstPolynomial.setColumns(10);
        firstPolynomial.setBounds(110, 42, 160, 20);
        frmOperationsWithPolynomials.getContentPane().add(firstPolynomial);

        JTextField secondPolynomial = new JTextField();
        secondPolynomial.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        secondPolynomial.setColumns(10);
        secondPolynomial.setBounds(110, 73, 160, 20);
        frmOperationsWithPolynomials.getContentPane().add(secondPolynomial);

        JTextField result = new JTextField();
        result.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        result.setColumns(10);
        result.setBounds(110, 104, 160, 20);
        frmOperationsWithPolynomials.getContentPane().add(result);

        JSeparator separator1 = new JSeparator();
        separator1.setBounds(10, 140, 265, 2);
        frmOperationsWithPolynomials.getContentPane().add(separator1);

        JLabel lblOperationsWithOne = new JLabel("Operations with one polynomial");
        lblOperationsWithOne.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblOperationsWithOne.setBounds(75, 140, 464, 20);
        frmOperationsWithPolynomials.getContentPane().add(lblOperationsWithOne);

        JButton btnDerive = new JButton("Differentiate");
        btnDerive.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Polynomial polynomial = new Polynomial(firstPolynomial.getText());
                Polynomial resultPolynomial = operationsWithPolynomials.differentiatePolynomial(polynomial);
                String string = resultPolynomial.toString();
                result.setText(string);
            }
        });
        btnDerive.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnDerive.setBounds(25, 160, 100, 20);
        btnDerive.setBackground(Color.lightGray);
        frmOperationsWithPolynomials.getContentPane().add(btnDerive);

        JButton btnIntegrate = new JButton("Integrate");
        btnIntegrate.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Polynomial polynomial = new Polynomial(firstPolynomial.getText());
                Polynomial resultPolynomial = operationsWithPolynomials.integratePolynomial(polynomial);
                String string = resultPolynomial.toString();
                result.setText(string);
            }
        });
        btnIntegrate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnIntegrate.setBounds(155, 160, 100, 20);
        btnIntegrate.setBackground(Color.lightGray);
        frmOperationsWithPolynomials.getContentPane().add(btnIntegrate);

        JSeparator separator2 = new JSeparator();
        separator2.setBounds(10, 190, 265, 2);
        frmOperationsWithPolynomials.getContentPane().add(separator2);

        JLabel lblOperationsWithTwo = new JLabel("Operations with two polynomials");
        lblOperationsWithTwo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        lblOperationsWithTwo.setBounds(75, 190, 464, 20);
        frmOperationsWithPolynomials.getContentPane().add(lblOperationsWithTwo);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial(firstPolynomial.getText());
                Polynomial polynomial2 = new Polynomial(secondPolynomial.getText());
                Polynomial resultPolynomial = operationsWithPolynomials.addPolynomials(polynomial1, polynomial2);
                String string = resultPolynomial.toString();
                result.setText(string);
            }
        });
        btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnAdd.setBounds(25, 210, 100, 20);
        btnAdd.setBackground(Color.lightGray);
        frmOperationsWithPolynomials.getContentPane().add(btnAdd);

        JButton btnSubtract = new JButton("Subtract");
        btnSubtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial(firstPolynomial.getText());
                Polynomial polynomial2 = new Polynomial(secondPolynomial.getText());
                Polynomial resultPolynomial = operationsWithPolynomials.subtractPolynomials(polynomial1, polynomial2);
                String string = resultPolynomial.toString();
                result.setText(string);
            }
        });
        btnSubtract.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnSubtract.setBounds(155, 210, 100, 20);
        btnSubtract.setBackground(Color.lightGray);
        frmOperationsWithPolynomials.getContentPane().add(btnSubtract);

        JButton btnMultiply = new JButton("Multiply");
        btnMultiply.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Polynomial polynomial1 = new Polynomial(firstPolynomial.getText());
                Polynomial polynomial2 = new Polynomial(secondPolynomial.getText());
                Polynomial resultPolynomial = operationsWithPolynomials.multiplyPolynomials(polynomial1, polynomial2);
                String string = resultPolynomial.toString();
                result.setText(string);
            }
        });
        btnMultiply.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnMultiply.setBounds(25, 240, 100, 20);
        btnMultiply.setBackground(Color.lightGray);
        frmOperationsWithPolynomials.getContentPane().add(btnMultiply);

        JButton btnDivide = new JButton("Divide");
        btnDivide.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Polynomial polynomial1 = new Polynomial(firstPolynomial.getText());
                Polynomial polynomial2 = new Polynomial(secondPolynomial.getText());
                Polynomial [] resultPolynomials = operationsWithPolynomials.dividePolynomials(polynomial1, polynomial2);
                if(resultPolynomials[0].equals(new Polynomial("0")) && resultPolynomials[1].equals(new Polynomial("0"))){
                    result.setText("0");
                }
                else {
                    String string = "Q: " + resultPolynomials[0].toString() + ", R: " + resultPolynomials[1].toString();
                    result.setText(string);
                }
            }
        });
        btnDivide.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnDivide.setBounds(155, 240, 100, 20);
        btnDivide.setBackground(Color.lightGray);
        frmOperationsWithPolynomials.getContentPane().add(btnDivide);
    }
}

