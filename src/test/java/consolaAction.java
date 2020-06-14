import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.addCarPage;
import pages.consolaPage;
import pages.homePage;
import resources.base;


import java.io.IOException;

public class consolaAction extends base {
    public static Logger log = LogManager.getLogger(base.class.getName());
    homePage pageHome;
    consolaPage pageConsola;
    addCarPage pageAddCar;
    String expectResultConsola = "Consolas";
    String expectResultBrand = "SONY";
    String expectBuyResume = "Resumen de tu orden";


    @BeforeTest
    public  void initialize() throws IOException {
        driver = initializedDriver();
        driver.get(pro.getProperty("url"));
        log.info("Navigate to home page");


    }


    @Test(priority = 0)
    public void BaseNavigation()  {

        pageHome = new homePage(driver);
        pageHome.clickCategory();
        pageHome.clickTecnology();
        pageHome.clickConsola();
        Assert.assertEquals(pageHome.getTitleConsola().getText(), expectResultConsola);


    }

    @Test(priority = 1)
    public void SearchProduct() {

        pageConsola = new consolaPage(driver);
        pageConsola.clickBrand();
        pageConsola.selectChecboxBrand();
        Assert.assertEquals(pageConsola.getBrandFilter().getText(), expectResultBrand);
        pageConsola.clickBtnSeePorduct();


    }
    @Test(priority = 2)

    public  void    addProduct() {
        pageAddCar = new addCarPage(driver);
        Assert.assertTrue(pageAddCar.getAddBag().isDisplayed());
        pageAddCar.clickBtnAddProduct();
        pageAddCar.clickIncrementProduct();
        pageAddCar.clickSeekBuyResume();
        Assert.assertEquals(pageAddCar.getBuyResum().getText(),expectBuyResume);

    }

    @AfterTest
    public void tearDown(){

        driver.close();

    }
}


