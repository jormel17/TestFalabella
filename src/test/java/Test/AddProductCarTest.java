package Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddProductCarPage;
import pages.HomePage;
import resources.Base;


import java.io.IOException;

public class AddProductCarTest extends Base {
    public static Logger log = LogManager.getLogger(Base.class.getName());
    HomePage pageHome;
    AddProductCarPage pageAddProductCar;
    String expectResultConsola = "Consolas";
    String expectResultBrand = "SONY";
    String expectBuyResume = "Resumen de tu orden";


    @BeforeTest
    public void initialize() throws IOException {
        driver = initializedDriver();
        driver.get(pro.getProperty("url"));
        log.info("Navigate to home page");
    }

    @Test
    public void BaseNavigation() {

        pageHome = new HomePage(driver);
        pageHome.clickCategory();
        pageHome.clickTecnology();
        pageHome.clickConsola();
        Assert.assertEquals(pageHome.getTitleConsola(), expectResultConsola);
        log.info("Successfully validated Text message");

        pageAddProductCar = new AddProductCarPage(driver);
        pageAddProductCar.clickBrand();
        pageAddProductCar.selectChecboxBrand();
        Assert.assertEquals(pageAddProductCar.getBrandFilter(), expectResultBrand);
        log.info("Successfully validated Text message");
        pageAddProductCar.clickBtnSeePorduct();
        Assert.assertTrue(pageAddProductCar.getBtnAddBag().isDisplayed());
        log.info("Successfully validated Text message");

        pageAddProductCar.clickBtnAddProduct();
        pageAddProductCar.clickIncrementProduct();
        pageAddProductCar.clickSeeShoppingBag();
        Assert.assertEquals(pageAddProductCar.getTitleOrderSummary(), expectBuyResume);
        log.info("Test successful");

    }

    @AfterTest
    public void tearDown() {

        driver.close();

    }
}


