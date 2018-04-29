package getQuote;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class personalinfo {

    @FindBy( id = "first_name")
    public WebElement firsName;

    @FindBy (id = "last_name")
    public WebElement lastname;

    @FindBy (id = "street1")
    public WebElement street;

    @FindBy (id = "street2")
    public WebElement apt;

    @FindBy (id = "date_of_birth")
    public WebElement dob;

    @FindBy (id = "btnContinue")
    public WebElement nextVehicle;

    public WebElement getLastname() {
        return lastname;
    }

    public void setLastname(WebElement lastname) {
        this.lastname = lastname;
    }

    public WebElement getStreet() {
        return street;
    }

    public void setStreet(WebElement street) {
        this.street = street;
    }

    public WebElement getApt() {
        return apt;
    }

    public void setApt(WebElement apt) {
        this.apt = apt;
    }

    public WebElement getDob() {
        return dob;
    }

    public void setDob(WebElement dob) {
        this.dob = dob;
    }

    public WebElement getNextVehicle() {
        return nextVehicle;
    }

    public void setNextVehicle(WebElement nextVehicle) {
        this.nextVehicle = nextVehicle;
    }

    public WebElement getFirsName() {
        return firsName;
    }

    public void setFirsName(WebElement firsName) {
        this.firsName = firsName;
    }

    public void enterfirstName(){
        getFirsName().sendKeys("Ytrqkplp");
    }

    public void enterLastName() {
        getLastname().sendKeys("Upolmkh");
    }

    public void enterStreet(){
        getStreet().sendKeys("800 Trenton Road");
    }

    public void enterApt(){
        getApt().sendKeys("290");
    }

    public void enterDOB(){
        getDob().sendKeys("11121990");
    }

    public void clickVehicle(){
        getNextVehicle().click();
    }

    public void clientInfo(){
        enterfirstName();
        enterLastName();
        enterStreet();
        enterApt();
        enterDOB();
        clickVehicle();
    }
}
