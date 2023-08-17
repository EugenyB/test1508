package steps;

import pages.IncorrectPage;

public class IncorrectPageSteps {

    IncorrectPage page = new IncorrectPage();

    public void verifyAllElements(String formula) {
        page.allEditsAreReadOnly();
    }

}
