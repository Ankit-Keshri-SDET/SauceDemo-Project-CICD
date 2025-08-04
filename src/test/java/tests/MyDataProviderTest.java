package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.ConfigLoader;
import utils.DataProviderUtils;

public class MyDataProviderTest extends BaseTest {

    @Test(dataProvider = "addProductToCart", dataProviderClass = DataProviderUtils.class)
    public void addProductToCartTest(String prodName) {
        LoginPage lp = new LoginPage(getDriver()).load();
        ProductsPage pp = lp.performLogin(ConfigLoader.getInstance().getUsername2(), ConfigLoader.getInstance().getPassword());
        ProductPage pp1 = pp.selectProduct(prodName);
        pp1.clickOnAddToCartBtn();
        CartPage cp = pp1.clickCartButton();
        Assert.assertEquals(cp.getProductName(), prodName);
        cp.clickRemoveProductBtn();
        Assert.assertEquals(cp.getNumberOfProductsInCart(), 0);
    }

    @Test(dataProvider = "checkoutUserDetails", dataProviderClass = DataProviderUtils.class)
    public void completeCheckoutForUser(String fName, String lName, String zip) {
        String productName = ConfigLoader.getInstance().getProductName();
        LoginPage lp = new LoginPage(getDriver()).load();
        ProductsPage pp = lp.performLogin(ConfigLoader.getInstance().getUsername1(), ConfigLoader.getInstance().getPassword());
        Assert.assertEquals(pp.getHeader(), "Products", "Title mismatched ...");
        ProductPage pp1 = pp.selectProduct(productName);
        Assert.assertEquals(pp1.getProductName(), productName);
        pp1.clickOnAddToCartBtn();
        CartPage cp = pp1.clickCartButton();
        CheckoutPage ckp = cp.clickCheckoutBtn();
        PaymentPage payp = ckp.confirmCheckout(fName, lName, zip);
        Assert.assertEquals(payp.getProductNameText(), productName);
        payp.clickHamburgerMenuBtn();
        payp.clickLogoutButton();
        Assert.assertTrue(lp.isLoginBtnDisplayed());
    }
}
