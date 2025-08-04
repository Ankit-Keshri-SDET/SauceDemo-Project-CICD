package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingBtn;
    @FindBy(id = "checkout")
    private WebElement checkoutBtn;
    @FindBy(css = "button[id*='remove']")
    private WebElement removeProductBtn;
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> productsList;
    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> productsPrice;
    @FindBy(css = "[class='cart_item']")
    private List<WebElement> productsInCart;
    @FindBy(xpath = "//a[contains(@id,'item')]//div")
    private WebElement productNameInCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickContinueShoppingBtn() {
        continueShoppingBtn.click();
    }

    @Step
    public CheckoutPage clickCheckoutBtn() {
        checkoutBtn.click();
        return new CheckoutPage(driver);
    }

    public void clickRemoveProductBtn() {
        removeProductBtn.click();
    }

    public List<WebElement> getProductsList() {
        return productsList;
    }

    public int getNumberOfProductsInCart() {
        return productsInCart.size();
    }

    public String getProductName() {
        return productNameInCart.getText();
    }
}
