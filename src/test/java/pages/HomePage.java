package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public WebDriver driver;
    public WebDriverWait wait;

    private By categoryLocator = By.xpath("//div[@id='hamburgerMenu']");
    private By tecnologyLocator = By.xpath("//div[contains(text(),'Tecnología')]");
    private By consolaLocator = By.xpath("//a[contains(text(),'Consolas')]");
    private By titleConsolaLocator = By.xpath("//*[@id=\"testId-CategoryTitle-container\"]/span/h1");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 80);
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