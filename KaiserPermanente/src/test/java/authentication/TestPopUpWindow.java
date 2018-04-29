package authentication;

import authentication.popup.HandlePopup;
import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestPopUpWindow extends CommonAPI {

    @Test
    public void testPopUp()throws InterruptedException{
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.signInToKaiser(driver);
        HandlePopup handlePopUp = PageFactory.initElements(driver, HandlePopup.class);
        handlePopUp.closePopUpWindow(driver);
    }


}
