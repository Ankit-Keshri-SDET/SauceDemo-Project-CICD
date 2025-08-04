package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    @FindBy(id = "cancel")
    private WebElement cancelBtn;
    @FindBy(id = "finish")
    private WebElement finishBtn;
    @FindBy(xpath = "//*[@class='title']")
    private WebElement overViewHeader;
    @FindBy(css = "[data-test*=item-name]")
    private WebElement productText;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public ConfirmationPage clickFinishBtn() {
        finishBtn.click();
        return new ConfirmationPage(driver);
    }

    public String getProductNameText() {
        return productText.getText();
    }
}
