package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.ConfigLoader;

public class MyFirstTest extends BaseTest {

    @Test
    public void purchaseMultipleProducts() {
        LoginPage lp = new LoginPage(getDriver()).load();
        ProductsPage pp = lp.performLogin(ConfigLoader.getInstance().getUsername1(), ConfigLoader.getInstance().getPassword());
        Assert.assertEquals(pp.getHeader(), "Products", "Title mismatched ...");
        pp.addRandomProduct();
        pp.addRandomProduct();
        CartPage cp = pp.clickCartButton();
        Assert.assertTrue(cp.getNumberOfProductsInCart() > 1);
        CheckoutPage cop = cp.clickCheckoutBtn();
        PaymentPage payp = cop.confirmCheckout(ConfigLoader.getInstance().getFirstName(), ConfigLoader.getInstance().getLastName(), ConfigLoader.getInstance().getZipCode());
        ConfirmationPage ccp = payp.clickFinishBtn();
        Assert.assertEquals(ccp.getThankYouMessage(), "Thank you for your order!", "Message Incorrect ...");
    }

    @Test
    public void purchaseCheapestProduct() {
        logger.info("Test Case started ..");
        LoginPage lp = new LoginPage(getDriver()).load();
        logger.info("Performing Success Login ..");
        ProductsPage pp = lp.performLogin(ConfigLoader.getInstance().getUsername1(), ConfigLoader.getInstance().getPassword());
        pp.sortProducts("lohi");
        String productName = pp.getCheapestProductName();
        logger.info("Selecting product ..");
        ProductPage pp1 = pp.selectProduct(pp.getCheapestProductName());
        Assert.assertEquals(pp1.getProductName(), productName);
        pp1.clickOnAddToCartBtn();
        logger.info("Navigating to Cart Page ..");
        CartPage cp = pp1.clickCartButton();
        logger.info("Navigating to Checkout Page ..");
        CheckoutPage cop = cp.clickCheckoutBtn();
        logger.info("Navigating to Payment Page ..");
        PaymentPage payp = cop.confirmCheckout(ConfigLoader.getInstance().getFirstName(), ConfigLoader.getInstance().getLastName(), ConfigLoader.getInstance().getZipCode());
        Assert.assertEquals(payp.getProductNameText(), productName);
        logger.info("Navigating to Confirmation Page ..");
        ConfirmationPage ccp = payp.clickFinishBtn();
        Assert.assertEquals(ccp.getThankYouMessage(), "Thank you for your order!", "Message Incorrect ...");
        ccp.clickHamburgerMenuBtn();
        ccp.clickLogoutButton();
        logger.info("Verifying if Login Page is displayed ..");
        Assert.assertTrue(lp.isLoginBtnDisplayed());
        logger.info("Test Case Completed ..");
    }
}
