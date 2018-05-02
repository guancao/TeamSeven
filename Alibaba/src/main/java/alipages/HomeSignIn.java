package alipages;

import base.CommonAPIb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Parameters;

public class HomeSignIn extends CommonAPIb {
//    HomeSignIn(){ super();}
    @FindBy(linkText = "Sign In")
    WebElement signIn;
    public void clickOnSignIn(){
        signIn.click();
    }

    @FindBy(id = "fm-login-id")
    WebElement email;
    @FindBy(id="fm-login-password")
    WebElement pass;
    @FindBy(xpath = ".//*[@id='fm-login-submit']")
    WebElement submit;

    @Parameters({"user", "password"})
    public void signIn(String user, String password){
        clickOnSignIn();
        driver.switchTo().frame(0);
        email.sendKeys(user);
        pass.sendKeys(password);
        submit.click();
    }
}
