package HandlePopUp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class XoutPopUpwindow {

    @FindBy(xpath="/html/body/div[2]/form/button")
    public WebElement popUpwindow;

    public void handleWindow(){
        if(popUpwindow.isDisplayed()){
            popUpwindow.click();
        }

    }

}
