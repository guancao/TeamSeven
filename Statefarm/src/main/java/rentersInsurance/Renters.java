package rentersInsurance;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Renters {

    @FindBy(xpath = "//section[@id='quote-slider']/button[2]")
    public WebElement clickRighArrow;

    @FindBy(id = "renters")
    public WebElement clickRenters;

    @FindBy(id = "quote-main-zip-code-input")
    public WebElement enterZipCode;

    @FindBy(name = "firstName")
    public WebElement enterFirstName;

    @FindBy(name = "lastName")
    public WebElement enterLastName;

    @FindBy(name = "street1")
    public WebElement streetName;

    @FindBy(name = "street2")
    public WebElement aptNumber;

    @FindBy(xpath = "//div[@id='primaryApplicantDOBId']/div[1]/input")
    public WebElement enterMonth;

    @FindBy(xpath = "//div[@id='primaryApplicantDOBId']/div[3]/input")
    public WebElement enterDay;

    @FindBy(xpath = "//div[@id='primaryApplicantDOBId']/div[5]/input")
    public WebElement enterYear;

    @FindBy(id = "buttonContinueId")
    public WebElement clickContinue;


   public void rightArrow(){
       clickRighArrow.click();
       clickRighArrow.click();
   }

   public void rentersTab(){
       clickRenters.click();
   }

   public void zipCode(){
       enterZipCode.sendKeys("19047", Keys.ENTER);
   }

   public void enterName(){
       enterFirstName.sendKeys("Ahejd");
       enterLastName.sendKeys("Jdhenn");
   }

   public void enterAddress(){
       streetName.sendKeys("800 trenton rd");
       aptNumber.sendKeys("231");
   }

   public void enterDOB(){
       enterMonth.sendKeys("11");
       enterDay.sendKeys("21");
       enterYear.sendKeys("1993");
   }

   public void clickContinueBtn(){
       clickContinue.click();
   }

   public void callAllMethods(){
       rightArrow();
       rentersTab();
       zipCode();
       enterName();
       enterAddress();
       enterDOB();
       clickContinueBtn();

   }
}
