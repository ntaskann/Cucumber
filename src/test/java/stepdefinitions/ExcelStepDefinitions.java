package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.BlueRentalCarsHomePage;
import pages.BlueRentalCarsLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelStepDefinitions {
//Page Objelerini Olustur

    BlueRentalCarsHomePage blueRentalCarsHomePage;
    BlueRentalCarsLoginPage blueRentalCarsLoginPage;
    ExcelUtils excelUtils;
    List<Map<String, String>> excelData;

    @Given("kullanici {string} bilgileri ile giris yapar")
    public void kullanici_bilgileri_ile_giris_yapar(String sayfaAdi) throws IOException {
        String path = "./src/test/resources/testdata/mysmoketestdata.xlsx";
        //String sayfa = "customer_info";
        excelUtils = new ExcelUtils(path, sayfaAdi);
        excelData = excelUtils.getDataList();

        for (Map<String, String> data : excelData) {

            blueRentalCarsHomePage = new BlueRentalCarsHomePage();
            blueRentalCarsLoginPage = new BlueRentalCarsLoginPage();

            Driver.getDriver().get(ConfigReader.getProperty("app_url"));
            blueRentalCarsHomePage.firstLogin.click();
            ReusableMethods.waitFor(2);
            blueRentalCarsLoginPage.email.sendKeys(data.get("username"));
            blueRentalCarsLoginPage.password.sendKeys(data.get("password"));
            blueRentalCarsLoginPage.login.click();
            ReusableMethods.waitFor(2);
            assert blueRentalCarsHomePage.userID.isDisplayed();
            ReusableMethods.getScreenshot("Login Goruntusu");
            blueRentalCarsHomePage.userID.click();
            ReusableMethods.waitFor(1);
            blueRentalCarsHomePage.logOutLink.click();
            ReusableMethods.waitFor(1);
            blueRentalCarsHomePage.OK.click();
            ReusableMethods.waitFor(1);
            Driver.closeDriver();


        }


    }
}
