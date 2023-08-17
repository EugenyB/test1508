package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionPage extends BasePage {

    @FindBy(xpath = "//*[@for='formula']")
    WebElement label;

    @FindBy(id = "formula")
    WebElement textField;

    @FindBy(xpath = "//*[@id='calculate-button']")
    WebElement button;

    public void fillFormulaField(String text) {
        textField.clear();
        textField.sendKeys(text);
    }

    public void clickButton() {
        button.click();
    }

    public void assertThatAllElementsPresent() {
        assertThat(label.getText()).isEqualTo("Expression");
        assertThat(textField.isDisplayed()).isTrue();
        assertThat(button.isEnabled()).isTrue();
    }
}


