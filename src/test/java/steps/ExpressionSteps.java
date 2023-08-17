package steps;

import pages.ExpressionPage;

public class ExpressionSteps {
    ExpressionPage page = new ExpressionPage();

    public void verifyAllElementsPresent() {
        page.assertThatAllElementsPresent();
    }

    public IncorrectPageSteps doIncorrectFormula(String formula) {
        page.fillFormulaField(formula);
        page.clickButton();
        return new IncorrectPageSteps();
    }
}
