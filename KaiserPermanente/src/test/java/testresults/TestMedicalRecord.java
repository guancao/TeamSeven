package testresults;

import authentication.SignInPage;
import authentication.popup.HandlePopup;
import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestMedicalRecord extends CommonAPI {

    @Test
    public void testMedicalRecords()throws InterruptedException {
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.signInToKaiser(driver);
        HandlePopup handlePopUp = PageFactory.initElements(driver, HandlePopup.class);
        handlePopUp.closePopUpWindow(driver);
        MedicalRecord medicalRecord=PageFactory.initElements(driver,MedicalRecord.class);
        medicalRecord.getTestResults(driver);

    }

}
