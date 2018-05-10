package linktext;

import authentication.SignInPage;
import authentication.popup.HandlePopup;
import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestLinkTextMember extends CommonAPI{

    @Test
    public void testMembersLinks() throws InterruptedException{
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.signInToKaiser(driver);
        HandlePopup handlePopUp = PageFactory.initElements(driver, HandlePopup.class);
        handlePopUp.closePopUpWindow(driver);
        LinkTextMemberPage linkTextMemberPage =PageFactory.initElements(driver,LinkTextMemberPage.class);
        linkTextMemberPage.clickMembersLinkByHref(driver);
    }
}
