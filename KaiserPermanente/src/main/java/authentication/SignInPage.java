package authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignInPage {
   // @FindBy(css="#kp-header-login-link")
    //public WebElement signInElement;
    @FindBy(css="#userid")
    public WebElement userNameInputField;
    @FindBy(css="#password")
    public WebElement passwordInputField;
    @FindBy(id="Submit")
    public WebElement clickButtonElement;

    /*public WebElement getSignInElement() {
        return signInElement;
    }

    public void setSignInElement(WebElement signInElement) {
        this.signInElement = signInElement;
    }*/

    public WebElement getUserNameInputField() {
        return userNameInputField;
    }

    public void setUserNameInputField(WebElement userNameInputField) {
        this.userNameInputField = userNameInputField;
    }

    public WebElement getPasswordInputField() {
        return passwordInputField;
    }

    public void setPasswordInputField(WebElement passwordInputField) {
        this.passwordInputField = passwordInputField;
    }

    public WebElement getClickButtonElement() {
        return clickButtonElement;
    }

    public void setClickButtonElement(WebElement clickButtonElement) {
        this.clickButtonElement = clickButtonElement;
    }
   public void clickOnSignInButton()
   {
       getClickButtonElement().click();
   }
   public void typeUserName()
   {
       getUserNameInputField().sendKeys("fatimafayyaz79");
   }
   public void typePasseword()
   {
       getPasswordInputField().sendKeys("Sfmmm1979");
   }
   public void clickOnAuthenticate()
   {
       getClickButtonElement().click();
   }
   public void signInToKaiser(WebDriver driver) {

       //CommonAPI.handleNewTab(driver);
       typeUserName();
       typePasseword();
       clickOnSignInButton();
       Assert.assertEquals(driver.findElement(By.id("_firstName")).getText(),"fatima");
       System.out.println("passed");
   }

}
