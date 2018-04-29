package homepage;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Parameters;

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
    @Parameters({"filepath"})
    public List<String> retrieveMenuTitle2(WebDriver driver, String filepath) throws IOException {
        List<String> menu = new ArrayList<String>();
        menu = findElemsStringListByXpath(driver, readProperties("menuxpath",filepath), filepath);
        return menu;
    }

}
