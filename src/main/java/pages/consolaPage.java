package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class consolaPage {
    public WebDriver driver;
    public WebDriverWait wait;
    By brandLocator = By.id("testId-Accordion-Marca");

    By checkboxLocator = By.xpath("//input[@id='SONY-5']");

    By checkFilterLocator = By.xpath("//div[@id='testId-pod-8158922']//b[contains(@class,'pod-title')][contains(text(),'Sony')]");

    By btnSeeProductLocator = By.xpath("//button[@id='testId-Pod-action-8158922']");


    public consolaPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }

    public WebElement getProductBrand(){
        return  driver.findElement(brandLocator);
    }

    public void clickBrand(){
        wait.until(ExpectedConditions.elementToBeClickable(brandLocator));
        getProductBrand().click();
    }

    public WebElement getChechboxBrand(){
        return driver.findElement(checkboxLocator);
    }

    public void selectChecboxBrand(){

        getChechboxBrand().click();
    }

    public WebElement getBrandFilter(){

        return driver.findElement(checkFilterLocator);
    }

    public WebElement getBtnSeeProduct(){
        return driver.findElement(btnSeeProductLocator);
    }

    public void clickBtnSeePorduct() {
        wait.until(ExpectedConditions.elementToBeClickable(btnSeeProductLocator));
        getBtnSeeProduct().click();
    }
}
