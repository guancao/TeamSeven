package alitests;

import alipages.HomeSignIn;
import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSignIn extends CommonAPI {
    @Parameters({"user", "password"})
    @Test
    public void testSignIn(){
        HomeSignIn hsi= PageFactory.initElements(driver, HomeSignIn.class);
        hsi.signIn("user", "password", driver);

    }
}
