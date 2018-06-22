package phppage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Lib;

public class Phphome extends Lib{

//    @FindBy(xpath = "//input[@type='search']")
//    public WebElement searchBox;

    public void searchText(String str){
//        searchBox.sendKeys(str, Keys.ENTER);
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(str, Keys.ENTER);
    }
}
