package alitests;

import alipages.HomeSignUp;
import base.CommonAPIb;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestSignUp extends CommonAPIb {
    //use Page Obeject Model

    @Test
    public void testSignUp() throws IOException, InterruptedException {
        HomeSignUp sign = PageFactory.initElements(driver, HomeSignUp.class);
        sign.signUp(driver);

    }
}
