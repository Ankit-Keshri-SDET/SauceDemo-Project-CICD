package factory;

import constants.BrowserType;

public class DriverManagerFactory {

    public static DriverFactory getManager(BrowserType browserType) {
        switch ((browserType)) {
            case CHROME:
                return new ChromeDriverManager();
            case FIREFOX:
                return new FirefoxDriverManager();
            case EDGE:
                return new EdgeDriverManager();
            default:
                throw new IllegalArgumentException("INVALID BROWSER TYPE " + browserType);
        }
    }
}
