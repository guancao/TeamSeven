package alitests;

import alipages.HomeSignIn;
import base.CommonAPIb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSignIn extends CommonAPIb {

    @Parameters({"user", "password"})
    @Test
    public void testSignIn(@Optional("") String user, @Optional("") String password){
        HomeSignIn hsi= PageFactory.initElements(driver, HomeSignIn.class);
        hsi.signIn(user, password);

    }
}
