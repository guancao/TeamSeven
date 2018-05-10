package HandlePopUp;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class XoutPopUpwindow extends CommonAPI{


    @FindBy(css = ".sfCancelButton")
    public WebElement SuveryWindowWebElement;
    @FindBy(css = ".sfCancelButton")
    public WebElement FeedbackWindowCloseWebElement;


    public WebElement getSuveryWindowWebElement() {
        return SuveryWindowWebElement;
    }

    public void setSuveryWindowWebElement(WebElement suveryWindowWebElement) {
        SuveryWindowWebElement = suveryWindowWebElement;
    }

    public WebElement getFeedbackWindowCloseWebElement() {
        return FeedbackWindowCloseWebElement;
    }

    public void setFeedbackWindowCloseWebElement(WebElement feedbackWindowCloseWebElement) {
        FeedbackWindowCloseWebElement = feedbackWindowCloseWebElement;
    }

    public boolean SurveyWindowDisplayed(WebDriver driver1, String locator){
        boolean value = CommonAPI.isPopUpWindowDisplayed(driver1, locator);
        return value;
    }

    public void closePopUpWindow(WebDriver driver1)throws InterruptedException{
        CommonAPI.sleepFor(2);
        if(SurveyWindowDisplayed(driver1, "submit-button")) {
            getFeedbackWindowCloseWebElement().click();
            CommonAPI.sleepFor(2);
        }
    }

}


