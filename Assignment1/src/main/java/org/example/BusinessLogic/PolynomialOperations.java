package org.example.BusinessLogic;

import org.example.DataModels.Polynomial;

import javax.swing.*;

public class PolynomialOperations {
    public Polynomial addPolynomials(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        Polynomial result = new Polynomial();
        firstPolynomial.getPolynomial().forEach((exponent, coefficient) -> result.addTerm(exponent, coefficient));
        secondPolynomial.getPolynomial().forEach((exponent, coefficient) -> {
            double coeff;
            if(result.getPolynomial().containsKey(exponent)){
                coeff = result.getPolynomial().get(exponent);
            } else {
                coeff = 0.0;
            }
            result.addTerm(exponent, coeff + coefficient);
        });
        return result;
    }
    public Polynomial subtractPolynomials(Polynomial firstPolynomial, Polynomial secondPolynomial){
        Polynomial result = new Polynomial();
        firstPolynomial.getPolynomial().forEach((exponent, coefficient) -> result.addTerm(exponent, coefficient));
        secondPolynomial.getPolynomial().forEach((exponent, coefficient) -> {
            double coeff;
            if(result.getPolynomial().containsKey(exponent)){
                coeff = result.getPolynomial().get(exponent);
            } else {
                coeff = 0.0;
            }
            result.addTerm(exponent, coeff - coefficient);
        });
        return result;
    }
    public Polynomial multiplyPolynomials(Polynomial firstPolynomial, Polynomial secondPolynomial){
        Polynomial result = new Polynomial();
        firstPolynomial.getPolynomial().forEach((exponent1, coefficient1) -> secondPolynomial.getPolynomial().forEach((exponent2, coefficient2) -> {
            int resExp = exponent1 + exponent2;
            double resCoeff = coefficient1 * coefficient2;
            double coeff;
            if(result.getPolynomial().containsKey(resExp)){
                coeff = result.getPolynomial().get(resExp);
            } else {
                coeff = 0.0;
            }
            result.addTerm(resExp, coeff + resCoeff);
        }));
        return result;
    }
    public Polynomial[] dividePolynomials(Polynomial numerator, Polynomial denominator) {
        Polynomial [] result = new Polynomial[2];
        if (denominator.getPolynomial().isEmpty()) {
            JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(null), "Denominator cannot be zero");
            result[0] = new Polynomial("0");
            result[1] = new Polynomial("0");
        }
        else {
            Polynomial quotient = new Polynomial();
            Polynomial remainder = new Polynomial();
            remainder.setPolynomial(numerator.getPolynomial());
            while (!remainder.getPolynomial().isEmpty() && remainder.degree() >= denominator.degree()) {
                int leadExpRem = remainder.degree();
                int leadExpDen = denominator.degree();
                int leadExp = leadExpRem - leadExpDen;
                double leadCoeff = remainder.getPolynomial().get(leadExpRem) / denominator.getPolynomial().get(leadExpDen);
                quotient.addTerm(leadExp, leadCoeff);
                Polynomial term = new Polynomial();
                term.addTerm(leadExp, leadCoeff);
                Polynomial prod = multiplyPolynomials(denominator, term);
                remainder = subtractPolynomials(remainder, prod);
            }
            result[0] = quotient;
            result[1] = remainder;
        }
        return result;
    }
    public Polynomial differentiatePolynomial(Polynomial polynomial) {
        Polynomial copy = polynomial;
        Polynomial result = new Polynomial();
        copy.getPolynomial().forEach((exponent, coefficient) -> {
            if(coefficient != 0.0) {
                coefficient = coefficient * exponent;
            } else {
                coefficient = (double) exponent;
            }
            if(exponent > 1) {
                exponent = exponent - 1;
            }
            else {
                exponent = 0;
            }
            result.addTerm(exponent, coefficient);
        });
        return result;
    }
    public Polynomial integratePolynomial(Polynomial polynomial) {
        Polynomial copy = polynomial;
        Polynomial result = new Polynomial();
        copy.getPolynomial().forEach((exponent, coefficient) -> {
            exponent ++;
            if(coefficient != 0.0) {
                coefficient = Math.round(coefficient * ((double) 1 / exponent) * 100.00) / 100.00;
            } else {
                coefficient = Math.round(((double) 1 / exponent) * 100.00) / 100.00;
            }
            result.addTerm(exponent, coefficient);
        });
        return result;
    }
}
