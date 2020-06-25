package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddProductCarPage {
    public WebDriver driver;
    public WebDriverWait wait;

    private By brandLocator = By.id("testId-Accordion-Marca");
    private By checkboxLocator = By.className("jsx-53718149");
    private By filterBrandLocator = By.xpath("//div[@class='jsx-287641535']/b");
    private By btnSeeProductLocator = By.xpath("//div[@class='jsx-287641535 pod-action']");
    private By btnBagLocator = By.xpath("//div[@id='buttonForCustomers']");
    private By titleCarOfBuyLocator = By.xpath("//span[contains(text(),'Producto(s) agregado(s) a la bolsa de compras')]");
    private By btnIncrementProductLocator = By.xpath("//div[@class='jsx-635184967 product-count']/button[2]");
    private By seeBuyCarLocator = By.xpath("//a[@id='linkButton']");
    private By OrderSummaryLocator = By.xpath("//h4[@class='fb-order-status__title']");

    public AddProductCarPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 80);
    }

    public WebElement getProductBrand() {
        return driver.findElement(brandLocator);
    }

    public void clickBrand() {
        wait.until(ExpectedConditions.elementToBeClickable(brandLocator));
        getProductBrand().click();
    }

    public void selectChecboxBrand(String brand) {

        List<WebElement> brands = driver.findElements(checkboxLocator);
        for (int i = 0; i < brands.size(); i++) {
            if (brand.equalsIgnoreCase(brands.get(i).getText())) {
                brands.get(i).click();
                break;
            }
        }
    }

    public String getBrandFilter() {
        return driver.findElement(filterBrandLocator).getText();
    }

    public void clickBtnSeePorduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnSeeProductLocator));
        driver.findElement(btnSeeProductLocator).click();
    }

    public WebElement getBtnAddBag() {
        return driver.findElement(btnBagLocator);
    }

    public void clickBtnAddProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnBagLocator));
        getBtnAddBag().click();
    }

    public WebElement getIncrementProduct(int i) {
        return driver.findElement(btnIncrementProductLocator);
    }

    public void clickIncrementProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleCarOfBuyLocator));
        for (int i = 0; i < 2; i++) {

            getIncrementProduct(i).click();
        }
    }

    public void clickSeeShoppingBag() {
        wait.until(ExpectedConditions.elementToBeClickable(seeBuyCarLocator));
        driver.findElement(seeBuyCarLocator).click();
    }

    public String getTitleOrderSummary() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(OrderSummaryLocator));
        return driver.findElement(OrderSummaryLocator).getText();
    }
}