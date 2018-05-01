package alipages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class HomeSignUp extends CommonAPI {

    public HomeSignUp() {
        super();
     }

    private String filepath = "E:\\WebAutomationTeamSeven\\Alibaba\\src\\test\\resources\\locator.properties";

    public void signUp(WebDriver driver) throws IOException, InterruptedException {
        clickJoinFree(driver);
        Thread.sleep(1000);
        enterEmail(driver,"garyclearmind@gmail.com");
        keyDownAndSlide(driver);
        Thread.sleep(1000);
        fillInCaptcha(driver, "");  //CAPTCHA  can't be automated, have to ask developer to disable it or provide workaround

        driver.switchTo().defaultContent(); //switch out of the frame.
    }

    @FindBy(linkText = "Join Free")
    public WebElement joinFree;

    public void clickJoinFree(WebDriver driver) {
        joinFree.click();
    }

    @FindBy(xpath = "//input[@id='J_Email']")
    public WebElement email;

    public void enterEmail(WebDriver driver, String emailAddr) throws IOException {
        driver.switchTo().frame(0); //("#alibaba-register-box");
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arg[0].click();", email);
//        jse.executeScript("arguments[0].setAttribute('value', emailAddr)",email);//        email.click();
//        email.clear();
        email.sendKeys(emailAddr);
    }

    //   @Parameters({"filepath"})
//    public void enterEmail(String fpath) throws IOException {
//
//        email.sendKeys(readProperties("emailAddress", fpath));
//    }

    @FindBy(xpath = "//*[@id='nc_1_n1z']")
    public WebElement verify;

    public void keyDownAndSlide(WebDriver driver) {
        Actions action = new Actions(driver);
        action.dragAndDropBy(verify, 20, 0).build().perform();
    }

    @FindBy(xpath = ".//*[@id='nc_1_captcha_input']")
    public WebElement captcha;
    public void fillInCaptcha(WebDriver driver, String str){
        captcha.sendKeys(str);
    }
}
