package FindAgent;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class SearchAgent extends CommonAPI {

    @FindBy(xpath = "//div[@id='promo1-container']/div[2]/div/ul/li[4]/a")
    public WebElement clickAgents;

    @FindBy(id = "qam-agent-zip-code-input")
    public WebElement enterZipCode;

    @FindBy(id = "distance")
    public WebElement selectDistance;

    @FindBy(id = "products")
    public WebElement selectProduct;

    @FindBy(id = "search")
    public WebElement clickSearch;

    @FindBy(id = "agentMicrositeUrl_B")
    public WebElement agnetName;

    public void searchAgent(){
        clickAgents.click();
    }
    public void zipcode(){
        enterZipCode.sendKeys("19047", Keys.ENTER);
    }
    public void pickDistance(){
        Select select = new Select(selectDistance);
        select.selectByIndex(3);
    }
    public void pickProduct(){
        Select select = new Select(selectProduct);
        select.selectByVisibleText("Auto");
    }
    public void clickSearchButton(){

        clickSearch.click();

    }


    public void findAutoInsuAgent(){
        searchAgent();
        zipcode();
        pickDistance();
        pickProduct();
        clickSearchButton();

    }
}
