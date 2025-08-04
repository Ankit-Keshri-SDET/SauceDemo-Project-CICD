package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;
    @FindBy(id = "postal-code")
    private WebElement zipCode;
    @FindBy(name = "cancel")
    private WebElement cancelBtn;
    @FindBy(xpath = "//*[@value='Continue']")
    private WebElement continueBtn;
    @FindBy(xpath = "//*[@class='title']")
    private WebElement checkoutHeader;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstname) {
        firstName.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        lastName.sendKeys(lastname);
    }

    public void enterZipCode(String zipcode) {
        this.zipCode.sendKeys(zipcode);
    }

    public void clickContinueBtn() {
        continueBtn.click();
    }

    @Step
    public PaymentPage confirmCheckout(String firstName, String lastName, String zipCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterZipCode(zipCode);
        clickContinueBtn();
        return new PaymentPage(driver);
    }

    public String getCheckoutHeaderText() {
        return checkoutHeader.getText();
    }

    public void clickCancelBtn() {
        cancelBtn.click();
    }
}
