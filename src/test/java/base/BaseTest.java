package base;

import constants.BrowserType;
import factory.DriverManagerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.LoggerUtils;
import utils.ScreenshotUtils;
import java.io.File;
import java.io.IOException;

public class BaseTest {
    static {
        LoggerUtils.initLogs();
    }

    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    protected WebDriver getDriver() {
        return this.driver.get();
    }

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("EDGE") String browser) {
        setDriver(DriverManagerFactory.getManager(BrowserType.valueOf(browser)).createDriver());
    }

    @Parameters("browser")
    @AfterMethod
    public void tearDown(@Optional("EDGE") String browser, ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            File destFile = new File("screenshots" + File.separator + browser + File.separator
                    + result.getTestClass().getRealClass().getSimpleName() + "_" +
                    result.getMethod().getMethodName() + ".png");
            new ScreenshotUtils(getDriver()).takesScreenshotUsingAshot(destFile);
        }
        getDriver().quit();
    }
}
