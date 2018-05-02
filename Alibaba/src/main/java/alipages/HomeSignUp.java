package alipages;

import base.CommonAPIb;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class HomeSignUp extends CommonAPIb {

    public HomeSignUp() {
        super();
     }

    private String filepath = "E:\\WebAutomationTeamSeven\\Alibaba\\src\\test\\resources\\locator.properties";

    public void signUp(WebDriver driver) throws IOException, InterruptedException {
        clickJoinFree();
        Thread.sleep(1000);
        enterEmail("garyclearmind@gmail.com");
        keyDownAndSlide();
        Thread.sleep(1000);
//        fillInCaptcha(driver, "");  //CAPTCHA  can't be automated, have to ask developer to disable it or provide workaround

        driver.switchTo().defaultContent(); //switch out of the frame.
    }

    @FindBy(linkText = "Join Free")
    public WebElement joinFree;
    public void clickJoinFree() {
        joinFree.click();
    }

    @FindBy(xpath = "//input[@id='J_Email']")
    public WebElement email;
    public void enterEmail(String emailAddr) throws IOException {
        driver.switchTo().frame(0); //("#alibaba-register-box");
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arg[0].click();", email);
//        jse.executeScript("arguments[0].setAttribute('value', emailAddr)",email);//        email.click();
//        email.clear();
        email.sendKeys(emailAddr);
    }

    @FindBy(xpath = "//*[@id='nc_1_n1z']")
    public WebElement s_verify;
    public void keyDownAndSlide() {
        Actions action = new Actions(driver);
        action.dragAndDropBy(s_verify, 20, 0).build().perform();
    }

//    @FindBy(xpath = ".//*[@id='nc_1_captcha_input']")
//    public WebElement captcha;
//    public void fillInCaptcha(String str){
//        captcha.sendKeys(str);
//    }
}
