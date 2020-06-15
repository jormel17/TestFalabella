package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public WebDriver driver;
    public WebDriverWait wait;

    By categoryLocator = By.xpath("//div[@id='hamburgerMenu']");
    By tecnologyLocator = By.xpath("//div[contains(text(),'Tecnología')]");
    By consolaLocator = By.xpath("//a[contains(text(),'Consolas')]");
    By titleConsolaLocator = By.xpath("//*[@id=\"testId-CategoryTitle-container\"]/span/h1");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }

    public void clickCategory() {
        driver.findElement(categoryLocator).click();
    }

    public void clickTecnology() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tecnologyLocator));
        driver.findElement(tecnologyLocator).click();
    }

    public void clickConsola() {
        driver.findElement(consolaLocator).click();
    }

    public String getTitleConsola() {
        return driver.findElement(titleConsolaLocator).getText();
    }

}
