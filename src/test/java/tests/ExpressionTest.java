package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.ExpressionSteps;
import steps.IncorrectPageSteps;

public class ExpressionTest extends BaseTest {

    ExpressionSteps steps;

    @BeforeMethod
    public void setUp() {
        steps = new ExpressionSteps();
    }

    @Test
    public void testExpressionPage() {
        visit("");
        steps.verifyAllElementsPresent();
    }

    @Test(dataProvider = "incorrectData")
    public void testIncorrectExpression(String formula) {
        visit("");
        IncorrectPageSteps steps1 = steps.doIncorrectFormula(formula);
        steps1.verifyAllElements(formula);
    }
}