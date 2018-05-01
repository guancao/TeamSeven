package alipages;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeSearch extends CommonAPI {

    private WebDriver driver;

    //use Page Object Model -- create it in the page class
    public HomeSearch(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="SearchText")
    WebElement searchbox;

    public void searchItem(String itemName){   //search in the search box
        searchbox.sendKeys(itemName, Keys.ENTER);
    }






}
