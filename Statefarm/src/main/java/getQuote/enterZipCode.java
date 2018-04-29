package getQuote;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class enterZipCode extends CommonAPI {


    public WebElement getZipCode() {
        return ZipCode;
    }
    public void setZipCode(WebElement zipCode) {
        ZipCode = zipCode;
    }
    @FindBy (id = "quote-main-zip-code-input")
    public WebElement ZipCode;

    public void enterZipCode(){
        getZipCode().sendKeys("19047", Keys.ENTER);
    }

    public void enterZip(){
        enterZipCode();
    }
    }

