package authentication;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestAuthentication extends CommonAPI {

    @Test
    public void signIn() {
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.signInToKaiser(driver);
       // Assert.assertEquals(driver.findElement(By.id("_firstName")).getText(),"fatima");

    }


}