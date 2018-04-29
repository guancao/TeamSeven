package homepage;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeMenuPage extends CommonAPI {

    @FindBy(how=How.ID, using="nav")
    List<WebElement> menuItemList;

    //retrieve the menu item information, return a list -- method #1
    public List<String> retrieveMenuTitle(WebDriver driver) throws IOException {
        List<String> menu = new ArrayList<String>();
        menu=getTextLists(driver,"#nav");
        return menu;
    }
    //retrieve the menu item information, return a list  -- method #2
    public List<String> retrieveMenuTitle2(WebDriver driver) throws IOException {
        List<String> menu = new ArrayList<String>();
        menu = findElemsStringListByXpath(driver, readProperties("menuxpath"));
        return menu;
    }

}
