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

public class base {


    public WebDriver driver;
    public Properties pro;


    public WebDriver initializedDriver() throws IOException {
        pro = new Properties();
        FileInputStream file= new FileInputStream("C:\\Users\\Jormel Vunic\\Documents\\TestFalabella\\src\\main\\java\\resources\\Data.properties");

        pro.load(file);

        String browsername= pro.getProperty("browser");

        if (browsername.equals("chrome"))
        {

            System.setProperty("webdriver.chrome.driver",  "C:\\D\\chromedriver.exe");
            driver = new ChromeDriver();

        }
        else if (browsername.equals("firefox"))
        {
            driver = new FirefoxDriver();


        }
        else if (browsername.equals("IE"))
        {
            //execute IE
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {

        TakesScreenshot ts= (TakesScreenshot) driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        String destinationFile= System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
        FileUtils.copyFile(source, new File (destinationFile));
        return destinationFile;
    }

}

