package TestQuote;

import HandlePopUp.XoutPopUpwindow;
import Vehicle.addVehicle;
import addUpto4.AddVehicle;
import getQuote.enterZipCode;
import getQuote.personalinfo;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class testQuoteValue extends enterZipCode {

    @Test
    public void testQuotebyZip() throws InterruptedException {

      enterZipCode zipCode = PageFactory.initElements(driver, enterZipCode.class);
      personalinfo personal = PageFactory.initElements(driver, personalinfo.class);
      addVehicle vehicle = PageFactory.initElements(driver, addVehicle.class);
        XoutPopUpwindow Xout = PageFactory.initElements(driver, XoutPopUpwindow.class);

      zipCode.enterZip();
        Xout.handleWindow();
      personal.clientInfo();
      vehicle.vehicleInput();





    }
}