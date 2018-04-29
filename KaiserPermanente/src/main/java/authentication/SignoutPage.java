package authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignoutPage {

    public void signoutToKaiser(WebDriver driver) {

        driver.findElement(By.cssSelector("#select-dropdown-account-selector-topnav")).click();
        driver.findElement(By.cssSelector("#sign_out_link-topnav")).click();
    }
}
