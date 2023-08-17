package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class IncorrectPage extends BasePage {

    @FindBy(id="expression")
    WebElement expressionField;

    @FindBy(id = "result")
    WebElement resultField;

    @FindBy(xpath = "//*[@class='btn btn-info']")
    WebElement backLink;

    public void clickBackLink() {
        backLink.click();
    }

    public void allEditsAreReadOnly() {
        String text = expressionField.getText();
        expressionField.sendKeys("12345");
        assertThat(expressionField.getText()).isEqualTo(text);
    }
}
