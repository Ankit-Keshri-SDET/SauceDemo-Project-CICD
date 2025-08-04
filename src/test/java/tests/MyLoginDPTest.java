package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utils.DataProviderUtils;

public class MyLoginDPTest extends BaseTest {

    @Test(dataProvider = "loginTest", dataProviderClass = DataProviderUtils.class)
    public void myLoginTest(String userName, String password) {
        LoginPage lp = new LoginPage(getDriver()).load();
        ProductsPage pp = lp.performLogin(userName, password);
        Assert.assertEquals(pp.getHeader(), "Products", "Title mismatched ...");
    }
}
