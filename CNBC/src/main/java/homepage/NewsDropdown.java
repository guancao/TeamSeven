//package homepage;
//
//import base.CommonAPI;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.Parameters;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class NewsDropdown extends CommonAPI {
//
//    @Parameters({"filepath"})
//    public List<String> getNewsDropdownList(WebDriver driver, String filepath) throws IOException {
//        List<String> newsList = new ArrayList<>();
//        newsList = findElemsStringListByXpath(driver, readProperties("newsdropdownxpath", filepath), filepath);
//        return newsList;
//    }
//
//    public void newsDropdown(WebDriver driver, WebElement dropdown, WebElement newsItem) throws InterruptedException {
//        Actions action = new Actions(driver);
//        action.moveToElement(dropdown).build().perform();
//        action.moveToElement(newsItem).click().build().perform();
//        String editionTitle = driver.getTitle();
//        System.out.print("The current page title is == "+editionTitle);
//    }
//}
