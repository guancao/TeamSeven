package homepage;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditionDropdown extends CommonAPI {
//    @FindBy(how=How.CSS, using=".fa.fa-chevron-down.fa-1")
//    public WebElement dropdownSiteSet;
////    @FindBy(css=".home-geo-container>li")
//    @FindBy(linkText="INTL Edition")
//    public WebElement intlEdition;
////    @FindBy(css=".defaultEdition")
//    @FindBy(xpath="//li[@class, 'defaultEdition']")
//    public WebElement usEdition;

     public void chooseSiteSet(WebDriver driver, WebElement dropdown, WebElement edition) throws InterruptedException {
        Actions action = new Actions(driver);
        Thread.sleep(2000);
        action.moveToElement(dropdown).build().perform();
        action.moveToElement(edition).click().build().perform();
        String editionTitle = driver.getTitle();
        System.out.print("The current page title is == "+editionTitle);
    }
}
