//package homepagetest;
//
//import base.CommonAPI;
//import homepage.EditionDropdown;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class TestNewsDropdown extends CommonAPI {
//    @FindBy(xpath = "//li/a[@text()='News'")
//    public WebElement newsDropdown;
//    @FindBy(xpath = ".//*[@id='nav']/li/ul/li/a")
//    public List<WebElement> newsList;
//    @FindBy(linkText="INTL Edition")
//    public WebElement firstItem;
//    //    @FindBy(css=".defaultEdition")
//    @FindBy(xpath="//li[@class, 'defaultEdition']")
//    public WebElement secondItem;
//
//    @Test
//    public void testNewsDropdown()throws InterruptedException{
//        EditionDropdown editionPage = PageFactory.initElements(driver, EditionDropdown.class);
//        editionPage.chooseSiteSet(driver, newsDropdown,firstItem);
//        System.out.println(driver.getCurrentUrl());
//    }
//    @Test
//    public void testUslEdition()throws InterruptedException{
//        EditionDropdown editionPage = PageFactory.initElements(driver, EditionDropdown.class);
//        editionPage.chooseSiteSet(driver, newsDropdown,secondItem);
//        System.out.println(driver.getCurrentUrl());
//    }
//}
