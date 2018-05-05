package FindAgent;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ZipCode extends CommonAPI{

    @FindBy(id = "tab4")
    public WebElement agent;

    @FindBy(id = "qam-agent-zip-code-input")
    public WebElement enterZipCode;


    public void clickAgent(){
        agent.click();
    }

    public void inputZipCode(){
        enterZipCode.sendKeys("19047", Keys.ENTER);
    }

    public void ZipCodeInput(){
        clickAgent();
        inputZipCode();
    }

}
