package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addCarPage {
    public WebDriver driver;
    public WebDriverWait wait;


    By btnBagLocator = By.xpath("//button[@class='jsx-1816208196 button button-primary button-primary-xtra-large']");

    By titleCarOfBuyLocator = By.xpath("//span[contains(text(),'Producto(s) agregado(s) a la bolsa de compras')]");

    By btnIncrementProductLocator = By.xpath("//button[contains(@class,'jsx-635184967 increment')]");

    By seeBuyCarLocator = By.xpath("//a[@id='linkButton']");

    By buyResumLocator = By.xpath("//h4[@class='fb-order-status__title']");


    public addCarPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }



    public WebElement getAddBag(){
        return driver.findElement(btnBagLocator);
    }

    public void clickBtnAddProduct(){
        getAddBag().click();
    }

    public WebElement getIncrementProduct(int i){


        return driver.findElement(btnIncrementProductLocator);
    }

    public void clickIncrementProduct(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleCarOfBuyLocator));
        for (int i=0; i<2; i++) {

            getIncrementProduct(i).click();

        }

    }

    public WebElement getSeeBuyCar(){
        return driver.findElement(seeBuyCarLocator);
    }

    public void clickSeekBuyResume(){
        wait.until(ExpectedConditions.elementToBeClickable(seeBuyCarLocator));
        getSeeBuyCar().click();

    }

    public WebElement getBuyResum(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buyResumLocator));
        return driver.findElement(buyResumLocator);
    }


}
