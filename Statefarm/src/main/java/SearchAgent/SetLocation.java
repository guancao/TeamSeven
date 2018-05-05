package SearchAgent;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SetLocation extends CommonAPI{

    @FindBy(id = "distance")
    public WebElement radius;

    @FindBy(id = "products")
    public WebElement products;

    @FindBy(id = "search")
    public WebElement Search;

    public void selectMiles(){
        Select select = new Select(radius);
        select.selectByIndex(2);
    }
    public void selectProduct(){
        Select select = new Select(products);
        select.selectByIndex(1);
    }

    public void clickSearch(){
        Search.click();
    }

    public void location(){
        selectMiles();
        selectProduct();
        clickSearch();

    }

}
