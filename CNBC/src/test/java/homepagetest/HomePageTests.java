package homepagetest;

import homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePageTests extends HomePage {

//    HomePage hp = PageFactory.initElements(driver, HomePage.class);
//    HomePage hp = new HomePage();   //either PageFactory or HomePage object works

    @Test
    public void testMenu() throws IOException {
        HomePage hp = PageFactory.initElements(driver, HomePage.class);
        List<String> menuFromHomePage = hp.retrieveMenuTitle(driver);
        for (String str : menuFromHomePage)
            System.out.println("from homepage ==" + str);

        List<String> menuitems = new ArrayList<String>();
        menuitems = getTextListXpath("//div/nav/ul/li/a");
        for (String st : menuitems)
            System.out.println("the menu contains:: " + st);
    }


}
