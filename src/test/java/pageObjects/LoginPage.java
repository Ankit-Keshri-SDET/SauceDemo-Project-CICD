package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(className = "login_logo")
    private WebElement logo;
    @FindBy(id = "user-name")
    private WebElement userName;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(name = "login-button")
    private WebElement loginBtn;
    @FindBy(tagName = "h3")
    private WebElement errorText;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUserName(String username) {
        userName.sendKeys(username);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public String getLogoText() {
        return logo.getText();
    }

    @Step
    public ProductsPage performLogin(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickLoginBtn();
        return new ProductsPage(driver);
    }

    public void performLogin() {
        userName.clear();
        password.clear();
        loginBtn.click();
    }

    public String getErrorText() {
        return errorText.getText();
    }

    public boolean isLoginBtnDisplayed() {
        return loginBtn.isDisplayed();
    }

    public LoginPage load() {
        loadURL("/");
        return this;
    }
}
