package appointment;

import authentication.SignInPage;
import authentication.popup.HandlePopup;
import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestAppointment extends CommonAPI {

    @Test
    public void testAppointment()throws InterruptedException{
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.signInToKaiser(driver);
        HandlePopup handlePopUp = PageFactory.initElements(driver, HandlePopup.class);
        handlePopUp.closePopUpWindow(driver);
        ScheduleAppointment scheduleAppointment=PageFactory.initElements(driver,ScheduleAppointment.class);
        scheduleAppointment.scheduleAppointment(driver);
    }
}