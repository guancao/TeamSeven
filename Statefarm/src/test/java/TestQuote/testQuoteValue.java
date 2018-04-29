package TestQuote;

import getQuote.addVehicle;
import getQuote.enterZipCode;
import getQuote.personalinfo;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class testQuoteValue extends enterZipCode {

    @Test
    public void testQuotebyZip() {

      enterZipCode zipCode = PageFactory.initElements(driver, enterZipCode.class);
      personalinfo personal = PageFactory.initElements(driver, personalinfo.class);
      addVehicle vehicle = PageFactory.initElements(driver, addVehicle.class);

      zipCode.enterZip();
      personal.clientInfo();
      vehicle.vehicleInfo();


    }
}