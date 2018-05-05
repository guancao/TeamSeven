package Vehicle;

import checkAPI.CheckAPIMethods;
import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addVehicle extends CommonAPI{

    @FindBy(xpath = "/html/body/div[1]/div[4]/div[2]/div[2]/form/div[1]/div/div/div[2]/div/div/a")
    public WebElement vehicleInfo;

    @FindBy(xpath = "//*[@id=\"sfx_vehicles[0].motorVehicle.ymmb.year_input\"]")
    public WebElement Year;

    @FindBy(xpath= "//*[@id=\"sfx_vehicles[0].motorVehicle.ymmb.make_input\"]")
    public WebElement Make;

    @FindBy(id = "sfx_vehicles[0].motorVehicle.ymmb.model_input")
    public WebElement Model;

    @FindBy(id = "sfx_vehicles[0].motorVehicle.ymmb.bodyStyle_input")
    public WebElement bodyStyle;

    @FindBy(id = "sfx_add-veh-step[0]_Add_btn_input")
    public WebElement add;

    public WebElement getMake() {
        return Make;
    }

    public void setMake(WebElement make) {
        Make = make;
    }

    public WebElement getModel() {
        return Model;
    }

    public void setModel(WebElement model) {
        Model = model;
    }

    public WebElement getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(WebElement bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public void vehicle(){
        vehicleInfo.click();
    }

    public WebElement getYear() {
        return Year;
    }
    public void setYear(WebElement year) {
        Year = year;
    }

    public void selectYear(){
        selectOptionByVisibleText(getYear(), "2018");
    }

    public void selectMake(){
        selectOptionByVisibleText(getMake(), "LAND ROVER");
    }

    public void selectModel(){
        selectOptionByVisibleText(getModel(), "RANGE ROVER SPORT");
    }

    public void seletBody(){
        selectOptionByVisibleText(getBodyStyle(), "SE AWD 4D DSL");
    }

    public void clickAdd(){
        add.click();
    }

    public void vehicleInput() throws InterruptedException {
        vehicle();
        selectYear();
        sleepFor(2);
        selectMake();
        sleepFor(2);
        selectModel();
        seletBody();
        clickAdd();
    }

    }

