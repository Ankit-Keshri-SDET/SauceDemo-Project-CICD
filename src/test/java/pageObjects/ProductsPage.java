package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//button[contains(@id,'add')]")
    private List<WebElement> addProductBtn;
    @FindBy(xpath = "//div[contains(@class,'inventory_item_name ')]")
    private List<WebElement> productsLink;
    @FindBy(xpath = "//div[@class='inventory_item_price")
    private List<WebElement> productPrice;
    @FindBy(xpath = "//span[@class='title']")
    private WebElement productsHeader;
    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;
    @FindBy(xpath = "(//div[@class='inventory_item']//a[contains(@id,'title_link')])[1]")
    private WebElement cheapestProduct;

    private final String productPrefix = "//div[text()='";
    private final String productSuffix = "']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnProductByName(String productName) {
        int index = 0;
        for (WebElement product : productsLink) {
            if (product.getText().equalsIgnoreCase(productName)) {
                product.click();
                break;
            } else {
                index++;
            }
        }
    }

    public void addRandomProduct() {
        int randomNumber = (int) (Math.random() * addProductBtn.size());
        addProductBtn.get(randomNumber).click();
    }

    public String getHeader() {
        return productsHeader.getText();
    }

    public WebElement getSpecificProduct(String product) {
        String path = productPrefix + product + productSuffix;
        return driver.findElement(By.xpath(path));
    }

    @Step
    public ProductPage selectProduct(String product) {
        getSpecificProduct(product).click();
        return new ProductPage(driver);
    }

    public void sortProducts(String value) {
        Select sel = new Select(sortDropdown);
        sel.selectByValue(value);
    }

    public String getCheapestProductName() {
        return cheapestProduct.getText();
    }
}
