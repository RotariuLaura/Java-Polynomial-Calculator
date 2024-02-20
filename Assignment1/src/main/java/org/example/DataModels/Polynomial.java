package org.example.DataModels;

import javax.swing.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private HashMap<Integer, Double> polynomial;
    public Polynomial() {
        polynomial = new HashMap<>();
    }

    public Polynomial(String inputPolynomial) {
        polynomial = new HashMap<>();
        try {
            Pattern termPattern = Pattern.compile("^([-+])?((\\d+(\\.\\d+)?)?\\*?)?(x(\\^(\\d+))?)?$");
            String[] terms = inputPolynomial.split("(?=[-+])");
            Arrays.stream(terms).forEach(term -> {
                term = term.trim();
                if (term.isEmpty()) return;
                Matcher matcher = termPattern.matcher(term);
                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(null), "Invalid input! Please introduce: a*x^n+ b*x^n-1+..! The coefficients and exponents equal to 1 can be omitted."); polynomial.clear();
                }
                double coefficient = 1.0;
                int exponent = 0;
                if (matcher.group(2) != null && !matcher.group(2).isEmpty()) {
                    coefficient = Double.parseDouble(matcher.group(2).replace("*", ""));
                }
                if (matcher.group(7) != null && !matcher.group(7).isEmpty()) {
                    exponent = Integer.parseInt(matcher.group(7));
                } else if (matcher.group(5) != null && !matcher.group(5).isEmpty()) {
                    exponent = 1;
                }
                if (matcher.group(1) != null && matcher.group(1).equals("-")) {
                    coefficient *= -1.0;
                }
                this.addTerm(exponent, coefficient);
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(null), "Invalid input! Please introduce: a*x^n+ b*x^n-1+..! The coefficients and exponents equal to 1 can be omitted."); polynomial.clear();
        }
    }
    public void addTerm(int exponent, double coefficent) {
        if(coefficent != 0.0) {
            polynomial.put(exponent, coefficent);
        }
        else{
            polynomial.remove(exponent);
        }
    }

    public HashMap<Integer, Double> getPolynomial() {
        return polynomial;
    }

    public void setPolynomial(HashMap<Integer, Double> polynomial) {
        this.polynomial = polynomial;
    }
    public int degree() {
        if (polynomial.isEmpty()) {
            return -1;
        }
        return Collections.max(polynomial.keySet());
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        final boolean[] firstTerm = {true};
        ArrayList <Integer> exponents = new ArrayList<>(polynomial.keySet());
        exponents.sort(Collections.reverseOrder());
        exponents.forEach(exponent -> {
            double coefficient = polynomial.get(exponent);
            if (coefficient != 0) {
                if (!firstTerm[0] && coefficient > 0) {
                    sb.append("+");
                }
                if (coefficient == -1 && exponent > 0) {
                    sb.append("-");
                } else if (coefficient != 1 || exponent == 0) {
                    sb.append(coefficient);
                    if(exponent > 0){
                        sb.append("*");
                    }
                }
                if (exponent > 0) {
                    sb.append("x");
                    if (exponent > 1) {
                        sb.append("^").append(exponent);
                    }
                }
                firstTerm[0] = false;
            }
        });
        if (firstTerm[0])  sb.append("0");
        return sb.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polynomial that = (Polynomial) o;
        return Objects.equals(polynomial, that.polynomial);
    }
}

