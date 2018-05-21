package testresults;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MedicalRecord extends CommonAPI {
    @FindBy(xpath = "//*[@id=\"logged_in_topnav\"]/ul/li[2]/a")
    public WebElement goToMedicalLink;
    @FindBy(linkText = "Medical Record")
    public WebElement clickMedicalRecord;
    @FindBy(linkText = "Test results")
    public WebElement clickTestResults;

    public void getTestResults(WebDriver driver)throws InterruptedException
    {
        goToMedicalLink.click();
        sleepFor(2);
        clickMedicalRecord.click();
        sleepFor(2);
        clickTestResults.click();
        sleepFor(2);
    }
}
