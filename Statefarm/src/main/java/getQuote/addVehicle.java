package getQuote;

import base.CommonAPI;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addVehicle extends CommonAPI {

    public void addVehicle(){
        clickOnElement("/html/body/div[1]/div[4]/div[2]/div[2]/form/div[1]/div/div/div[2]/div/div/a");
    }

    public void selectYear(){
        selectType("//*[@id='sfx_vehicles[0].motorVehicle.ymmb.year_input']", "2018");
    }

    public void vehicleInfo(){
        addVehicle();
        selectYear();
    }


}
