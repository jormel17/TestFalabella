package Test;



import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddProductCarPage;
import pages.HomePage;
import resources.Base;


import java.io.IOException;

public class AddProductCarTest extends Base {

    HomePage pageHome;
    AddProductCarPage pageAddProductCar;
    String brand = "SONY";
    String expectResultConsola = "Consolas";
    String expectResultBrand = "SONY";
    String expectBuyResume = "Resumen de tu orden";

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializedDriver();
        driver.get(pro.getProperty("url"));
    }

    @Test
    public void Navigation() throws InterruptedException {

        pageHome = new HomePage(driver);
        pageHome.clickCategory();
        pageHome.clickTecnology();
        pageHome.clickConsola();
        Assert.assertEquals(pageHome.getTitleConsola(), expectResultConsola);

        pageAddProductCar = new AddProductCarPage(driver);
        pageAddProductCar.clickBrand();

        pageAddProductCar.selectChecboxBrand(brand);
        Thread.sleep(5000);
        Assert.assertEquals(pageAddProductCar.getBrandFilter(), expectResultBrand);
        pageAddProductCar.clickBtnSeePorduct();
        Assert.assertTrue(pageAddProductCar.getBtnAddBag().isDisplayed());

        pageAddProductCar.clickBtnAddProduct();
        pageAddProductCar.clickIncrementProduct();
        pageAddProductCar.clickSeeShoppingBag();
        Assert.assertEquals(pageAddProductCar.getTitleOrderSummary(), expectBuyResume);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}