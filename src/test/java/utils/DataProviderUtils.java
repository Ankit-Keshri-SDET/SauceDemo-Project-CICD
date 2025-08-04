package utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider(name = "addProductToCart", parallel = true)
    public Object[] getProductName() {
        String[] data = {"Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Onesie",
                "Sauce Labs Backpack"};
        return data;
    }

    @DataProvider(name = "loginTest")
    public Object[][] getUserData() {
        String[][] data = {{ConfigLoader.getInstance().getUsername1(), ConfigLoader.getInstance().getPassword()}
                , {ConfigLoader.getInstance().getUsername2(), ConfigLoader.getInstance().getPassword()}
                , {ConfigLoader.getInstance().getUsername3(), ConfigLoader.getInstance().getPassword()}
                , {ConfigLoader.getInstance().getUsername4(), ConfigLoader.getInstance().getPassword()}};
        return data;
    }

    @DataProvider(name = "checkoutUserDetails")
    public Object[][] getUserDeatils() {
        String[][] userData = {{"Ben", "Duckett", "786789"},
                {"Zak", "Crawley", "665411"},
                {ConfigLoader.getInstance().getFirstName(), ConfigLoader.getInstance().getLastName(), ConfigLoader.getInstance().getZipCode()},
                {"Joe", "Root", "98799"}};

        return userData;
    }
}
