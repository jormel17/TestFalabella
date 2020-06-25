package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {


    public static WebDriver driver;
    public Properties pro;


    public WebDriver initializedDriver() throws IOException {
        pro = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/Data.properties");

        pro.load(file);

        String BrowserName = pro.getProperty("browser");
        //String osName = System.getProperty("os.name").toLowerCase().contains("mac") ? "mac" : "Windows";


        if (BrowserName.equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/resources/driver/chromedriver.exe");
            driver = new ChromeDriver();


        } else if (BrowserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/resources/driver/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }
}