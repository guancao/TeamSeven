package addUpto4;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddVehicle extends CommonAPI {

    @FindBy(xpath = "//div[@id='vehiclePurchse0']/div[1]/a")
    public WebElement clickNo;

    public void SayNo(){
        clickNo.click();
    }


}
