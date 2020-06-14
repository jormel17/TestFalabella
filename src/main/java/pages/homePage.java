package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {

    public WebDriver driver;
    public WebDriverWait wait;

    By categoryLocator = By.xpath("//div[@id='hamburgerMenu']");

    By tecnologyLocator = By.xpath("//div[contains(text(),'Tecnología')]");

    By consolaLocator = By.xpath("//a[contains(text(),'Consolas')]");

    By titleConsolaLocator = By.xpath("//*[@id=\"testId-CategoryTitle-container\"]/span/h1");
    ///-----------------------------





    public homePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }

    public WebElement getCategoryLocator(){

        return driver.findElement(categoryLocator);
    }

    public void clickCategory(){
        getCategoryLocator().click();
    }

    public WebElement getTecnology()
    { return  driver.findElement(tecnologyLocator);}

    public void clickTecnology(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tecnologyLocator));
        getTecnology().click();


    }

    public WebElement getConsolaLocator(){
        return  driver.findElement(consolaLocator);
    }

    public void clickConsola(){

        getConsolaLocator().click();
    }

    public WebElement getTitleConsola(){
        return  driver.findElement(titleConsolaLocator);
    }




}
