package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(css = "[id*='add']")
    private WebElement addToCartBtn;
    @FindBy(xpath = "//div[contains(@data-test,'inventory-item-name')]")
    private WebElement productName;
    @FindBy(css = "//div[contains(@data-test,'inventory-item-price')]")
    private WebElement productPrice;
    @FindBy(id = "back-to-products")
    private WebElement backToProductsPage;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return productName.getText();
    }

    public int getProductPrice() {
        return Integer.parseInt(productPrice.getText().replace("$", "").trim());
    }

    @Step
    public void clickOnAddToCartBtn() {
        addToCartBtn.click();
    }

    public void returnToProductsPage() {
        backToProductsPage.click();
    }
}
