package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.ConfigLoader;

@Epic("Self Service Management")
@Feature("User Group Management")
public class MySecondTest extends BaseTest {

    @Story("Request Access for PSI")
    @Link("https://saucelabs.com/")
    @Link(name = "allure", type = "mylink")
    @Issue("12345")
    @TmsLink("123")
    @Description("This is the description of the test case.")
    @Test(description = "Testing Test Case with Allure Display name")
    public void purchaseProduct() {
        String productName = ConfigLoader.getInstance().getProductName();
        LoginPage lp = new LoginPage(getDriver()).load();
        ProductsPage pp = lp.performLogin(ConfigLoader.getInstance().getUsername1(), ConfigLoader.getInstance().getPassword());
        Assert.assertEquals(pp.getHeader(), "Products", "Title mismatched ...");
        ProductPage pp1 = pp.selectProduct(productName);
        Assert.assertEquals(pp1.getProductName(), productName);
        pp1.clickOnAddToCartBtn();
        CartPage cp = pp1.clickCartButton();
        CheckoutPage ckp = cp.clickCheckoutBtn();
        PaymentPage payp = ckp.confirmCheckout(ConfigLoader.getInstance().getFirstName(), ConfigLoader.getInstance().getLastName(), ConfigLoader.getInstance().getZipCode());
        Assert.assertEquals(payp.getProductNameText(), productName);
        ConfirmationPage cop = payp.clickFinishBtn();
        // Fail test case here ..
        Assert.assertEquals(cop.getThankYouMessage(), "Thank you for your order!", "Message Incorrect ...");
        pp = cop.goToProductsPage();
        Assert.assertEquals(pp.getHeader(), "Products", "Title mismatched ...");
    }
}
