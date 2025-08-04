package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {
    protected WebDriver driver;

    public ScreenshotUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(File destFile) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, destFile);
    }

    public void takesScreenshotUsingAshot(File destFile) {
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        try {
            boolean makeDirectory = destFile.mkdirs();
            ImageIO.write(screenshot.getImage(), "PNG", destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
