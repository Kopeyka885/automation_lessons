package lesson5;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.automation.lesson1.Calculator;

public class TestCalculator {

    @Test(groups = {"positive"})
    public void testSum() {
        Double factResult = Calculator.calculate("6", "3", "+", true);
        Double waitResult = 9.0;
        Assert.assertEquals(factResult, waitResult);
    }

    @Test(groups = {"positive"})
    public void testDiv() {
        Double factResult = Calculator.calculate("6", "3", "/", true);
        Double waitResult = 2.0;
        Assert.assertEquals(factResult, waitResult);
    }

    @Test(groups = {"positive"})
    public void testMult() {
        Double factResult = Calculator.calculate("6", "3", "*", true);
        Double waitResult = 18.0;
        Assert.assertEquals(factResult, waitResult);
    }

    @Test(groups = {"positive"})
    public void testDif() {
        Double factResult = Calculator.calculate("6", "3", "-", true);
        Double waitResult = 3.0;
        Assert.assertEquals(factResult, waitResult);
    }

    @Test(groups = {"negative"})
    public void testDivOnZero() {
        Calculator.calculate("6", "0", "/", true);
        System.out.println("testDivOnZero: There is no exception");
    }

    @Test(groups = {"negative"})
    public void testWithoutArg1() {
        Calculator.calculate(null, "0", "/", true);
        System.out.println("testWithoutArg1: There is no exception");
    }

    @Test(groups = {"negative"})
    public void testWithoutArg2() {
        Calculator.calculate("6", null, "/", true);
        System.out.println("testWithoutArg2: There is no exception");
    }

    @Test(groups = {"negative"})
    public void testWithoutOperation() {
        Calculator.calculate("6", "0", null, true);
        System.out.println("testWithoutOperation: There is no exception");
    }

    @Test(groups = {"negative"})
    public void testInvalidArg1() {
        Calculator.calculate("test", "0", "+", true);
        System.out.println("testInvalidArg1: There is no exception");
    }

    @Test(groups = {"negative"})
    public void testInvalidArg2() {
        Calculator.calculate("6", "test", "-", true);
        System.out.println("testInvalidArg2: There is no exception");
    }

    @Test(groups = {"negative"})
    public void testInvalidOperation() {
        Calculator.calculate("6", "3", "%", true);
        System.out.println("testInvalidOperation: There is no exception");
    }
}
