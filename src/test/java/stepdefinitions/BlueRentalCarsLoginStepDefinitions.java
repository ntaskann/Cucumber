package stepdefinitions;

import io.cucumber.java.en.When;
import pages.BlueRentalCarsLoginPage;

import java.util.List;
import java.util.Map;

public class BlueRentalCarsLoginStepDefinitions {

    BlueRentalCarsLoginPage blueRentalCarsLoginPage = new BlueRentalCarsLoginPage();

    @When("kullanici email ve sifre girer")
    public void kullanici_email_ve_sifre_girer(io.cucumber.datatable.DataTable dataTable) {

        //1. List<String> olarak datalari depolayabiliriz
//        List<String> musteriBilgisi = dataTable.row(1);
//
//        blueRentalCarsLoginPage.email.sendKeys(musteriBilgisi.get(0));
//        blueRentalCarsLoginPage.password.sendKeys(musteriBilgisi.get(1));
//        blueRentalCarsLoginPage.login.click();

        //2. Datalari List<Map<String,String>> olarak datalari depolayabiliriz
        List<Map<String, String>> musteriBilgisi = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> w : musteriBilgisi) {
            blueRentalCarsLoginPage.email.sendKeys(w.get("email"));
            blueRentalCarsLoginPage.password.sendKeys(w.get("sifre"));
            blueRentalCarsLoginPage.login.click();
        }


    }


}
