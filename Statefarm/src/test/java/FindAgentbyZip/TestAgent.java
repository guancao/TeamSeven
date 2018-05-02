package FindAgentbyZip;

import FindAgent.ZipCode;
import SearchAgent.PrintAgentName;
import SearchAgent.SetLocation;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestAgent extends ZipCode{

    @Test
    public void AgentByZip(){
        ZipCode zipCode = PageFactory.initElements(driver, ZipCode.class);
        SetLocation setLocation = PageFactory.initElements(driver, SetLocation.class);
        PrintAgentName printName = PageFactory.initElements(driver, PrintAgentName.class);

        zipCode.ZipCodeInput();
        setLocation.location();
        printName.getAgentName();
    }
}
