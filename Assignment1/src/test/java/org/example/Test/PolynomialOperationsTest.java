package org.example.Test;
import org.example.BusinessLogic.PolynomialOperations;
import org.example.DataModels.Polynomial;
import org.junit.Assert;
import org.junit.Test;

public class PolynomialOperationsTest {
    PolynomialOperations polynomialOperations = new PolynomialOperations();
    @Test
    public void addTest1() {
        Polynomial polynomial1 = new Polynomial("4*x^5-3*x^4+x^2-8*x+1");
        Polynomial polynomial2 = new Polynomial("3*x^4-x^3+x^2+2*x-1");
        Polynomial expectedResult = new Polynomial("4*x^5-x^3+2*x^2-6*x");
        Polynomial actualResult = polynomialOperations.addPolynomials(polynomial1, polynomial2);
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void addTest2() {
        Polynomial polynomial1 = new Polynomial("4*x^5-3*x^4+x^2-8*x+1");
        Polynomial polynomial2 = new Polynomial("3*x^4-x^3+x^2+2*x-1");
        Polynomial wrongResult = new Polynomial("4*x^5");
        Polynomial actualResult = polynomialOperations.addPolynomials(polynomial1, polynomial2);
        Assert.assertEquals(actualResult, wrongResult);
    }
    @Test
    public void subtractTest1() {
        Polynomial polynomial1 = new Polynomial("4*x^5-3*x^4+x^2-8*x+1");
        Polynomial polynomial2 = new Polynomial("3*x^4-x^3+x^2+2*x-1");
        Polynomial expectedResult = new Polynomial("4*x^5-6*x^4+x^3-10*x+2");
        Polynomial actualResult = polynomialOperations.subtractPolynomials(polynomial1, polynomial2);
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void subtractTest2() {
        Polynomial polynomial1 = new Polynomial("4*x^5-3*x^4+x^2-8*x+1");
        Polynomial polynomial2 = new Polynomial("3*x^4-x^3+x^2+2*x-1");
        Polynomial wrongResult = new Polynomial("4*x^5-6*x^4");
        Polynomial actualResult = polynomialOperations.subtractPolynomials(polynomial1, polynomial2);
        Assert.assertEquals(actualResult, wrongResult);
    }
    @Test
    public void multiplyTest1() {
        Polynomial polynomial1 = new Polynomial("3*x^2-x+1");
        Polynomial polynomial2 = new Polynomial("x-2");
        Polynomial expectedResult = new Polynomial("3*x^3-7*x^2+3*x-2");
        Polynomial actualResult = polynomialOperations.multiplyPolynomials(polynomial1, polynomial2);
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void multiplyTest2() {
        Polynomial polynomial1 = new Polynomial("3*x^2-x+1");
        Polynomial polynomial2 = new Polynomial("x-2");
        Polynomial wrongResult = new Polynomial("3*x^3-x^2+x-2");
        Polynomial actualResult = polynomialOperations.multiplyPolynomials(polynomial1, polynomial2);
        Assert.assertEquals(actualResult, wrongResult);
    }
    @Test
    public void divideTest1() {
        Polynomial polynomial1 = new Polynomial("x^3-2*x^2+6*x-5");
        Polynomial polynomial2 = new Polynomial("x^2-1");
        Polynomial [] expectedResult = new Polynomial [2];
        expectedResult[0] = new Polynomial("x-2");
        expectedResult[1] = new Polynomial("7*x-7");
        Polynomial [] actualResult = polynomialOperations.dividePolynomials(polynomial1, polynomial2);
        Assert.assertEquals(actualResult[0], expectedResult[0]);
        Assert.assertEquals(actualResult[1], expectedResult[1]);
    }
    @Test
    public void divideTest2() {
        Polynomial polynomial1 = new Polynomial("x^3-2*x^2+6*x-5");
        Polynomial polynomial2 = new Polynomial("x^2-1");
        Polynomial [] wrongResult = new Polynomial [2];
        wrongResult[0] = new Polynomial("x-1");
        wrongResult[1] = new Polynomial("x-7");
        Polynomial [] actualResult = polynomialOperations.dividePolynomials(polynomial1, polynomial2);
        Assert.assertEquals(actualResult[0], wrongResult[0]);
        Assert.assertEquals(actualResult[1], wrongResult[1]);
    }
    @Test
    public void differentiateTest1() {
        Polynomial polynomial = new Polynomial("x^3-2*x^2+6*x-5");
        Polynomial expectedResult = new Polynomial("3*x^2-4*x+6");
        Polynomial actualResult = polynomialOperations.differentiatePolynomial(polynomial);
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void differentiateTest2() {
        Polynomial polynomial = new Polynomial("x^3-2*x^2+6*x-5");
        Polynomial wrongResult = new Polynomial("3*x^2");
        Polynomial actualResult = polynomialOperations.differentiatePolynomial(polynomial);
        Assert.assertEquals(actualResult, wrongResult);
    }
    @Test
    public void integrateTest1() {
        Polynomial polynomial = new Polynomial("x^3+4*x^2+5");
        Polynomial expectedResult = new Polynomial("0.25*x^4+1.33*x^3+5*x");
        Polynomial actualResult = polynomialOperations.integratePolynomial(polynomial);
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test
    public void integrateTest2() {
        Polynomial polynomial = new Polynomial("x^3+4*x^2+5");
        Polynomial wrongResult = new Polynomial("0.25*x^4+1.33*x^3");
        Polynomial actualResult = polynomialOperations.integratePolynomial(polynomial);
        Assert.assertEquals(actualResult, wrongResult);
    }
}
